package com.qb.ad.web.traffic;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class GetParkUpdate {

    @Test
    public void getParkUpdate() throws IOException {
        String parameter = "{\"id\": 998, \"status\": \"0\", \"typeId\": 0, \"cityId\": 3}";
        String getMethodName = new Throwable().getStackTrace()[0].getMethodName();
        advertisePost(parameter,getMethodName );
    }

}
