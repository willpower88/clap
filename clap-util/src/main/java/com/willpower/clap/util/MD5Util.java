package com.willpower.clap.util;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.util.DigestUtils;

/**
 * Created by Powersoft on 2019/4/9.
 */
public class MD5Util {

    //盐，用于混交md5
    private static final String salt = "&%5123***&&%%$$#@";
    /**
     * 生成md5
     * @param
     * @return
     */
    public static String genMD5(String str) {
        String md5 = DigestUtils.md5DigestAsHex(str.getBytes());
        return md5;
    }

    public static void main(String[] args) {
        System.out.println(new SecureRandomNumberGenerator().nextBytes().toHex());
    }



    public static final String genSaltMD5(String password, String salt){
        //加密方式
        String hashAlgorithmName = "MD5";
        //盐：为了即使相同的密码不同的盐加密后的结果也不同
        ByteSource byteSalt = ByteSource.Util.bytes(salt);
        //密码
        Object source = password;
        //加密次数
        int hashIterations = 3;
        SimpleHash result = new SimpleHash(hashAlgorithmName, source, byteSalt, hashIterations);
        return result.toString();
    }

}
