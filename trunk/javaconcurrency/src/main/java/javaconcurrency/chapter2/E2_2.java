package javaconcurrency.chapter2;

import java.math.BigInteger;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// UnsafeCountingFactorizer
//NotThreadSafe 在没有同步的情况下统计已处理请求数量的Servlet（不要这么做）
public class E2_2 implements Servlet
{
    private long count = 0;

    public long getCount()
    {
        return this.count;
    }

    @Override
    public void service(ServletRequest req, ServletResponse resp)
    {
        BigInteger i = this.extractFromRequest(req);
        BigInteger[] factors = this.factor(i);
        ++this.count;
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