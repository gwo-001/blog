package com.gwo.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author Gwo<1 5 5 2 5 7 1 2 3 0 @ qq.com>
 */
@Controller
@RequestMapping("data")
public class DataController {

    @GetMapping("/test")
    @ResponseBody
    public String getData() {
        return "yes";
    }
}
