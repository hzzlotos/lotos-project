package javacore.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javacore.file.FileTest;

public class PathXmlTest extends TestEntityResolver
{
    public static void main(String[] args)
    {
        try
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // factory.setValidating(true); // 是否验证DTD
            factory.setIgnoringElementContentWhitespace(true);// children.item(i)不再有空白字符的了如#text
            DocumentBuilder builder = factory.newDocumentBuilder();
            File f = new File(FileTest.class.getClassLoader().getResource("").getPath() + "pathtest.xml");
            Document document = builder.parse(f);

            XPathFactory xpFactory = XPathFactory.newInstance();
            XPath path = xpFactory.newXPath();
            XPathExpression expr = path.compile("/configuration/database");// /username");
            Object result = expr.evaluate(document, XPathConstants.NODESET);
            NodeList nodes = (NodeList) result;
            for (int i = 0; i < nodes.getLength(); i++)
            {
                Node node = nodes.item(i);
                // System.out.println("==============" + node.getFirstChild().getTextContent());
                expr = path.compile("username");
                String username = expr.evaluate(node);
                System.out.println("------" + username);
            }
            // String username = expr.evaluate(document);
            // System.out.println(username);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}