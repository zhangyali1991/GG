package com.qb.ad.web.ad_manage.v2;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class AdminPlanChart {

    @Test
    public void adminPlanChart() throws IOException {
        String parameter = "{\"adsensePositionId\":\"\",\"cityIds\":[],\"parkIds\":[],\"parkTypeIds\":[],\"scheduleType\":1,\"priceType\":0,\"endTime\":\"2030-08-04 16:00:58\",\"target\":\"\",\"trafficIds\":[],\"startTime\":\"2020-08-04 16:00:58\"}";
        advertisePost( parameter , new Throwable().getStackTrace()[0].getMethodName() );
    }


}
