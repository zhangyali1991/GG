package com.qb.ad.impl;
import org.testng.annotations.Test;

import static com.zzrb.ecc.AnboECCKey.generateKeyPair;
/**
 * 生成密钥方法
 */
public class CreateKey {
    //测试环境生成秘钥对
    @Test
    public static void createKey() throws Exception {
        System.out.println(generateKeyPair());

    }

}
