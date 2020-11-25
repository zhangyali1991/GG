package com.qb.ad.web.ad_manage.v2;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class PlanSummary {

    @Test
    public void planSummary() throws IOException {
        String parameter = "{\"id\":214,\"type\":1}";
        advertisePost( parameter , new Throwable().getStackTrace()[0].getMethodName() );
    }


}
