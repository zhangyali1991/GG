package com.qb.ad.openApi.zyl;

import com.alibaba.fastjson.JSONPath;
import com.qb.ad.entity.DataTest;
import com.qb.ad.jdbc.MysqlDeal;
import com.qb.ad.util.ApiUtilsTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

import static com.qb.ad.util.ApiUtilsTest.*;

/*====获取广告列表、点击，增加场景=====
 *
 *
 *
 * */
public class GetAdListScene {
    static int open_cnt=1;
    int click_cnt=1;
    String adId="624-133164052329353216";

    @DataProvider(name = "data")
    public static Object[][] data() {
        return new Object[][]
//                流量主名称,场地名称,广告页，媒体
                {{"ZYL流量主Auto1119113247", "MY车场Auto1119155342", "4", "1"}};
    }


    @Test(dataProvider = "data")
    public void get(String traffic_name, String gridName, String adPosId, String medium) throws Exception {
        //    根据流量主名称找到对应的数据
        String sql = "select id,partner_id,private_key  from traffic_info where traffic_name='" + traffic_name + "'";
        String[] keys = new String[]{"id", "partner_id", "private_key"};
        Map<String, String> sqlMap = MysqlDeal.mysqlDeal(sql, keys);
        String partnerId = sqlMap.get("partner_id");
        String privateKey = sqlMap.get("private_key");
        String traffic_id = sqlMap.get("id");

//       根据场地名称找到对应的数据
        String select_sql_2 = "select id,serial_number from parking_info where traffic_id='" + traffic_id + "' and parking_name='" + gridName + "'";
        String[] str2 = new String[]{"id", "serial_number"};
        Map<String, String> map1 = MysqlDeal.mysqlDeal(select_sql_2, str2);
        String gridId = map1.get("serial_number").split("-")[1];
        for (int tmp1 = 0; tmp1 < open_cnt; tmp1++) {
//       曝光POS请求
//             ApiUtilsTest.exposureScenePost(gridId, partnerId, privateKey, adPosId, medium);
//       点击

            clickScene(adId, gridId, partnerId, privateKey);

//       小程序上报点击
            clickUpScene(adId,gridId, partnerId,privateKey);
        }


    }
}
