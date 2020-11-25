package com.qb.ad.web.traffic;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class TrafficList {

    @Test
    public void trafficList() throws IOException {
        String parameter = "{\"cityIds\":[],\"entityType\":\"\",\"pageNo\":1,\"pageSize\":10,\"status\":\"\",\"trafficIds\":[],\"userStatus\":\"\"}";
        String getMethodName = new Throwable().getStackTrace()[0].getMethodName();
        advertisePost(parameter,getMethodName );
    }


}
