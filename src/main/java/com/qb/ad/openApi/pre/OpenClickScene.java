package com.qb.ad.openApi.pre;

import com.qb.ad.entity.DataPre;
import org.testng.annotations.Test;

import java.net.UnknownHostException;
import java.util.Map;

import static com.qb.ad.util.ApiUtilsPre.*;

/**
 *
 * 曝光、点击新增场景--获取广告列表、点击、点击上报
 *
 *
 * */
public class OpenClickScene {
    static String adPosId = "6";//1入场推送，2出场推送，3输入车牌 ，4支付页面，5付款成功  *****需要创建计划类型*****

//    文字链接
    static String gridId = "2021场地ID0512150145";  //2021场地ID0512150145   2021场地ID0512150626
    static int open_cnt = 10;
    static int click_cnt =9;
    static String medium = "4";//1-公众号；2-小程序
    static String adId = "808-155008000838012928";//点击必填86868876642152448   94083037642039296

    @Test
    public static void Open_Click() throws Exception {
        try {
            for (int tmp1 = 0; tmp1 < open_cnt; tmp1++) {
                //曝光Post
//                exposure_scene(gridId, DataPre.partnerId, DataPre.priv_key, adPosId, medium);
//                if (click_cnt-- > 0 && adId != null) {
                    //点击
                    clickScene(adId, gridId, DataPre.partnerId, DataPre.priv_key);
                    //点击上报
//                    clickUpScene(adId, gridId, DataPre.partnerId, DataPre.priv_key);

//                }
            }
        } catch (NullPointerException e) {
            System.out.println("曝光失败，空指针异常！");
        } catch (UnknownHostException e) {
            System.out.println("曝光失败，域名无法访问！");
        }
    }
}
