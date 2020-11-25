package com.qb.ad.web.ad_manage.v2;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class AdminSeletLateAdvertiser {

    @Test
    public void adminSeletLateAdvertiser() throws IOException {
        String parameter = "";
        advertisePost( parameter , new Throwable().getStackTrace()[0].getMethodName() );
    }


}
