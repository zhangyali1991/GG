package com.qb.ad.web.ad_manage.v1;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class AdminPlanPartner {

    @Test
    public void adminPlanPartner() throws IOException {
        String parameter = "{\"adsensePositionId\":\"\",\"cityIds\":[],\"scheduleType\":0,\"parkTypeIds\":[],\"parkIds\":[],\"endTime\":\"2030-08-04 18:55:38\",\"startTime\":\"2020-08-04 18:55:38\",\"trafficIds\":[]}";
        String getMethodName = new Throwable().getStackTrace()[0].getMethodName();
        advertisePost(parameter,getMethodName );
    }


}
