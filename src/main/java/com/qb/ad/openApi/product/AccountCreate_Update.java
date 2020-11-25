package com.qb.ad.openApi.product;

import com.qb.ad.entity.DataProduct;
import org.testng.annotations.Test;

import static com.qb.ad.util.ApiUtilsPro.createAccount;
import static com.qb.ad.util.ApiUtilsPro.updateAccount;

/**
 * *************************生产环境*************************
 * 创建计划：生成密钥，插入密钥到数据库，生成流量主账户
 */
    public class AccountCreate_Update {

    @Test
    public static void accountCreate_Update() throws Exception {

        //生成流量主账户
//        createAccount(DataProduct.pub_key , DataProduct.priv_key );

        //更新流量主账户
        updateAccount(DataProduct.priv_key);
    }

}


