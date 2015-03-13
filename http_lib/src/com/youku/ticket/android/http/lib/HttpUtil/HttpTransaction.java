/**
 * 
 */
package com.youku.ticket.android.http.lib.HttpUtil;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;

/**
 * @className HttpTransaction
 * @description HTTP数据交互
 * @author LLC
 * @date 2014-12-22 下午5:26:00
 */
public class HttpTransaction {

    private final int RESCODE_200 = 200; // 成功

    private final int RESCODE_301 = 301; //

    private final int RESCODE_302 = 302; //

    private final int RESCODE_303 = 303; //

    private final int RESCODE_307 = 307; //

    private final int RESCODE_503 = 503; // 服务器出错

    private final int RESCODE_504 = 504;//

    /**
     * @fields mHttpUrl : 访问地址
     */
    private String mHttpUrl = null;

    /**
     * @fields mRequestData : Request数据数组
     */
    private byte[] mRequestData = null;

    /**
     * @fields BUFFER_SIZE : 缓存数据大小
     */
    private final int BUFFER_SIZE = 1024;

    /**
     * @fields K_CONNECT_TIME_OUT : 连接超时时间
     */
    private final int K_CONNECT_TIME_OUT = 5000;

    /**
     * 构造函数:
     * 
     * @param url 访问地址
     * @param requestData request数据
     */
    public HttpTransaction(String url, byte[] requestData) {
        this.mHttpUrl = url;
        this.mRequestData = requestData;
    }

    /**
     * description: 返回Response数据
     * 
     * @creater LLC
     * @param aProxy
     * @return
     * @date 2014-12-22 下午5:29:00
     * @editer
     */
    public byte[] getReceiveData(Proxy aProxy) {
        return getHttpData(aProxy);
    }

    /**
     * description: 获取Http返回数据
     * 
     * @creater LLC
     * @param aProxy
     * @return
     * @date 2014-12-22 下午5:29:26
     * @editer
     */
    private byte[] getHttpData(Proxy aProxy) {

        byte[] resultBytes = (byte[]) null;
        byte[] data = new byte[BUFFER_SIZE];

        HttpURLConnection httpURLConnection = null;
        String headerContentLocation = this.mHttpUrl;

        try {
            URL url = new URL(headerContentLocation);

            if (aProxy == null) {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection(aProxy);
            }

            // http访问数据
            if (this.mRequestData == null) {// Get访问方式
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoOutput(false);
            } else {// Post访问方式
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Content-Length", Integer.toString(this.mRequestData.length));
                httpURLConnection.setDoOutput(true);
            }

            httpURLConnection.setConnectTimeout(K_CONNECT_TIME_OUT);
            httpURLConnection.setReadTimeout(K_CONNECT_TIME_OUT);

            if (this.mRequestData != null) {// Post访问方式
                httpURLConnection.setUseCaches(false);
                DataOutputStream dos = new DataOutputStream(httpURLConnection.getOutputStream());
                dos.write(this.mRequestData);
                dos.flush();
                dos.close();
            }

            httpURLConnection.connect();

            int httpStatusCode = httpURLConnection.getResponseCode();

            if (httpStatusCode == RESCODE_503) {
                httpURLConnection.disconnect();
                resultBytes = (byte[]) null;
            } else if ((httpStatusCode == RESCODE_301) || (httpStatusCode == RESCODE_302) || (httpStatusCode == RESCODE_303) || (httpStatusCode == RESCODE_307)) {

                headerContentLocation = httpURLConnection.getHeaderField("Location");

                httpURLConnection.disconnect();
                resultBytes = (byte[]) null;
            } else if (httpStatusCode == RESCODE_200) {
                String contentType = httpURLConnection.getContentType();
                if (contentType != null) {
                    if (contentType.contains("wml")) {
                        httpURLConnection.disconnect();
                    }
                }

                int bytesRead = 0;

                InputStream isData = httpURLConnection.getInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bytesRead = isData.read(data);
                while (-1 != bytesRead) {
                    baos.write(data, 0, bytesRead);
                    bytesRead = isData.read(data);
                }

                resultBytes = baos.toByteArray();
                baos.flush();
                baos.close();
                baos = null;

                httpURLConnection.disconnect();
            } else if (httpStatusCode == RESCODE_504) { // 网络超时
                httpURLConnection.disconnect();
                resultBytes = (byte[]) null;
            } else {
                httpURLConnection.disconnect();
                resultBytes = (byte[]) null;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
            resultBytes = (byte[]) null;
        } catch (IOException e) {
            e.printStackTrace();
            resultBytes = (byte[]) null;
        }

        return resultBytes;
    }

}
