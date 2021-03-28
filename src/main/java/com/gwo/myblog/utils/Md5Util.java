package com.gwo.myblog.utils;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Gwo(1552571230 @ qq.com)
 */
public class Md5Util {

    /**
     * 将16进制映射到字符数组中
     */
    private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public static String encodeByMd5(String originalData) {
        String result = "";
        if (originalData != null) {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] results = md.digest(originalData.getBytes());
                result = byteArrayToHexString(results);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }

        }
        return result.substring(8,24).toUpperCase();

    }

    /**
     * 将字节数组转化为16进制字符串
     *
     * @param bytes
     * @return
     */
    private static String byteArrayToHexString(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(byteToHexString(bytes[i]));
        }
        return sb.toString();
    }

    /**
     * 将一个字节转化为16进制形式的字符串
     *
     * @param b
     * @return
     */
    private static String byteToHexString(byte b) {
        String result = "";
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];

    }
}
