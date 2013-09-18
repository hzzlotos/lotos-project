//-------------------------------------------------------------------------
// Copyright (c) 2000-2010 Digital. All Rights Reserved.
//
// This software is the confidential and proprietary information of
// Digital
//
// Original author: qingang
//
//-------------------------------------------------------------------------
// LOOSOFT MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
// THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
// TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
// PARTICULAR PURPOSE, OR NON-INFRINGEMENT. UFINITY SHALL NOT BE
// LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
// MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
//
// THIS SOFTWARE IS NOT DESIGNED OR INTENDED FOR USE OR RESALE AS ON-LINE
// CONTROL EQUIPMENT IN HAZARDOUS ENVIRONMENTS REQUIRING FAIL-SAFE
// PERFORMANCE, SUCH AS IN THE OPERATION OF NUCLEAR FACILITIES, AIRCRAFT
// NAVIGATION OR COMMUNICATION SYSTEMS, AIR TRAFFIC CONTROL, DIRECT LIFE
// SUPPORT MACHINES, OR WEAPONS SYSTEMS, IN WHICH THE FAILURE OF THE
// SOFTWARE COULD LEAD DIRECTLY TO DEATH, PERSONAL INJURY, OR SEVERE
// PHYSICAL OR ENVIRONMENTAL DAMAGE ("HIGH RISK ACTIVITIES"). UFINITY
// SPECIFICALLY DISCLAIMS ANY EXPRESS OR IMPLIED WARRANTY OF FITNESS FOR
// HIGH RISK ACTIVITIES.
//-------------------------------------------------------------------------
package cn.newtouch.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * 和http server进行http通讯工具工具类
 * 
 * @version 1.0
 * @since 2011-11-25
 */
public class HttpClientUtil
{
    protected static final Log  log          = LogFactory
                                                     .getLog(HttpClientUtil.class);

    private static final String ENCODING_UTF = "utf-8";

    private final static int    BUFFER       = 1024;

    /**
     * 向一个url发送一个get请求
     * 
     * @param url
     */
    public static String reqUrl(String url)
    {
        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);
        try
        {
            int returnCode = client.executeMethod(method);
            if (returnCode == HttpStatus.SC_NOT_IMPLEMENTED)
            {
                System.err
                        .println("The Post method is not implemented by this URI");
            }
            else
            {
                return method.getResponseBodyAsString();

            }
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
        return null;
    }

    /**
     * 向一个url提交post请求，
     * 
     * @param url
     * @param paramsStr
     *            参数串
     * @param method
     * @return String 请求后返回的串
     */
    public static String post(String url, String paramsStr, String method)
    {

        HttpClient client = new HttpClient();
        HttpMethod httpMethod = new PostMethod(url);
        httpMethod.setQueryString(paramsStr);
        try
        {
            int returnCode = client.executeMethod(httpMethod);
            if (returnCode == HttpStatus.SC_OK)
            {
                return httpMethod.getResponseBodyAsString();
            }
            else
                if (returnCode == HttpStatus.SC_NOT_IMPLEMENTED)
                {
                    System.err
                            .println("The Post method is not implemented by this URI");
                }
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
        finally
        {
            httpMethod.releaseConnection();
        }
        return null;
    }

    /**
     * 
     * List 参数列表
     * 
     * @since 2011-11-25
     * @param url
     * @param params
     *            参数
     * @return
     */
    public static String post(String url, List<LabelValue> params)
    {
        HttpClient client = new HttpClient();
        PostMethod postMethod = new PostMethod(url);

        try
        {
            client.getParams().setContentCharset(ENCODING_UTF);// 设置编码

            for (LabelValue temp : params)
            {
                postMethod.addParameter(new NameValuePair(temp.getValue(), temp
                        .getValue()));// 传递文本框的username及values
            }

            int tmpStatusCode = client.executeMethod(postMethod);

            // 如果成功返回
            if (tmpStatusCode == HttpStatus.SC_OK)
            {
                return postMethod.getResponseBodyAsString();

            }
            else
            {
                return null;
            }
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
        finally
        {
            postMethod.releaseConnection();
        }
        return null;
    }

    /**
     * 下载文件
     * 
     * @param fileUrl
     *            文件url
     * @param path
     *            保持路径
     * @param newFilename
     *            保持新的文件名，如果未null则表示用远文件名保存 如果文件已经存在会抛出文件已经存在异常
     * @return 实现下载成功
     */
    public static void downloadFile(String fileUrl, String path,
            String newFilename) throws Exception
    {
        if (StringUtils.isEmpty(fileUrl))
        {
            throw new Exception("下载地址不能未空");
        }
        if (StringUtils.isEmpty(newFilename))
        {
            newFilename = fileUrl.substring(fileUrl.lastIndexOf("/"));
        }
        HttpClient client = new HttpClient();
        GetMethod httpGet = new GetMethod(fileUrl);
        try
        {
            client.executeMethod(httpGet);

            InputStream in = httpGet.getResponseBodyAsStream();
            File outFile = new File(path + File.separator + newFilename);
            if (outFile.exists())
            {
                throw new Exception("文件已经存在");
            }
            FileOutputStream out = new FileOutputStream(outFile);

            byte[] b = new byte[BUFFER];
            int len = 0;
            while ((len = in.read(b)) != -1)
            {
                out.write(b, 0, len);
            }
            in.close();
            out.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new Exception("下载错误" + e.getMessage());
        }
        finally
        {
            httpGet.releaseConnection();
        }
    }

    /**
     * 
     * 上传文件
     * 
     * @since 2012-1-8
     * @param url
     *            目的URL，向此URL上传数据
     * @param file
     *            待上传的文件
     * @param fileFieldName
     *            form中文件input的name
     * 
     * @param params
     *            提交的参数
     * @throws Exception
     */
    public static void uploadFile(String url, File file, String fileFieldName,
            Map<String, String> params) throws Exception
    {
        String targetURL = url;// 指定URL
        File targetFile = file;// 指定上传文件

        PostMethod filePost = new PostMethod(targetURL);
        try
        {
            List<StringPart> strPartList = new ArrayList<StringPart>();
            // 提交参数
            Set<String> keys = params.keySet();
            for (String key : keys)
            {
                StringPart sp = new StringPart(key, params.get(key), "utf-8");
                strPartList.add(sp);
            }

            Part[] parts = new Part[1 + strPartList.size()];
            parts[0] = new FilePart(fileFieldName, targetFile);
            for (int i = 0; i < strPartList.size(); i++)
            {

                parts[i + 1] = strPartList.get(i);
            }

            filePost.setRequestEntity(new MultipartRequestEntity(parts,
                    filePost.getParams()));
            HttpClient client = new HttpClient();
            client.getHttpConnectionManager().getParams().setConnectionTimeout(
                    5000);
            int status = client.executeMethod(filePost);
            if (status == HttpStatus.SC_OK)
            {
                System.out.println("上传成功");
                // 上传成功
            }
            else
            {
                System.out.println("上传失败");
                throw new Exception("上传失败，服务器返回：" + status);
                // 上传失败
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new Exception("上传失败" + e.getMessage());
        }
        finally
        {
            filePost.releaseConnection();
        }
    }
}
