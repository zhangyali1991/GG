package com.qb.ad.web.ad_manage.v2;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class AdminPlanPark {

    @Test
    public void adminPlanPark() throws IOException {
        String parameter = "{\"adsensePositionId\":\"\",\"cityIds\":[],\"scheduleType\":1,\"parkTypeIds\":[4],\"parkIds\":[],\"endTime\":\"2030-08-04 16:00:58\",\"startTime\":\"2020-08-04 16:00:58\",\"trafficIds\":[]}";
        advertisePost( parameter , new Throwable().getStackTrace()[0].getMethodName() );
    }


}
