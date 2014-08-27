package com.hnmmli.xml.other;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.hnmmli.file.FileTest;

public class TheXmlTest
{

    public static void main(String[] args) throws SAXException, FileNotFoundException, IOException
    {
        // 创建处理文档内容相关事件的处理器
        ContentHandler contentHandler = new MyContentHandler();
        // 创建处理错误事件处理器
        ErrorHandler errorHandler = new MyErrorHandler();
        // 创建处理DTD相关事件的处理器
        DTDHandler dtdHandler = new MyDTDHandler();
        // 创建实体解析器
        EntityResolver entityResolver = new MyEntityResolver();

        // 创建一个XML解析器（通过SAX方式读取解析XML）
        XMLReader reader = XMLReaderFactory.createXMLReader();
        /*
         * 设置解析器的相关特性
         * http://xml.org/sax/features/validation = true 表示开启验证特性
         * http://xml.org/sax/features/namespaces = true 表示开启命名空间特性
         */
        reader.setFeature("http://xml.org/sax/features/validation", true);
        reader.setFeature("http://xml.org/sax/features/namespaces", true);
        // 设置XML解析器的处理文档内容相关事件的处理器
        reader.setContentHandler(contentHandler);
        // 设置XML解析器的处理错误事件处理器
        reader.setErrorHandler(errorHandler);
        // 设置XML解析器的处理DTD相关事件的处理器
        reader.setDTDHandler(dtdHandler);
        // 设置XML解析器的实体解析器
        reader.setEntityResolver(entityResolver);
        // 解析books.xml文档
        reader.parse(new InputSource(new FileReader(FileTest.class.getClassLoader().getResource("").getPath()
                + "books.xml")));
    }

}
