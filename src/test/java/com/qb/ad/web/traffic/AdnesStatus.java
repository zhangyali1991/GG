package com.qb.ad.web.traffic;

import org.junit.Test;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class AdnesStatus {

    @Test
    public void adnesStatus()  {
        String parameter = "{\"status\": \"1\", \"ids\": [3995]}";
        String getMethodName = new Throwable().getStackTrace()[0].getMethodName();
        advertisePost(parameter,getMethodName );
    }


}
