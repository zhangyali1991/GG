package com.qb.ad.web.ad_manage.v1;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class AdminPlanRresource {

    @Test
    public void adminPlanRresource() throws IOException {
        String parameter = "{\"adsensePositionId\": \"\", \"cityIds\": [], \"parkIds\": [], \"parkTypeIds\": [], \"scheduleType\": 0,\"endTime\": \"2030-08-04 12:04:22\",\"startTime\": \"2020-08-04 12:04:22\",\"trafficIds\": []}";
        String getMethodName = new Throwable().getStackTrace()[0].getMethodName();
        advertisePost(parameter,getMethodName );
    }


}
