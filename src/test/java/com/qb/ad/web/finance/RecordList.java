package com.qb.ad.web.finance;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class RecordList {

    @Test
    public void recordList() throws IOException {
        String parameter = "{\"trafficIds\": [177], \"pageNo\": 1, \"pageSize\": 10, \"applyTimeStart\": \"\", \"applyTimeEnd\": \"\", \"cityIds\": []}";
//        String parameter ="{\"applyTimeEnd\": \"\",\"applyTimeStart\": \"\",\"cityIds\": [], \"pageNo\": 0,\"pageSize\": 10,\"trafficIds\": [248]}";
        String getMethodName = new Throwable().getStackTrace()[0].getMethodName();
        advertisePost(parameter,getMethodName );

    }


}
