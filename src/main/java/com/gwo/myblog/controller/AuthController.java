package com.gwo.myblog.controller;

import com.gwo.myblog.utils.AdvanceResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Gwo(1552571230 @ qq.com)
 * @Classname AuthController
 * @Description TODO
 * @Date 2021/10/28 8:30
 */
@Controller("/auth")
public class AuthController {

    @PostMapping("/signUp")
    @ResponseBody
    public AdvanceResult UserSign(){

        AdvanceResult result = new AdvanceResult(1, "ok");

        return result;
    }

}
