package com.qb.ad.web.ad_manage.v2;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class AdminSelectAdvertiser {

    @Test
    public void adminSelectAdvertiser() throws IOException {
        String parameter = "{\"name\":\"测试\"}";
        advertisePost( parameter , new Throwable().getStackTrace()[0].getMethodName() );
    }


}
