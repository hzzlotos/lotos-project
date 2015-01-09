package javacore.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class WriteXMLTest
{

    public static void main(String[] args)
    {
        try
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true); // 是否验证DTD
            factory.setIgnoringElementContentWhitespace(true);// children.item(i)不再有空白字符的了如#text
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element rootElement = doc.createElement("Element-aaa");
            Element childElement = doc.createElement("Element-bbb");
            Text textNode = doc.createTextNode("Text-aaa");
            doc.appendChild(rootElement);
            rootElement.appendChild(childElement);
            childElement.appendChild(textNode);
            rootElement.setAttribute("url", "192.168.100.102/我是中文");

            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();

            transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "SYSTEM_ID");
            transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "PUBLIC_ID");
            /* 编码 */
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            /* 换行 */
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            /* method = "xml" | "html" | "text" */
            transformer.setOutputProperty(OutputKeys.METHOD, "xml"); // 生成xml
            // transformer.setOutputProperty(OutputKeys.METHOD, "html");//生成的html
            // transformer.setOutputProperty(OutputKeys.METHOD, "text");// 只填写 Text 属性的东西
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("F:/text.xml"));
            transformer.transform(source, result);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}