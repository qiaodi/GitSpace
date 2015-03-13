package com.youku.ticket.app.utils.cache;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.util.Log;

public class CacheKeyGen {

    protected static MessageDigest messagedigest = null;

    private final static String TAG = CacheKeyGen.class.getSimpleName();

    /**
     * 默认的密码字符串组合，用来将字节转换成 16 进制表示的字符,apache校验下载的文件的正确性用的就是默认的这个组合
     */
    protected static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    static {
        try {
            messagedigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e1) {
            Log.e(TAG, "初始化失败，MessageDigest不支持MD5。");
            try {
                messagedigest = MessageDigest.getInstance("SHA-1");
            } catch (NoSuchAlgorithmException e2) {
                Log.e(TAG, "初始化失败，MessageDigest不支持SHA-1。");
            }
        }
    }

    private static CacheKeyGen mInstance;

    protected CacheKeyGen() {
        // TODO Auto-generated constructor stub
    }

    public static CacheKeyGen getInstance() {
        if (mInstance == null) {
            synchronized (CacheKeyGen.class) {
                mInstance = new CacheKeyGen();
            }
        }
        return mInstance;
    }

    public String getCacheKey(String s) {
        return getDigestString(s.getBytes());
    }

    private static String getDigestString(byte[] bytes) {
        messagedigest.update(bytes);
        return bufferToHex(messagedigest.digest());
    }

    /**
     * description: TODO 二进制转字符串
     * 
     * @creater QIAODI
     * @param bytes
     * @return
     * @date 2015年2月4日 下午3:33:16
     * @editer
     */
    private static String bufferToHex(byte bytes[]) {
        return bufferToHex(bytes, 0, bytes.length);
    }

    private static String bufferToHex(byte bytes[], int m, int n) {
        StringBuffer stringbuffer = new StringBuffer(2 * n);
        int k = m + n;
        for (int l = m; l < k; l++) {
            appendHexPair(bytes[l], stringbuffer);
        }
        return stringbuffer.toString();
    }

    private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
        char c0 = hexDigits[(bt & 0xf0) >> 4]; // 取字节中高 4 位的数字转换, >>> 为逻辑右移，将符号位一起右移,此处未发现两种符号有何不同    
        char c1 = hexDigits[bt & 0xf]; // 取字节中低 4 位的数字转换    
        stringbuffer.append(c0);
        stringbuffer.append(c1);
    }
}
