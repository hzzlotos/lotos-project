package cn.newtouch.framework.filter;

import java.io.File;
import java.io.IOException;
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

import cn.newtouch.framework.anno.Path;
import cn.newtouch.framework.context.ActionContext;
import cn.newtouch.framework.mappger.ActionMapper;
import cn.newtouch.framework.mappger.BaseMapper;
import cn.newtouch.framework.mappger.MethodMapper;
import cn.newtouch.util.PropertiesUtil;

public class FilterDispatcher implements Filter
{
    private static Set<ActionMapper> actionSets;

    private String                   classFilePackage = PropertiesUtil.getProperties("mvc.properties").getProperty(
                                                              "class_file_package");

    private String                   jspPackage       = PropertiesUtil.getProperties("mvc.properties").getProperty(
                                                              "jsp_package");

    @Override
    public void destroy()
    {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException
    {
        String contextPath = ((HttpServletRequest) request).getContextPath();
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
            this.distribute(request, response, chain, uri, contextPath);
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

    private BaseMapper getMapper(String uri, Set<? extends BaseMapper> mappers)
    {
        BaseMapper defaultMapper = null;
        for (BaseMapper mapper : mappers)
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
        return defaultMapper;
    }

    // 分发请求
    private void distribute(ServletRequest request, ServletResponse response, FilterChain chain, String uri,
            String contextPath) throws Exception
    {
        ActionMapper am = (ActionMapper) this.getMapper(uri, actionSets);
        // 不在ActionMapper中
        if (null == am)
        {
            chain.doFilter(request, response);
            return;
        }
        String[] mUris = uri.split(am.getName());
        String mUri = "default";
        if (mUris.length > 1)
        {
            mUri = mUris[1];
        }
        MethodMapper mm = (MethodMapper) this.getMapper(mUri, am.getMethodSets());
        Method m = mm.getMethod();
        if (null == m)
        {
            chain.doFilter(request, response);
            return;
        }
        ActionContext.setContext(request, response);
        Object result = m.invoke(am.getClazz().newInstance());
        if (null == result)
        {
            // chain.doFilter(request, response);
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
            // "/" + am.getName()
            RequestDispatcher dispatcher = request.getRequestDispatcher("/" + this.jspPackage + "/" + resultString
                    + ".jsp");
            dispatcher.forward(request, response);
        }
    }

    // 获取本地action类资源
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

    // 获取本地路径
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
                            mSets.add(new MethodMapper(StringUtils.isNotEmpty(mAnno.value()) ? mAnno.value()
                                    : "default", m, mAnno.type()));
                        }
                        am.setMethodSets(mSets);
                    }
                    mSets.add(new MethodMapper("default", null, null));
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