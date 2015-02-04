package javacore.xml;

import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class TestDom4j
{
    public static String createXmlStr(Map<String, String> params, String rootName)
    {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement(rootName);
        for (Entry<String, String> entry : params.entrySet())
        {
            root.addElement(entry.getKey()).setText(entry.getValue());
            ;
        }
        return document.asXML();
    }

    public static Map<String, String> xmlParse(String str) throws DocumentException
    {
        SAXReader reader = new SAXReader();
        Document doc = reader.read(new StringReader(str));
        List<Node> nodeList = doc.selectNodes("//Head/*");
        Map<String, String> result1 = new HashMap<String, String>();
        for (Node node : nodeList)
        {
            result1.put(node.getName(), node.getText());
        }
        return result1;
    }
}
