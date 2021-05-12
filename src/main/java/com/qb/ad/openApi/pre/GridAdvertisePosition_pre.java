package com.qb.ad.openApi.pre;

import com.qb.ad.entity.DataPre;
import com.qb.ad.jdbc.MysqlDeal;
import org.testng.annotations.Test;
import java.util.Map;
import static com.qb.ad.util.ApiUtilsPre.*;

/**
 * @description: 新增场地信息+更新场地信息+获取场地信息+开通广告页+获取广告页信息
 * @author: zhaoyanfei
 * @date: 2021/4
 */
public class GridAdvertisePosition_pre {
    static String adPosIds = "6";//1#2#3#4#5  1入场推送，2出场推送，3输入车牌 ，4支付页面，5付款成功,6自定义广告页···
    static String scene = "26";//场景枚举如下
    //3场内停车4路测停车5汽车充电桩6洗车7按摩椅8体重秤9摇摇车10兑币机11娃娃机12唱歌机13互动拍照14商场大屏互动游戏
    // 15店头互动游戏16互动游戏17售货机18共享纸巾19共享雨伞20共享打印机21共享充电宝22洗衣机23派样机24聚合支付25聚合设备26智慧迎宾屏幕

    @Test
    public static void createGridAdvertisePosition() throws Exception {

        //创建场地——根据traffic_name新增场地
      // String gridId = createGrid(DataPre.partnerId, DataPre.priv_key, scene);
       //更新场地信息
        String gridId ="2021gridID0512145102";
      //  updateGrid(gridId,DataPre.partnerId, DataPre.priv_key, scene);
         //获取车场
        //String gridId ="";
       // getGrid(gridId, DataPre.partnerId);
        //新增广告页
       createSceneAdvertisePosition(adPosIds, gridId, DataPre.partnerId, DataPre.priv_key);
        //获取广告也
       // getSceneAdvertisePosition(gridId, DataPre.partnerId);
    }

}
