package com.qb.ad.web.ad_manage.v1;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class AdminPositionProfit {

    @Test
    public void adminPositionProfit() throws IOException {
        String parameter = "{\"adIds\": [], \"adsensePositionId\": \"\", \"advertiserIds\": [], \"cityIds\": [], \"mediaType\": \"\", \"pageNo\": 1, \"pageSize\": 10, \"dates\": [], \"parkIds\": [],\"trafficIds\": [],\"exportFields\": [\"id\", \"createDate\", \"advertiserName\", \"planName\", \"trafficName\", \"parkName\", \"cityName\",\"mediaTypeName\",\"adsensePositionName\",\"openCnt\",\"clickCnt\",\"clickRatio\",\"priceTypeName\",\"priceUnit\",\"price\",\"profitTotal\",\"trafficPriceTypeName\",\"trafficPriceUnit\",\"trafficPrice\",\"trafficProfit\",\"platformProfit\"]}";
        String getMethodName = new Throwable().getStackTrace()[0].getMethodName();
        advertisePost(parameter,getMethodName );
    }


}
