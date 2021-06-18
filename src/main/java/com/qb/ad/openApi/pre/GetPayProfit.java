package com.qb.ad.openApi.pre;

import com.alibaba.fastjson.JSONObject;
import com.qb.ad.entity.DataPre;
import com.qb.ad.util.ApiUtilsPre;
import com.qb.ad.util.HttpGG;
import com.zzrb.util.ECCSignUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 场地收益查询接口
 */
public class GetPayProfit {
    @DataProvider(name = "data")
    public Object[][] data(){
        return  new Object[][]{
                //场地Id,开始日期，结束日期，平台
                {"2021场地ID0512150145","2021-06-01","2021-06-08","1"}
        };
    }
    @Test(dataProvider = "data")
    public void getPay(String gridId,String startDate,String endDate,String platform) throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("partnerId", DataPre.partnerId);
        map.put("gridId",gridId);
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        map.put("platform", platform);
        String sign = ECCSignUtil.sign(DataPre.priv_key, map);
        map.put("sign", sign);
        String request = JSONObject.toJSONString(map);
        HttpGG.doPost(DataPre.getPayProfitUrl,request);
    }

}
