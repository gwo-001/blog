package com.gwo.myblog.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Classname AdvanceResult
 * @Description 返回定义
 * @Date 2021/3/23 7:47
 * @Created by Gwo(1552571230@qq.com)
 */
@Data
@AllArgsConstructor
public class AdvanceResult {

    int code;
    String data;
    String message;

    /**
     * 这里只有返回码
     *
     * @param code
     */
    public AdvanceResult(int code) {
        this.code = code;
    }

    /**
     * 这里有返回码和状态
     *
     * @param code
     * @param message
     */
    public AdvanceResult(int code, String message) {
        this.code = code;
        this.data = message;
    }
}
