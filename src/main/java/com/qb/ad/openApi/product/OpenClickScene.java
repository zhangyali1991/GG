package com.qb.ad.openApi.product;

import com.qb.ad.entity.DataProduct;
import org.testng.annotations.Test;

import java.net.UnknownHostException;

import static com.qb.ad.entity.DataProduct.click_url;
import static com.qb.ad.util.ApiUtilsPro.*;

public class OpenClickScene {
    static String adPosId = "4";//1入场推送，2出场推送，3输入车牌 ，4支付页面，5付款成功  *****需要创建计划类型*****
    static String gridId = "010202007217849";  //监控：010202007219736   010202007217849
    static int open_cnt = 1;
    static int click_cnt = 1;
    static String result_map;
    static String adId = "3211-134612638067974144";
    static String medium = "1";//1:微信公众号 2:微信小程序

    @Test
    public static void Open_Click() throws Exception {
        try {
            for (int tmp1 = 0; tmp1 < open_cnt; tmp1++) {
//           曝光
                result_map = exposureScene(gridId, DataProduct.partnerId, DataProduct.priv_key, adPosId, medium);
                if (click_cnt-- > 0 && adId != null) {
//           点击 ==  非小程序
                    clickScene(adId, gridId, DataProduct.partnerId, DataProduct.priv_key);
//           点击 == 小程序
                    clickUpScene(adId, gridId, DataProduct.partnerId, DataProduct.priv_key);
                }

            }
        } catch (NullPointerException e) {
            System.out.println("曝光失败，空指针异常！");
        } catch (UnknownHostException e) {
            System.out.println("曝光失败，域名无法访问！");
        }
    }
}
