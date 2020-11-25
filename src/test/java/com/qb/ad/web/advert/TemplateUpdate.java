package com.qb.ad.web.advert;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class TemplateUpdate {

    @Test
    public void templateUpdate() throws IOException {
        String parameter = "{\"advertiserId\":399,\"templates\":[{\"comment\":\"\",\"enabled\":true,\"id\":241,\"name\":\"\",\"price\":0,\"priceType\":0},{\"comment\":\"\",\"enabled\":false,\"id\":242,\"name\":\"\",\"price\":0,\"priceType\":0},{\"comment\":\"\",\"enabled\":false,\"id\":243,\"name\":\"\",\"price\":0,\"priceType\":0},{\"comment\":\"\",\"enabled\":false,\"id\":244,\"name\":\"\",\"price\":0,\"priceType\":0},{\"comment\":\"\",\"enabled\":false,\"id\":245,\"name\":\"\",\"price\":0,\"priceType\":0}]}";
        String getMethodName = new Throwable().getStackTrace()[0].getMethodName();
        advertisePost(parameter,getMethodName );
    }

}
