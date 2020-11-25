package com.qb.ad.web.finance;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class ProfitList {

    @Test
    public void profitList() throws IOException {
        String parameter = "{\"trafficIds\": [177], \"pageNo\": 1, \"pageSize\": 10, \"startTime\": \"\", \"endTime\": \"\"}";
        String getMethodName = new Throwable().getStackTrace()[0].getMethodName();
        advertisePost(parameter,getMethodName );
    }


}
