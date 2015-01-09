package javacore.security.online.encryption;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class NullHostNameVerifier implements HostnameVerifier
{

    @Override
    public boolean verify(String arg0, SSLSession arg1)
    {
        return true;
    }
}