package com.qb.ad.web.traffic;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class AdvertList {

    @Test
    public void advertList() throws IOException {
        String parameter = "{\"adsensePositionId\": \"\", \"cityIds\": [], \"status\": \"\", \"parkingIds\": [], \"trafficIds\": [], \"typeIds\": [], \"pageNo\": 1, \"pageSize\": 10, \"status\":\"\"}";
        String getMethodName = new Throwable().getStackTrace()[0].getMethodName();
        advertisePost(parameter,getMethodName );
    }


}
