package com.qb.ad.web.report;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class AdminPositionTrend {

    @Test
    public void adminPositionTrend() throws IOException {
        String parameter = "{\"adIds\":[],\"advertiserIds\":[],\"cityIds\":[],\"dates\":[],\"pageNo\":1,\"pageSize\":10,\"parkIds\":[],\"trafficIds\":[]}";
        String getMethodName = new Throwable().getStackTrace()[0].getMethodName();
        advertisePost(parameter,getMethodName );
    }


}
