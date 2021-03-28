package com.gwo.myblog.model.dos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Gwo(1552571230 @ qq.com)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDo {

    String account;

    String userName;

    String password;

    /**
     * 这里是用来验证用户两次输入的密码是否相同
      */
    String verifyPassword;

    String email;

    String teleNum;

}
