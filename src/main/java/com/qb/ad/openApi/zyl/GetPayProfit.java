package com.qb.ad.openApi.zyl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.qb.ad.util.ApiUtilsTest;
import com.qb.ad.util.HttpGG;
import com.zzrb.util.ECCSignUtil;
import jdk.net.SocketFlow;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static com.qb.ad.entity.DataTest.getPayProfitUrl;

/**
 * 获取车场收益
 */
public class GetPayProfit {

    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][]{
                //流量主名称,场地Id,开始日期，结束日期，提现平台，1：安泊聚合，2：安泊支付
                {"ZYL流量主Auto0616164654", "010202008118769", "2021-06-01", "2021-06-15", "1"}
        };
    }

    @Test(dataProvider = "data")
    public void getPay(String partnerName, String gridId, String startDate, String endDate, String platform) throws Exception {
        /**
         * 根据流量主名称获取partnerId、private_key
         */
        String partnerId = ApiUtilsTest.getValueByName(partnerName).get("partner_id");
        String private_key = ApiUtilsTest.getValueByName(partnerName).get("private_key");
        //组装参数
        Map<String, String> map = new HashMap<>();
        map.put("partnerId", partnerId);
        map.put("gridId", gridId);
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        map.put("platform", platform);
        String sign = ECCSignUtil.sign(private_key, map);
        map.put("sign", sign);
        String request = JSONObject.toJSONString(map);
        //post请求
        String result = HttpGG.doPost(getPayProfitUrl, request);
        JSONObject obj = JSONObject.parseObject(result);
        Object status=JSONPath.eval(obj, "status");
        if (status.equals("20000000")){
            System.out.println("获取成功");
        }else {
            System.out.println("获取失败");
        }

    }
}
