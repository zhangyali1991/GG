package com.qb.ad.web.ad_manage.v2;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class AdminPlanCanApi {

    @Test
    public void adminPlanCanApi() throws IOException {
        String parameter = "{\"advertiserId\":362,\"scheduleType\":2}";
        advertisePost( parameter , new Throwable().getStackTrace()[0].getMethodName() );
    }


}
