package com.qb.ad.web.finance;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class ReviewList {

    @Test
    public void reviewList() throws IOException {
        String parameter = "{\"trafficIds\": [177], \"pageNo\": 1, \"pageSize\": 10, \"applyTimeStart\": \"\", \"applyTimeEnd\": \"\", \"status\": \"1\",\"cityIds\":[]}";
        String getMethodName = new Throwable().getStackTrace()[0].getMethodName();
        advertisePost(parameter,getMethodName );
    }


}
