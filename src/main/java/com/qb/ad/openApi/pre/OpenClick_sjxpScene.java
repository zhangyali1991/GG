package com.qb.ad.openApi.pre;

import com.qb.ad.entity.DataPre;
import org.testng.annotations.Test;

import java.net.UnknownHostException;
import java.util.Map;

import static com.qb.ad.util.ApiUtilsPre.*;

/**
 *
 * 商家小票新增场景--曝光、点击
 *
 *
* */
public class OpenClick_sjxpScene {
    static String gridId = "010202008182005";  //这个park_Id 一定要修改为希望点击的车场010202008133253 010202008187576
    static int open_cnt = 1;
    static int click_cnt = 1;
    static Map<String, String> result_map;
    static String adId = "";//65437254218907648
    static String url = "";

    @Test
    public static void Open_Click() throws Exception {

        try {
            for (int tmp1 = 0; tmp1 < open_cnt; tmp1++) {
                //曝光--获取列表Post请求
                result_map = exposure_sjxpScenePost(gridId, DataPre.partnerId, DataPre.priv_key);

                if (click_cnt-- > 0 && adId != null) {
                    //点击
                    clickScene( adId , gridId, DataPre.partnerId ,DataPre.priv_key);


                }
            }
        } catch (NullPointerException e) {
            System.out.println("曝光失败，空指针异常！");
        } catch (UnknownHostException e) {
            System.out.println("曝光失败，域名无法访问！");
        }
    }
}
