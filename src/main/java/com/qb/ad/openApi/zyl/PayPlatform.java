package com.qb.ad.openApi.zyl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.qb.ad.util.ApiUtilsTest;
import com.qb.ad.util.HttpGG;
import com.zzrb.util.ECCSignUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static com.qb.ad.entity.DataTest.payPlatformUrl;

/**
 * 根据流量主ID,场地ID，开启或关闭安泊广告平台收益提现。
 */
public class PayPlatform {
    @DataProvider(name = "data")
    public Object[][] payData() {
        return new Object[][]{
                //流量主名称,场地id,提现平台1：安泊聚合，2：安泊支付
                {"ZYL流量主Auto0616164654", "010202008118769", "1"}
        };
    }

    @Test(dataProvider = "data")
    public void pay(String partnerName, String gridId, String platform) throws Exception {
        //根据流量主名称获取partnerId/private_key
        String partnerId = ApiUtilsTest.getValueByName(partnerName).get("partner_id");
        String private_key = ApiUtilsTest.getValueByName(partnerName).get("private_key");
        //组装参数
        Map<String, String> map = new HashMap<>();
        map.put("partnerId", partnerId);
        map.put("gridId", gridId);
        map.put("platform", platform);//提现平台，1：安泊聚合，2：安泊支付
        String sign = ECCSignUtil.sign(private_key, map);
        map.put("sign", sign);
        String json = JSONObject.toJSONString(map);
        //post请求
        String result=HttpGG.doPost(payPlatformUrl, json);
        JSONObject object=JSONObject.parseObject(result);
       Object status= JSONPath.eval(object,"status");
       if (status=="20000000") {
           System.out.println("修改成功");
       }
       else {
           System.out.println("修改失败");
       }

    }
}
