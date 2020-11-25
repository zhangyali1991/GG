package com.qb.ad.web.ad_manage.v1;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class AdminPlanCity {

    @Test
    public void adminPlanCity() throws IOException {
        String parameter = "{\"isCityDataAll\":false,\"startTime\":\"2020-08-04 14:33:46\",\"endTime\":\"2030-08-04 14:33:46\",\"defaultCitys\":[],\"scheduleType\":0,\"adsensePositionId\":5,\"trafficIds\":[],\"parkTypeIds\":[],\"cityIds\":[],\"parkIds\":[]}";
        String getMethodName = new Throwable().getStackTrace()[0].getMethodName();
        advertisePost(parameter,getMethodName );
    }


}
