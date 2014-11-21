package javacore.security.online.encryption;

import java.security.KeyStore;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

public class Https_Certificate_Encryption extends Certificate_Encryption
{
    /**
     * Java密钥库(Java Key Store，JKS)KEY_STORE
     */
    public static final String SunX509 = "SunX509";

    public static final String SSL     = "SSL";

    /**
     * 获得SSLSocektFactory
     * 
     * @param password
     *            密码
     * @param keyStorePath
     *            密钥库路径
     * 
     * @param trustKeyStorePath
     *            信任库路径
     * @return
     * @throws Exception
     */
    private static SSLSocketFactory getSSLSocketFactory(String password, String keyStorePath, String trustKeyStorePath)
            throws Exception
    {
        // 初始化密钥库
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(SunX509);
        KeyStore keyStore = getKeyStore(keyStorePath, password);
        keyManagerFactory.init(keyStore, password.toCharArray());

        // 初始化信任库
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(SunX509);
        KeyStore trustkeyStore = getKeyStore(trustKeyStorePath, password);
        trustManagerFactory.init(trustkeyStore);

        // 初始化SSL上下文
        SSLContext ctx = SSLContext.getInstance(SSL);
        ctx.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);
        SSLSocketFactory sf = ctx.getSocketFactory();

        return sf;
    }

    /**
     * 为HttpsURLConnection配置SSLSocketFactory
     * 
     * @param conn
     *            HttpsURLConnection
     * @param password
     *            密码
     * @param keyStorePath
     *            密钥库路径
     * 
     * @param trustKeyStorePath
     *            信任库路径
     * @throws Exception
     */
    public static void configSSLSocketFactory(HttpsURLConnection conn, String password, String keyStorePath,
            String trustKeyStorePath) throws Exception
    {
        conn.setSSLSocketFactory(getSSLSocketFactory(password, keyStorePath, trustKeyStorePath));
    }
}