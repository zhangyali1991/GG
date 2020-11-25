package com.qb.ad.web.report;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class AdminPositionProfitExport {

    @Test
    public void adminPositionProfitExport() throws IOException {
        String parameter = "{\"adIds\":[],\"advertiserIds\":[],\"cityIds\":[],\"dates\":[],\"exportFields\":[\"id\",\"createDate\",\"advertiserName\",\"planName\",\"trafficName\",\"parkName\",\"cityName\",\"mediaTypeName\",\"adsensePositionName\",\"openCnt\",\"clickCnt\",\"clickRatio\",\"priceTypeName\",\"priceUnit\",\"price\",\"profitTotal\",\"trafficPriceTypeName\",\"trafficPriceUnit\",\"trafficPrice\",\"trafficProfit\",\"platformProfit\"],\"parkIds\":[],\"trafficIds\":[]}";
        String getMethodName = new Throwable().getStackTrace()[0].getMethodName();
        advertisePost(parameter,getMethodName );
    }


}
