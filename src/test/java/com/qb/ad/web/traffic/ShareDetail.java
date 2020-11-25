package com.qb.ad.web.traffic;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class ShareDetail {

    @Test
    public void shareDetail() throws IOException {
        String parameter = "{\"id\": 313}";
        String getMethodName = new Throwable().getStackTrace()[0].getMethodName();
        advertisePost(parameter,getMethodName );
    }


}
