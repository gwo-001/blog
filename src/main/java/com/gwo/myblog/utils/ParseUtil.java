package com.gwo.myblog.utils;

import java.util.Random;

/**
 * @author Gwo(1552571230 @ qq.com)
 */
public class ParseUtil {

    public static String getVerifyCode() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(9));
        }

        return sb.toString();
    }

}
