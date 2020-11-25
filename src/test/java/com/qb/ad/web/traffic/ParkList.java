package com.qb.ad.web.traffic;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class ParkList {

    @Test
    public void parkList() throws IOException {
        String parameter = "{\"parkingStatus\": \"\", \"parkingIds\": [], \"cityIds\": [], \"trafficIds\": [], \"typeIds\": [], \"pageNo\": 1, \"pageSize\": 10}";
        String getMethodName = new Throwable().getStackTrace()[0].getMethodName();
        advertisePost(parameter,getMethodName );
    }


}
