package com.qb.ad.web;

import com.qb.ad.entity.DataTest;
import com.qb.ad.util.HttpGG;

public class Test {

    public static void main(String[] args) throws Exception {
        String adPosId = "1";
        String advertiserId = "342";
        String parkids_id = "813";
        String traffic_id = "177";
        String city = "http://api-inner-sit.anbokeji.net:8000/api-post/select/province-city";
        String url = "http://api-inner-sit.anbokeji.net:8000/api-post/select/advertiser-name";
        HttpGG.doPost2( city,"", DataTest.Access_Token );
    }
}
