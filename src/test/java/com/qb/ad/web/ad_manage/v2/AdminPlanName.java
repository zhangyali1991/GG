package com.qb.ad.web.ad_manage.v2;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class AdminPlanName {

    @Test
    public void adminPlanName() throws IOException {
        String parameter = "{\"advertiserId\":362}";
        advertisePost( parameter , new Throwable().getStackTrace()[0].getMethodName() );
    }


}
