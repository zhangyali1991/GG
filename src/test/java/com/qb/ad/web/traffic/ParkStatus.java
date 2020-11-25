package com.qb.ad.web.traffic;

import org.junit.Test;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class ParkStatus {

    @Test
    public void parkStatus() {
        String parameter = "{\"id\": 998, \"status\": \"0\", \"typeId\": 0}";
        String getMethodName = new Throwable().getStackTrace()[0].getMethodName();
        advertisePost(parameter,getMethodName );
    }


}
