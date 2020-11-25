package com.qb.ad.web.advert;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class AdvertiserInfo {

    @Test
    public void advertiserInfo() throws IOException {
        String parameter = "{\"id\":401}";
        String getMethodName = new Throwable().getStackTrace()[0].getMethodName();
        advertisePost(parameter,getMethodName );
    }

}
