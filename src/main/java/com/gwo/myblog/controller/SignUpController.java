package com.gwo.myblog.controller;

import com.gwo.myblog.service.SignUpService;
import com.gwo.myblog.utils.AdvanceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Classname SignUpController
 * @Description 用户注册
 * @Date 2021/3/22 22:13
 * @Created by Gwo(1552571230@qq.com)
 */
@Controller
public class SignUpController {

    @Autowired
    SignUpService signUpService;

    @PostMapping("/signup")
    @ResponseBody
    public AdvanceResult userSignUpHelper(@Param("account") String account,
                                          @Param("username") String username,
                                          @Param("password") String password,
                                          @Param("email") String email,
                                          @Param("teleNum") String teleNum) {

        int code = 0;
        String message = "FAIL";
        String data = "null";

        return new AdvanceResult(code, message, data);

    }

}
