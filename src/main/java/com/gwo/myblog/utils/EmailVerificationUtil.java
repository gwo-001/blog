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
     * @param user
     * @param verificationDo
     * @param customerCode
     * @return 0：验证码错误 1：验证码正确
     */
    public Integer isVerificationCorrect(UserDo user, VerificationDo verificationDo, String customerCode) {
        int result = 0;

        if (user.getEmail().equals(verificationDo.getEmail()) && verificationDo.getVerificationCode().equals(customerCode)) {
            result = 1;
        }

        return result;

    }

}
