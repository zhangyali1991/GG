package com.qb.ad.openApi.pre;

import com.qb.ad.entity.DataPre;
import org.testng.annotations.Test;

import static com.qb.ad.util.ApiUtilsPre.*;

/**
 * *************************预发布环境*************************
 * 生成流量主账户
 * 更新流量主账户
 */
    public class AccountCreate_Update {

    @Test
    public static void accountCreate_Update() throws Exception {

        //生成流量主账户
//        createAccount(DataPre.pub_key , DataPre.priv_key );

        //更新流量主账户
        updateAccount(DataPre.priv_key);
    }

}


