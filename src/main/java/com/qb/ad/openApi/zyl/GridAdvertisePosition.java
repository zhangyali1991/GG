package com.qb.ad.openApi.zyl;

import com.qb.ad.entity.DataTest;
import com.qb.ad.jdbc.MysqlDeal;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static com.qb.ad.util.ApiUtilsTest.*;


/**
 * @description: 新增场地信息+更新场地信息+获取场地信息+开通广告页+获取广告页信息
 * @author: zhaoyanfei
 * @date: 2021/4
 */
public class GridAdvertisePosition {
    static String traffic_name = "ZYL流量主Auto0422135558"; // 需要新增车场广告位的流量主  运营管理-流量主列表
    static String adPosIds = "36";//1#2#3#4#5  1入场推送，2出场推送，3输入车牌 ，4支付页面，5付款成功,6自定义广告页···
    static String scene = "4";//场景枚举如下
    //3场内停车4路测停车5汽车充电桩6洗车7按摩椅8体重秤9摇摇车10兑币机11娃娃机12唱歌机13互动拍照14商场大屏互动游戏
    // 15店头互动游戏16互动游戏17售货机18共享纸巾19共享雨伞20共享打印机21共享充电宝22洗衣机23派样机24聚合支付25聚合设备26智慧迎宾屏幕

    @Test
    public static void createGridAdvertisePosition() throws Exception {
        //根据流量主名partnerId查出partnerId和private_key
        String select_sql = "SELECT partner_id,private_key FROM traffic_info WHERE traffic_name = '" + traffic_name + "'";
        String[] str = new String[]{"partner_id", "private_key"};
        Map <String, String> selectMap = MysqlDeal.mysqlDeal(select_sql, str);
        System.out.print("selectMap: " + selectMap);
        String partnerId = selectMap.get("partner_id").toString();
        String private_key = selectMap.get("private_key").toString();
        //创建场地——根据traffic_name新增场地
//       String gridId = createGrid(partnerId, private_key, scene);
       //更新场地信息
        String gridId ="2021gridID0422111410";
//        updateGrid(gridId, partnerId, private_key, scene);
        //获取车场
        getGrid(gridId, partnerId);
        //新增广告页
//      String gridId ="2021场地ID0430171503";
//       createSceneAdvertisePosition(adPosIds, gridId, partnerId, private_key);
       /* //获取广告也
//        getSceneAdvertisePosition(gridId, partnerId);*/
    }

}
