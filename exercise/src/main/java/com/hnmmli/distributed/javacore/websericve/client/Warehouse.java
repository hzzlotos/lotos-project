
package com.hnmmli.distributed.javacore.websericve.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Warehouse", targetNamespace = "http://websericve.javacore.distributed.hnmmli.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Warehouse {


    /**
     * 
     * @param description
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPrice", targetNamespace = "http://websericve.javacore.distributed.hnmmli.com/", className = "com.hnmmli.distributed.javacore.websericve.client.GetPrice")
    @ResponseWrapper(localName = "getPriceResponse", targetNamespace = "http://websericve.javacore.distributed.hnmmli.com/", className = "com.hnmmli.distributed.javacore.websericve.client.GetPriceResponse")
    @Action(input = "http://websericve.javacore.distributed.hnmmli.com/Warehouse/getPriceRequest", output = "http://websericve.javacore.distributed.hnmmli.com/Warehouse/getPriceResponse")
    public double getPrice(
        @WebParam(name = "description", targetNamespace = "")
        String description);

}