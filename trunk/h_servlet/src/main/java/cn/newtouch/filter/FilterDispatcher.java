package cn.newtouch.filter;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import cn.newtouch.annotation.Path;
import cn.newtouch.context.ActionContext;
import cn.newtouch.exception.BaseException;
import cn.newtouch.mappger.ActionMapper;
import cn.newtouch.mappger.BaseMapper;
import cn.newtouch.mappger.MethodMapper;
import cn.newtouch.util.PropertiesUtil;

public class FilterDispatcher implements Filter
{
    private static Set<ActionMapper> actionSets;

    private String                   classFilePackage = PropertiesUtil.getProperties("mvc.properties").getProperty(
                                                              "class_file_package");

    private String                   jspPackage       = PropertiesUtil.getProperties("mvc.properties").getProperty(
                                                              "jsp_package");

    // true：路径严格按照『/类对应名/方法对应名/参数』
    private boolean                  stipulateMode    = true;

    @Override
    public void destroy()
    {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException
    {
        // 获取应用名之后的路径
        String uri = ((HttpServletRequest) request).getRequestURI();
        // 将.jsp/.css/.js/.html等过滤
        if (uri.matches("\\w*\\.\\w*"))
        {
            chain.doFilter(request, response);
            return;
        }
        // 分配url
        try
        {
            if (this.stipulateMode)
            {
                int index = uri.indexOf("/", 1);
                uri = uri.substring(index + 1, uri.length());
                String[] uris = uri.split("/");
                // 给的uris必须是分割好的 1为类路径,2为方法路径
                this.distribute(request, response, chain, uris);
            }
            else
            {
                this.distribute(request, response, chain, uri);
            }
        }
        catch (BaseException e)
        {
            int key = e.getKey();
            if (key == 1)
            {
                System.out.println("没有找到对应的类！");
            }
            else
            {
                System.out.println("没有找到对应的方法！");
            }
            chain.doFilter(request, response);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        actionSets = new HashSet<ActionMapper>();
        File classPath = this.getLocalFile();
        Set<String> classNames = new HashSet<String>();
        if (classPath.isFile())
        {
            throw new ServletException("请输入正确的包路径名");
        }
        else
        {
            this.getFile(classNames, classPath, this.classFilePackage);
        }
        this.initMapper(classNames);
        System.out.println("初始化结束了");
    }

    // 根据名称获取对应mapper
    private BaseMapper getMapper(String uri, Set<? extends BaseMapper> mappers)
    {
        BaseMapper defaultMapper = null;
        for (BaseMapper mapper : mappers)
        {
            if (this.stipulateMode)
            {
                if (mapper.getName().equals(uri))
                {
                    return mapper;
                }
            }
            else
            {
                if (uri.contains(mapper.getName()))
                {
                    return mapper;
                }
                if ("default".equals(mapper.getName()))
                {
                    defaultMapper = mapper;
                }
            }
        }
        return defaultMapper;
    }

    // 分发请求(不严格要求路径格式匹配，但设置了默认路径以及查找不到的路径都会跳向该action的默认路径)
    private void distribute(ServletRequest request, ServletResponse response, FilterChain chain, String uri)
            throws Exception
    {
        ActionMapper am = (ActionMapper) this.getMapper(uri, actionSets);
        // 不在ActionMapper中
        if (null == am)
        {
            throw new BaseException(BaseException.CLASS_NOT_FOUND_KEY);
        }
        String[] mUris = uri.split(am.getName());
        String mUri = "default";
        if (mUris.length > 1)
        {
            mUri = mUris[1];
        }
        MethodMapper mm = (MethodMapper) this.getMapper(mUri, am.getMethodSets());
        this.execute(request, response, chain, am, mm);
    }

    // 分发请求(严格要求路径格式匹配)
    private void distribute(ServletRequest request, ServletResponse response, FilterChain chain, String[] uris)
            throws Exception
    {
        ActionMapper am = (ActionMapper) this.getMapper(uris[0], actionSets);
        // 不在ActionMapper中
        if (null == am)
        {
            throw new BaseException(BaseException.CLASS_NOT_FOUND_KEY);
        }
        MethodMapper mm = (MethodMapper) this.getMapper(uris[1], am.getMethodSets());
        Method m = mm.getMethod();
        if (null == m)
        {
            throw new BaseException(BaseException.MOTHED_NOT_FOUND_KEY);
        }

        this.execute(request, response, chain, am, mm);
    }

    // 根据所查找到的class以及method执行
    private void execute(ServletRequest request, ServletResponse response, FilterChain chain, ActionMapper am,
            MethodMapper mm) throws Exception
    {
        String contextPath = ((HttpServletRequest) request).getContextPath();
        ActionContext.setContext(request, response);
        Object result = mm.getMethod().invoke(am.getClazz().newInstance());
        if (null == result)
        {
            return;
        }
        String resultString = String.valueOf(result);
        if (resultString.contains("redirect:") || mm.getType().equals(Path.PATH_TYPE.REDIRECT))
        {
            response.setContentType("text/html; charset=UTF-8");
            ((HttpServletResponse) response).sendRedirect(contextPath + "/"
                    + resultString.substring("redirect:".length(), resultString.length()));
        }
        else
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/" + this.jspPackage + "/" + resultString
                    + ".jsp");
            dispatcher.forward(request, response);
        }
    }

    // 获取本地action的class资源
    private void getFile(Set<String> fileNames, File file, String pachage)
    {
        if (file.isDirectory())
        {
            for (File f : file.listFiles())
            {
                if (f.isDirectory())
                {
                    pachage = new StringBuffer(pachage).append(".").append(f.getName()).toString();
                }
                this.getFile(fileNames, f, pachage);
            }
        }
        else
        {
            fileNames.add(new StringBuffer(pachage).append(".").append(file.getName().split("\\.")[0]).toString());
        }
    }

    // 获取本地class所处路径
    private File getLocalFile()
    {
        String[] paths = this.classFilePackage.split("\\.");
        StringBuffer path = new StringBuffer(FilterDispatcher.class.getClassLoader().getResource("").getPath());
        for (String str : paths)
        {
            path.append(File.separator + str);
        }
        return new File(path.toString());
    }

    // 初始化mapper
    private void initMapper(Set<String> classNames)
    {
        Set<MethodMapper> mSets = null;
        for (String c : classNames)
        {
            try
            {
                Class<?> clazz = Class.forName(c, false, Thread.currentThread().getContextClassLoader());
                Path cAnno = clazz.getAnnotation(Path.class);
                if (null != cAnno)
                {
                    ActionMapper am = new ActionMapper(cAnno.value(), clazz);
                    Method[] methods = clazz.getMethods();
                    mSets = new HashSet<MethodMapper>();
                    for (Method m : methods)
                    {
                        Path mAnno = m.getAnnotation(Path.class);
                        if (null != mAnno)
                        {
                            Annotation[][] aaa = m.getParameterAnnotations();
                            for (Annotation[] zz : aaa)
                            {
                                System.out.println(zz.getClass());
                            }

                            if (this.stipulateMode)
                            {

                                mSets.add(new MethodMapper(mAnno.value(), m, mAnno.type()));
                            }
                            else
                            {
                                mSets.add(new MethodMapper(StringUtils.isNotEmpty(mAnno.value()) ? mAnno.value()
                                        : "default", m, mAnno.type()));
                            }
                        }
                        am.setMethodSets(mSets);
                    }
                    actionSets.add(am);
                }

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}