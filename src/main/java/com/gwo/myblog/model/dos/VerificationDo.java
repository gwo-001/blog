package com.gwo.myblog.model.dos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname VerificationDo
 * @Description 用来校验验证码
 * @Date 2021/3/23 22:06
 * @Created by Gwo(1552571230@qq.com)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VerificationDo {

    String email;

    String verificationCode;

}
