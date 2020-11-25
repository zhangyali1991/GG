package com.qb.ad.web.report;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class AdminPositionFlow {
//    String results = "";

    @Test
    public void adminPositionFlow() throws IOException {
        String parameter = "{\"adIds\":[],\"advertiserIds\":[],\"cityIds\":[],\"dates\":[],\"pageNo\":1,\"pageSize\":10,\"parkIds\":[],\"trafficIds\":[]}";
        String getMethodName = new Throwable().getStackTrace()[0].getMethodName();
//        System.out.println( "方法名：" + getMethodName );
        advertisePost(parameter,getMethodName );

    }


}
