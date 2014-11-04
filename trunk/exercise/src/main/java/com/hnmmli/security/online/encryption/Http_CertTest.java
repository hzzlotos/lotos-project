package com.hnmmli.security.online.encryption;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Http_CertTest
{
    private static String clientKeyStorePath = "e:/hzz.keystore";

    private static String clientPassword     = "123456";

    public static void main(String[] args)
    {
        try
        {
            URL url = new URL("https://www.hzz.com/examples/");
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            // 使用hostname而不走DNS
            conn.setHostnameVerifier(new NullHostNameVerifier());
            conn.setDoInput(true);
            conn.setDoOutput(true);

            Https_Certificate_Encryption.configSSLSocketFactory(conn, clientPassword, clientKeyStorePath,
                    clientKeyStorePath);

            InputStream is = conn.getInputStream();

            int length = conn.getContentLength();

            DataInputStream dis = new DataInputStream(is);
            byte[] data = new byte[length];
            dis.readFully(data);

            dis.close();
            System.out.println(new String(data));
            conn.disconnect();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}