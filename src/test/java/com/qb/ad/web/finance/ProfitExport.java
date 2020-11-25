package com.qb.ad.web.finance;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class ProfitExport {

    @Test
    public void profitExport() throws IOException {
        String parameter = "{\"trafficIds\": [],  \"startTime\": \"2020-07-29\", \"endTime\": \"2020-07-31\", \"exportFields\": [\"id\", \"createDate\", \"trafficCnt\", \"parkCnt\", \"posCnt\", \"profitTotal\", \"profit\", \"profitPlatform\"]}";
        String getMethodName = new Throwable().getStackTrace()[0].getMethodName();
        advertisePost(parameter,getMethodName );
    }


}
