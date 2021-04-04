package com.gwo.myblog.utils;

import com.gwo.myblog.model.dos.UserDo;
import com.gwo.myblog.model.dos.VerificationDo;

/**
 * @Classname EmailVerificationUtil
 * @Description 用来邮箱验证码
 * @Date 2021/3/23 22:01
 * @Created by Gwo(1552571230@qq.com)
 */
public class EmailVerificationUtil {



    /**
     * 校验用户的验证码是否正确，以确定是否予以注册
     *
     * @param user 用户
     * @param verificationDo 存在redis中的验证码和邮箱地址
     * @param customerCode 用户输入的验证码
     * @return 0：验证码错误 1：验证码正确
     */
    public static boolean isVerificationCorrect(UserDo user, VerificationDo verificationDo, String customerCode) {
        boolean result = false;

        if (user.getEmail().equals(verificationDo.getEmail()) && verificationDo.getVerificationCode().equals(customerCode)) {
            result = true;
        }

        return result;

    }

}
