package cn.newtouch.web;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import cn.newtouch.util.Struts2Utils;
import cn.newtouch.webservice.UserWebService;

import com.opensymphony.xwork2.ActionSupport;

@Namespace(value = "/")
public class WebServiceClientAction extends ActionSupport
{

    private static final long serialVersionUID = 1L;

    UserWebService            userWebServiceClient;

    @Override
    public String execute() throws Exception
    {
        System.out.println(userWebServiceClient.testStr("hehe"));
        Struts2Utils.renderText("true");
        // 因为直接输出内容而不经过jsp,因此返回null.
        return null;
    }

    @Autowired
    public void setUserWebServiceClient(UserWebService userWebServiceClient)
    {
        this.userWebServiceClient = userWebServiceClient;
    }
}