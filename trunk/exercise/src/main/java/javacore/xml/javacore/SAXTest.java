package javacore.xml.javacore;

import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 * This program demonstrates how to use a SAX parser. The program prints all hyperlinks links of an
 * XHTML web page. <br>
 * Usage: java SAXTest url
 * 
 * @version 1.00 2001-09-29
 * @author Cay Horstmann
 */
public class SAXTest
{
    public static void main(String[] args) throws Exception
    {
        String url;
        if (args.length == 0)
        {
            url = "http://www.w3c.org";
            System.out.println("Using " + url);
        }
        else
        {
            url = args[0];
        }

        DefaultHandler handler = new DefaultHandler() {
            @Override
            public void startElement(String namespaceURI, String lname, String qname, Attributes attrs)
            {
                System.out.println("------------------------------");
                System.out.println("================================");
                System.out.println("namespaceURI=====" + namespaceURI);
                System.out.println("lname=====" + lname);
                System.out.println("qname=====" + qname);
                System.out.println("attrs=====" + attrs.getLength());
                System.out.println("================================");
                if (lname.equals("a") && attrs != null)
                {
                    for (int i = 0; i < attrs.getLength(); i++)
                    {
                        String aname = attrs.getLocalName(i);
                        if (aname.equals("href"))
                        {
                            System.out.println(attrs.getValue(i));
                        }
                    }
                }
                System.out.println("------------------------------");
            }
        };

        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setNamespaceAware(true);
        SAXParser saxParser = factory.newSAXParser();
        InputStream in = new URL(url).openStream();
        saxParser.parse(in, handler);
    }
}