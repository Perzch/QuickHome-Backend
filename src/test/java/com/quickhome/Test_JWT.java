package com.quickhome;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.KeyPair;


/**
 * @author Tim-h
 * @description 用于加密和解密的测试
 * @creatDate 2023/6/27 9:57
 */
@SpringBootTest
public class Test_JWT {
    @Value("${rsa.private_key}")
    String privateKey;
    @Value("${rsa.public_key}")
    String publicKey;

    @Before
    void contextLoads() {
//        KeyPair pair = SecureUtil.generateKeyPair("RSA");
//        var privateKey = Base64.encode(pair.getPrivate().getEncoded());
//        System.out.println("私钥\t" + privateKey);
//        var publicKey = Base64.encode(pair.getPublic().getEncoded());
//        System.out.println("公钥\t" + publicKey);
//        rsa方式生成公钥和私钥
//        RSA rsa = new RSA();
//        PrivateKey privateKey = rsa.getPrivateKey();
//        PublicKey publicKey = rsa.getPublicKey();
//        System.out.println("私钥\t" + Base64.encode(privateKey.getEncoded()));
//        System.out.println("公钥\t" + Base64.encode(publicKey.getEncoded()));
        KeyPair pair = SecureUtil.generateKeyPair("RSA");
        privateKey = Base64.encode(pair.getPrivate().getEncoded());
        publicKey = Base64.encode(pair.getPublic().getEncoded());
        System.out.println("私钥"+pair.getPrivate());
        System.out.println("转成字符串为:" + Base64.encode(pair.getPrivate().getEncoded()));
        System.out.println("公钥"+pair.getPublic());
        System.out.println("转成字符串为:" + Base64.encode(pair.getPublic().getEncoded()));
    }

    @Test
    void verify() {
//        KeyPair pair = SecureUtil.generateKeyPair("RSA");
//        privateKey = Base64.encode(pair.getPrivate().getEncoded());
//        publicKey = Base64.encode(pair.getPublic().getEncoded());
//        System.out.println("私钥"+pair.getPrivate());
//        System.out.println("转成字符串为:" + Base64.encode(pair.getPrivate().getEncoded()));
//        System.out.println("公钥"+pair.getPublic());
//        System.out.println("转成字符串为:" + Base64.encode(pair.getPublic().getEncoded()));
        String password = "123456";
        RSA rsa = new RSA(privateKey, publicKey);
        byte[] encrypt = rsa.encrypt(password, KeyType.PublicKey);
        System.out.println("加密后的密文为:" + Base64.encode(encrypt));
        byte[] decrypt = rsa.decrypt(encrypt, KeyType.PrivateKey);
        System.out.println("解密后的明文为:" + new String(decrypt));
    }

}
