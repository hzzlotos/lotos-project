package com.hnmmli.xml;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import com.hnmmli.file.FileTest;

public class SAXTest
{
    public static void main(String[] args)
    {
        try
        {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            File f = new File(FileTest.class.getClassLoader().getResource("").getPath() + "test.xml");

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
            parser.parse(f, handler);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}