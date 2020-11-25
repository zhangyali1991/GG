package com.qb.ad.web.advert;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class AdvertiserList {

    @Test
    public void advertiserList() throws IOException {
        String parameter = "{\"advertiserIds\":[],\"cityIds\":[],\"industryType\":\"\",\"pageNo\":1,\"pageSize\":10}";
        String getMethodName = new Throwable().getStackTrace()[0].getMethodName();
        advertisePost(parameter,getMethodName );
    }


}
