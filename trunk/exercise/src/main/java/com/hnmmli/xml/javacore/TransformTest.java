package com.hnmmli.xml.javacore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.AttributesImpl;

/**
 * This program demonstrates XSL transformations. It applies a transformation to a set of employee
 * records. The records are stored in the file employee.dat and turned into XML format. Specify the
 * stylesheet on the command line, e.g. java TransformTest makeprop.xsl
 * 
 * @version 1.01 2007-06-25
 * @author Cay Horstmann
 */
public class TransformTest
{
    public static void main(String[] args) throws Exception
    {
        String filename;
        if (args.length > 0)
        {
            filename = args[0];
        }
        else
        {
            filename = "makehtml.xsl";
        }
        File styleSheet = new File(TransformTest.class.getClassLoader().getResource("").getPath().toString() + filename);
        StreamSource styleSource = new StreamSource(styleSheet);

        Transformer t = TransformerFactory.newInstance().newTransformer(styleSource);
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.setOutputProperty(OutputKeys.METHOD, "xml");
        t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

        t.transform(new SAXSource(new EmployeeReader(), new InputSource(new FileInputStream(TransformTest.class
                .getClassLoader().getResource("").getPath().toString()
                + "employee.dat"))), new StreamResult(System.out));
    }
}

/**
 * This class reads the flat file employee.dat and reports SAX parser events to act as if it was
 * parsing an XML file.
 */
class EmployeeReader implements XMLReader
{
    @Override
    public void parse(InputSource source) throws IOException, SAXException
    {
        InputStream stream = source.getByteStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(stream));
        String rootElement = "staff";
        AttributesImpl atts = new AttributesImpl();

        if (this.handler == null)
        {
            throw new SAXException("No content handler");
        }

        this.handler.startDocument();
        this.handler.startElement("", rootElement, rootElement, atts);
        String line;
        while ((line = in.readLine()) != null)
        {
            this.handler.startElement("", "employee", "employee", atts);
            StringTokenizer t = new StringTokenizer(line, "|");

            this.handler.startElement("", "name", "name", atts);
            String s = t.nextToken();
            this.handler.characters(s.toCharArray(), 0, s.length());
            this.handler.endElement("", "name", "name");

            this.handler.startElement("", "salary", "salary", atts);
            s = t.nextToken();
            this.handler.characters(s.toCharArray(), 0, s.length());
            this.handler.endElement("", "salary", "salary");

            atts.addAttribute("", "year", "year", "CDATA", t.nextToken());
            atts.addAttribute("", "month", "month", "CDATA", t.nextToken());
            atts.addAttribute("", "day", "day", "CDATA", t.nextToken());
            this.handler.startElement("", "hiredate", "hiredate", atts);
            this.handler.endElement("", "hiredate", "hiredate");
            atts.clear();

            this.handler.endElement("", "employee", "employee");
        }

        this.handler.endElement("", rootElement, rootElement);
        this.handler.endDocument();
    }

    @Override
    public void setContentHandler(ContentHandler newValue)
    {
        this.handler = newValue;
    }

    @Override
    public ContentHandler getContentHandler()
    {
        return this.handler;
    }

    // the following methods are just do-nothing implementations
    @Override
    public void parse(String systemId) throws IOException, SAXException
    {
    }

    @Override
    public void setErrorHandler(ErrorHandler handler)
    {
    }

    @Override
    public ErrorHandler getErrorHandler()
    {
        return null;
    }

    @Override
    public void setDTDHandler(DTDHandler handler)
    {
    }

    @Override
    public DTDHandler getDTDHandler()
    {
        return null;
    }

    @Override
    public void setEntityResolver(EntityResolver resolver)
    {
    }

    @Override
    public EntityResolver getEntityResolver()
    {
        return null;
    }

    @Override
    public void setProperty(String name, Object value)
    {
    }

    @Override
    public Object getProperty(String name)
    {
        return null;
    }

    @Override
    public void setFeature(String name, boolean value)
    {
    }

    @Override
    public boolean getFeature(String name)
    {
        return false;
    }

    private ContentHandler handler;
}