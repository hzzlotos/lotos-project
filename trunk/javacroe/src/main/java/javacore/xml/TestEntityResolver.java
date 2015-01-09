package javacore.xml;

import java.io.FileInputStream;
import java.io.IOException;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javacore.file.FileTest;

public class TestEntityResolver implements EntityResolver
{

    @Override
    public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException
    {
        InputSource source = new InputSource(new FileInputStream(FileTest.class.getClassLoader().getResource("")
                .getPath()
                + "test.dtd"));
        System.out.println("----------------------------");
        return source;
    }
}
