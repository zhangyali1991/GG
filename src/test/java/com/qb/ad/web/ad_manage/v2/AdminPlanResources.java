package com.qb.ad.web.ad_manage.v2;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class AdminPlanResources {

    @Test
    public void adminPlanResources() throws IOException {
        String parameter = "{\"adsensePositionId\":\"\",\"cityIds\":[],\"parkIds\":[],\"parkTypeIds\":[],\"scheduleType\":0,\"endTime\":\"2030-08-04 16:07:28\",\"startTime\":\"2020-08-04 16:07:28\",\"trafficIds\":[]}";
        advertisePost( parameter , new Throwable().getStackTrace()[0].getMethodName() );
    }


}
