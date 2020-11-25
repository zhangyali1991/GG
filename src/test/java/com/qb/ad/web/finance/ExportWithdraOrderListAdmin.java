package com.qb.ad.web.finance;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class ExportWithdraOrderListAdmin {

    @Test
    public void exportWithdraOrderListAdmin() throws IOException {
        String parameter = "{\"trafficIds\": [], \"pageNo\": 1, \"pageSize\": 10, \"applyTimeStart\": \"\", \"applyTimeEnd\": \"\", \"status\": \"2\",\"cityIds\": []}";
        String getMethodName = new Throwable().getStackTrace()[0].getMethodName();
        advertisePost(parameter,getMethodName );
    }


}
