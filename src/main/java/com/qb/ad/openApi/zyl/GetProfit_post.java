package com.qb.ad.openApi.zyl;

import com.alibaba.fastjson.JSON;
import com.qb.ad.jdbc.MysqlDeal;
import com.qb.ad.util.HttpGG;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.qb.ad.entity.DataTest.profit_url;

public class GetProfit_post {

    public static String getPartnerid(String traffic_name) {
        //    根据流量主名称获取流量主id
//        String traffic_name="ZYL流量主Auto1119113247";
        String sql = "SELECT partner_id FROM traffic_info WHERE traffic_name = '" + traffic_name + "'";
        String partner_id = MysqlDeal.mysqlDealsString(sql, "partner_id");
        System.out.println("partner_id="+partner_id);
        return partner_id;
    }

//每次请求的变量
    @DataProvider(name = "data")
    public static Object[][] data() {
        return new Object[][]{
//            流量主id,车场id,收益日期
                {getPartnerid("ZYL流量主Auto1119113247"), "140100202011199128", "2020-11-22"}
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
            String res = HttpGG.doPost(profit_url, str);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("失败");
        }
    }

}
