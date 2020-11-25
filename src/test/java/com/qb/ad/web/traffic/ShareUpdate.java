package com.qb.ad.web.traffic;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class ShareUpdate {

    @Test
    public void shareUpdate() throws IOException {
        String parameter = "{\"adPositions\":[{\"comment\":\"test20200731\",\"id\":586,\"price\":254,\"priceType\":0,\"status\":1},{\"comment\":\"test20200731\",\"id\":587,\"price\":409,\"priceType\":0,\"status\":1},{\"comment\":\"test20200731\",\"id\":588,\"price\":310,\"priceType\":1,\"status\":1},{\"comment\":\"test20200731\",\"id\":589,\"price\":1010,\"priceType\":0,\"status\":1},{\"comment\":\"test20200731\",\"id\":590,\"price\":509,\"priceType\":1,\"status\":1}],\"trafficId\":177}";
        String getMethodName = new Throwable().getStackTrace()[0].getMethodName();
        advertisePost(parameter,getMethodName );
    }


}
