package cn.newtouch.filter;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

import cn.newtouch.annotation.Path;
import cn.newtouch.annotation.PathParam;
import cn.newtouch.annotation.RequestParam;
import cn.newtouch.context.ActionContext;
import cn.newtouch.enums.PATH_TYPE;
import cn.newtouch.exception.BaseException;
import cn.newtouch.mappger.ActionMapper;
import cn.newtouch.mappger.BaseMapper;
import cn.newtouch.mappger.MethodMapper;
import cn.newtouch.mappger.ParamMapper;
import cn.newtouch.util.PropertiesUtil;

//action中@Path的限定
//类上只有一级目录
//方法上也只有一级目录，之后的全部归结成参数，参数写法为/{XXX}

//action方法中参数的限定，原因为Java反射中没有取参数名的方法
//使用@PathParam时，@PathParam参数的顺序严格按照@Path中的顺序
//使用@RequestParam时，paramName必须要写，与request中的参数名必须一致
//@PathParam与@RequestParam一起混用，@PathParam写在@RequestParam之前

//路径严格按照『/类对应名/方法对应名/参数』
public class FilterDispatcher implements Filter
{
    private Set<ActionMapper> actionSets;

    private String            classFilePackage = PropertiesUtil.getProperties("mvc.properties").getProperty(
                                                       "class_file_package");

    private String            jspPackage       = PropertiesUtil.getProperties("mvc.properties").getProperty(
                                                       "jsp_package");

    @Override
    public void destroy()
    {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException
    {
        HttpServletRequest hRequest = (HttpServletRequest) request;
        HttpServletResponse hResponse = (HttpServletResponse) response;
        // 获取应用名之后的路径
        String uri = hRequest.getRequestURI();
        String contextPath = hRequest.getContextPath() + "/";
        uri = uri.substring(contextPath.length());
        // 将.jsp/.css/.js/.html等过滤
        if (uri.matches("\\w*\\.\\w*"))
        {
            chain.doFilter(request, response);
            return;
        }
        // 分配url
        try
        {
            String[] uris = uri.split("/");
            // 给的uris必须是分割好的 1为类路径,2为方法路径
            this.distribute(hRequest, hResponse, chain, uris);
        }
        catch (BaseException e)
        {
            int key = e.getErrorKey();
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
        this.actionSets = new HashSet<ActionMapper>();
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
            if (mapper.getName().equals(uri))
            {
                return mapper;
            }
        }
        return defaultMapper;
    }

    // 分发请求(不严格要求路径格式匹配，但设置了默认路径以及查找不到的路径都会跳向该action的默认路径)
    private void distribute(HttpServletRequest request, HttpServletResponse response, FilterChain chain, String uri)
            throws Exception
    {
        ActionMapper am = (ActionMapper) this.getMapper(uri, this.actionSets);
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
    private void distribute(HttpServletRequest request, HttpServletResponse response, FilterChain chain, String[] uris)
            throws Exception
    {
        if (null == uris || uris.length == 0)
        {
            throw new BaseException(BaseException.CLASS_NOT_FOUND_KEY);
        }
        ActionMapper am = (ActionMapper) this.getMapper(uris[0], this.actionSets);
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
    private void execute(HttpServletRequest request, HttpServletResponse response, FilterChain chain, ActionMapper am,
            MethodMapper mm) throws Exception
    {
        ActionContext.setContext(request, response);
        String contextPath = request.getContextPath();
        Object[] params = null;
        if (null != mm.getParams() && mm.getParams().size() > 0)
        {
            params = new Object[mm.getParams().size()];

            String uri = request.getRequestURI();
            int index = uri.indexOf("/", uri.indexOf("/", uri.indexOf("/", 1) + 1) + 1);
            String[] pathParams = null;
            if (index < uri.length())
            {
                pathParams = uri.substring(index + 1, uri.length()).split("/");
            }
            Object param = null;
            for (ParamMapper pm : mm.getParams())
            {
                if (RequestParam.class.equals(pm.getAnnoType()))
                {
                    param = this.transform(request.getParameter(pm.getName()), pm.getClassType());
                }
                if (PathParam.class.equals(pm.getAnnoType()))
                {
                    param = this.transform(pathParams[pm.getIndex()], pm.getClassType());
                }
                params[pm.getIndex()] = param;
            }
        }
        Object result;
        try
        {
            result = mm.getMethod().invoke(am.getClazz().newInstance(), params);
        }
        catch (InvocationTargetException e)
        {
            throw new BaseException(e.getTargetException());
        }
        if (null == result)
        {
            return;
        }
        String resultString = String.valueOf(result);
        String type = request.getHeader("X-Requested-With");
        if (null != type)
        {
            String contentType = "";
            switch (mm.getContentType())
            {
            case XML:
                contentType = "text/xml";
                break;
            case TEXT:
                contentType = "text/plain";
                break;
            default:
                contentType = "text/html";
                break;
            }
            response.setContentType(contentType + ";charset=UTF-8");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.getWriter().write(resultString);
            response.getWriter().flush();
            return;
        }
        if (resultString.contains("redirect:") || mm.getType().equals(PATH_TYPE.REDIRECT))
        {
            response.setContentType("text/html; charset=UTF-8");
            response.sendRedirect(contextPath
                    + "/"
                    + (resultString.contains("redirect:") ? resultString.substring("redirect:".length(),
                            resultString.length()) : resultString));
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
        List<ParamMapper> pList = null;
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
                            if (null != m.getParameterTypes())
                            {
                                pList = new ArrayList<ParamMapper>();
                                for (Class<?> pc : m.getParameterTypes())
                                {
                                    ParamMapper pm = new ParamMapper();
                                    pm.setClassType(pc);
                                    pList.add(pm);
                                }
                                Annotation[][] pannos = m.getParameterAnnotations();
                                for (int i = 0; i < pannos.length; i++)
                                {
                                    pList.get(i).setIndex(i);
                                    pList.get(i).setAnnoType(pannos[i][0].annotationType());
                                    if ((RequestParam.class).equals(pannos[i][0].annotationType()))
                                    {
                                        pList.get(i).setRequired(((RequestParam) pannos[i][0]).required());
                                        pList.get(i).setName(((RequestParam) pannos[i][0]).paramName());
                                    }
                                }
                            }
                            mSets.add(new MethodMapper(mAnno.value().split("/")[0], mAnno.ContentType(), m, pList,
                                    mAnno.type()));

                        }
                        am.setMethodSets(mSets);
                    }
                    this.actionSets.add(am);
                }

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    private Object transform(String value, Class<?> clazz)
    {
        if (Boolean.class.equals(clazz))
        {
            return Boolean.valueOf(value);
        }
        if (Character.class.equals(clazz))
        {
            return Character.valueOf(value.charAt(0));
        }
        if (Short.class.equals(clazz))
        {
            return Short.valueOf(value);
        }
        if (Integer.class.equals(clazz))
        {
            return Integer.valueOf(value);
        }
        if (Long.class.equals(clazz))
        {
            return Long.valueOf(value);
        }
        if (Float.class.equals(clazz))
        {
            return Float.valueOf(value);
        }
        if (Double.class.equals(clazz))
        {
            return Double.valueOf(value);
        }
        return value;
    }
}