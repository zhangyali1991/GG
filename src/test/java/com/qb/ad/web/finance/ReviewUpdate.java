package com.qb.ad.web.finance;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class ReviewUpdate {

    @Test
    public void reviewUpdate() throws IOException {
        String parameter = "{\"status\": \"3\", \"withdrawIds\": [60], \"comment\": \"fsdfsdfsdfdsfsd\"}";
        advertisePost( parameter ,new Throwable().getStackTrace()[0].getMethodName() );
    }


}
