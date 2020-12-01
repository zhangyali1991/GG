package com.qb.ad.openApi.pre;

import com.alibaba.fastjson.JSON;
import com.qb.ad.entity.DataPre;
import com.qb.ad.util.HttpGG;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.qb.ad.entity.DataPre.profit_url_pre;


public class GetProfit_post {



//每次请求的变量
    @DataProvider(name = "data")
    public static Object[][] data() {
        return new Object[][]{
//            流量主id,车场id,收益日期
                {DataPre.partnerId, "010202008133253", "2020-11-25"}
        };

    }

    @Test(dataProvider = "data")
    public void test(String partnerId, String parkId, String date) {
        Map<String, String> map = new HashMap<>();
        map.put("partnerId", partnerId);
        map.put("parkId", parkId);
        map.put("date", date);
        String str = JSON.toJSONString(map);
        try {
            String res = HttpGG.doPost(profit_url_pre, str);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("失败");
        }
    }

}
