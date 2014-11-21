package javacore.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

public class StAXWriteXMLTest
{
    public static void main(String[] args)
    {
        OutputStream out;
        try
        {
            out = new FileOutputStream(new File("F:/satxTest.xml"));
            XMLOutputFactory factory = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = factory.createXMLStreamWriter(out);
            writer.writeStartDocument();
            writer.writeStartElement("aaa");
            writer.writeAttribute("value", "val");
            writer.writeCharacters("这里是中文测试");
            writer.writeEndElement();
            writer.writeEndDocument();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
