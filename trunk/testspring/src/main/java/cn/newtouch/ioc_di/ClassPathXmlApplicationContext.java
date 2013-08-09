package cn.newtouch.ioc_di;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class ClassPathXmlApplicationContext implements BeanFactory
{

    private Map<String, Object> beans = new HashMap<String, Object>();

    // IOC Inverse of Control DI Dependency Injection
    public ClassPathXmlApplicationContext() throws Exception
    {
        SAXBuilder sb = new SAXBuilder();

        Document doc = sb.build(this.getClass().getClassLoader().getResourceAsStream("testbeans.xml"));
        Element root = doc.getRootElement();
        List<Element> list = root.getChildren("bean");
        for (int i = 0; i < list.size(); i++)
        {
            Element element = list.get(i);
            String id = element.getAttributeValue("id");
            String clazz = element.getAttributeValue("class");
            Object o = Class.forName(clazz).newInstance();
            System.out.println(id);
            System.out.println(clazz);
            this.beans.put(id, o);

            for (Element propertyElement : element.getChildren("property"))
            {
                String name = propertyElement.getAttributeValue("name"); // userDAO
                String bean = propertyElement.getAttributeValue("bean"); // u
                Object beanObject = this.beans.get(bean);// UserDAOImpl instance

                String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
                System.out.println("method name = " + methodName);

                Method m = o.getClass().getMethod(methodName, beanObject.getClass().getInterfaces()[0]);
                m.invoke(o, beanObject);
            }

        }

    }

    public Object getBean(String id)
    {
        return this.beans.get(id);
    }

}
