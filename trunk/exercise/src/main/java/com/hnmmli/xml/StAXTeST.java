package com.hnmmli.xml;

import java.io.InputStream;
import java.net.URL;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

public class StAXTeST
{
    public static void main(String[] args)
    {
        URL url;
        try
        {
            url = new URL("http://www.w3c.org");
            InputStream in = url.openStream();
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader parser = factory.createXMLStreamReader(in);
            while (parser.hasNext())
            {
                int event = parser.next();
                if (event == XMLStreamConstants.START_ELEMENT)
                {
                    String href = parser.getAttributeValue(null, "href");
                    System.out.println("==========" + href);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}