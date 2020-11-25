package com.qb.ad.web.advert;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class AdvertiserUpdate {

    @Test
    public void advertiserUpdate() throws IOException {
        String parameter = "{\"cityId\":3,\"clientType\":1,\"comment\":\"\",\"contactName\":\"银1\",\"id\":401,\"industryType\":\"外卖\",\"managerName\":\"银2\",\"mobile\":\"15901189030\",\"name\":\"广告主07车场60分钟后曝光异常\",\"status\":1}";
        String getMethodName = new Throwable().getStackTrace()[0].getMethodName();
        advertisePost(parameter,getMethodName );
    }

}
