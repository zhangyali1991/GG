package com.qb.ad.web.advert;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class SelectCity {

    @Test
    public void selectCity() throws IOException {
        String parameter = "";
        String getMethodName = new Throwable().getStackTrace()[0].getMethodName();
        advertisePost(parameter,getMethodName );
    }

}
