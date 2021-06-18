package com.qb.ad.openApi.pre;

import com.alibaba.fastjson.JSONObject;
import com.qb.ad.entity.DataPre;
import com.qb.ad.util.HttpGG;
import com.zzrb.util.ECCSignUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static com.qb.ad.entity.DataPre.*;

/**
 * 场地收益提现平台接口
 */
public class PayPlatform {
    @DataProvider(name = "data")
    public Object[][] data(){
        return  new Object[][]{
                //场地Id,平台
                {"2021场地ID0512150145","1"}
        };
    }

@Test
    public void payPlat(String gridId,String platform) throws Exception {
    Map<String, String> map = new HashMap<>();
    map.put("partnerId", partnerId);
    map.put("gridId", gridId);
    map.put("platform", platform);//提现平台，1：安泊聚合，2：安泊支付
    String sign = ECCSignUtil.sign(priv_key, map);
    map.put("sign", sign);
    String json = JSONObject.toJSONString(map);
    //post请求
    String result= HttpGG.doPost(payPlatformUrl, json);
}
}
