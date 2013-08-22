package cn.newtouch.ws.test;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class ClientTest
{

    public static void main(String[] args) throws Exception
    {
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost:8080/miniweb/ws/userservice?wsdl");

        Object[] objects = client.invoke("testStr", "hehe");
        System.out.println(objects[0]);
    }
}