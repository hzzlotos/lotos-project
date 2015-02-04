package javaconcurrency.chapter2;

import java.math.BigInteger;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//StatelessFactorizer
//TheadSafe 一个无状态的Servlet
public class E2_1 implements Servlet
{
    @Override
    public void service(ServletRequest req, ServletResponse resp)
    {
        BigInteger i = this.extractFromRequest(req);
        BigInteger[] factors = this.factor(i);
        this.encodeIntResponse(resp, factors);
    }

    private void encodeIntResponse(ServletResponse resp, BigInteger[] factors)
    {
    }

    private BigInteger[] factor(BigInteger i)
    {
        return null;
    }

    private BigInteger extractFromRequest(ServletRequest req)
    {
        return null;
    }

    @Override
    public void init(ServletConfig config) throws ServletException
    {

    }

    @Override
    public ServletConfig getServletConfig()
    {
        return null;
    }

    @Override
    public String getServletInfo()
    {
        return null;
    }

    @Override
    public void destroy()
    {
    }
}