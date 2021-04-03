package com.gwo.myblog.service;

import com.gwo.myblog.mapper.UserDataMapper;
import com.gwo.myblog.model.dos.UserDo;
import com.gwo.myblog.model.dos.VerificationDo;
import com.gwo.myblog.utils.Constants;
import com.gwo.myblog.utils.EmailVerificationUtil;
import com.gwo.myblog.utils.Md5Util;
import com.gwo.myblog.utils.ParseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Classname SignUpService
 * @Description 用户注册服务类
 * @Date 2021/3/23 7:44
 * @author by Gwo(1552571230@qq.com)
 */
@Service
public class SignUpService {

    @Autowired
    UserDataMapper userDataMapper;

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 此方法用来判断用户数据有效性并保存用户数据到数据库
     *
     * @param userDo
     * @return -1:注册失败 1：注册成功`
     */
    public int signUp(UserDo userDo,String customVerifyCode) {

        int result = -1;
        int userEmailType = -1;
        int verifyCodeStatus = -1;
        VerificationDo verificationDo = new VerificationDo();


        // 这里获取用户的注册邮箱类型
        if (userDo.getEmail() != null) {
            String emailStr = userDo.getEmail();
            String[] s = emailStr.split("@");
            // 这里判断用户的邮箱类型
            if (s[1] != null) {
                String emailType = s[1];
                for (int i = 0; i < Constants.SUPPORTED_EMAILS.length; i++) {
                    if (Constants.SUPPORTED_EMAILS.equals(emailType.toLowerCase())) {
                        userEmailType = i;
                        break;
                    }
                }
                if (userEmailType == -1) {
                    result = -1;
                }
            }
        } else {
            return result;
        }

        // 这里在用户邮箱有效的前提下，生成随机的验证码，同时还要存到redis中，设置过期时间为5分钟
        String verifyCode = ParseUtil.getVerifyCode();
        verificationDo.setEmail(userDo.getEmail());
        verificationDo.setVerificationCode(verifyCode);
        redisTemplate.boundValueOps(userDo.getEmail()).;
        redisTemplate.opsForValue().set(userDo.getEmail(),verifyCode);


        // 这里利用邮箱发送验证码来验证是有是邮箱的拥有者来注册的
        boolean isVerificationCorrect=EmailVerificationUtil.isVerificationCorrect(userDo,
                verificationDo,
                customVerifyCode);

        // 这里校验并存储用户的密码（其实校验两次输入密码是否相同的工作可以交给前端以提高效率）
        if (userDo.getPassword() != null) {
            String password = userDo.getPassword();
            String[] tempArray = password.split("");
            // 这里判断下用户的密码是够包含字母和数字
            boolean hasChar = false;
            boolean hasNum = false;
            String charRegex = "[A-z]";
            Pattern charPattern = Pattern.compile(charRegex);
            String numRegex = "[0-9]";
            Pattern numPattern = Pattern.compile(numRegex);
            for (String s : tempArray) {
                Matcher charMatcher = charPattern.matcher(s);
                Matcher numMatcher = numPattern.matcher(s);
                if (charMatcher.matches()) {
                    hasChar = true;
                }
                if (numMatcher.matches()) {
                    hasNum = true;
                }
            }
            if (hasChar && hasNum) {
                String Md5Password = Md5Util.encodeByMd5(password);
                userDo.setPassword(Md5Password);
                userDo.setVerifyPassword(Md5Password);
                userDataMapper.insertUserDataToDB(userDo);
                result = userDataMapper.insertUserDataToDB(userDo);;
            } else {
                result = -1;
            }
        } else {
            result = -1;
        }
        return result;
    }

}
