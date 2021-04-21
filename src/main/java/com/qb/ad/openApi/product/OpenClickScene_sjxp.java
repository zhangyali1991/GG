package com.qb.ad.openApi.product;

import com.qb.ad.entity.DataProduct;
import org.testng.annotations.Test;

import java.net.UnknownHostException;

import static com.qb.ad.util.ApiUtilsPro.*;

/**
 * 曝光、点击新增场景==商家小票曝光、点击
 */
public class OpenClickScene_sjxp {
    static String gridId = "010202008182630";  //监控：010202007219736   010202007217849
    static int open_cnt = 1;
    static int click_cnt = 1;
    static String result_map;
    static String adId = "";
    static String url = "";

    @Test
    public static void Open_Click() throws Exception {


        try {
            for (int tmp1 = 0; tmp1 < open_cnt; tmp1++) {
                   //曝光
                result_map = exposureScene_sjxp(gridId, DataProduct.partnerId, DataProduct.priv_key);
                if (click_cnt-- > 0 && adId != null) {
                    //点击
                    clickScene(adId, gridId, DataProduct.partnerId, DataProduct.priv_key);
                }
            }
        } catch (NullPointerException e) {
            System.out.println("曝光失败，空指针异常！");
        } catch (UnknownHostException e) {
            System.out.println("曝光失败，域名无法访问！");
        }
    }
}
