package javacore.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class XmlTest extends TestEntityResolver
{
    public static void main(String[] args)
    {
        try
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true); // 是否验证DTD
            factory.setIgnoringElementContentWhitespace(true);// children.item(i)不再有空白字符的了如#text
            DocumentBuilder builder = factory.newDocumentBuilder();
            File f = new File(XmlTest.class.getClassLoader().getResource("").getPath() + "test.xml");
            Document document = builder.parse(f);
            Element root = document.getDocumentElement();
            NodeList children = root.getChildNodes();
            for (int i = 0; i < children.getLength(); i++)
            {
                Node child = children.item(i);
                // 如果未添加setIgnoringElementContentWhitespace过滤,则需要此判断确认子节点
                // if (child instanceof Element)
                // {
                Element childElement = (Element) child;
                NamedNodeMap attributes = childElement.getAttributes();
                for (int j = 0; j < attributes.getLength(); j++)
                {
                    Node attribute = attributes.item(j);
                    System.out.println("-----------------" + attribute.getNodeName());
                    System.out.println("-----------------" + attribute.getNodeValue());
                }
                System.out.println("getNodeName=====" + childElement.getNodeName());
                Text textNode = (Text) childElement.getFirstChild();
                System.out.println("value=====" + textNode.getData().trim()); // 最好trim下
                System.out.println("getTagName=====" + childElement.getTagName());
                System.out.println("====================================");
                // }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}