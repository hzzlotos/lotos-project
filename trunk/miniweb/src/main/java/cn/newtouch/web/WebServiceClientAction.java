package cn.newtouch.web;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import cn.newtouch.util.utils.web.struts2.Struts2Utils;
import cn.newtouch.ws.UserWebService;

import com.opensymphony.xwork2.ActionSupport;

@Namespace(value = "/")
public class WebServiceClientAction extends ActionSupport
{

    private static final long serialVersionUID = 1L;

    UserWebService            userWebServiceClient;

    @Override
    public String execute() throws Exception
    {
        System.out.println(this.userWebServiceClient.testStr("hehe"));
        Struts2Utils.renderText("true");
        return null;
    }

    @Autowired
    public void setUserWebServiceClient(UserWebService userWebServiceClient)
    {
        this.userWebServiceClient = userWebServiceClient;
    }
}