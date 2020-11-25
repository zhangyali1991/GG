package com.qb.ad.web.traffic;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class TrafficUpdate {

    @Test
    public void trafficUpdate() throws IOException {
        String parameter = "{\"accountName\":\"周小川\",\"accountNo\":\"00018877777776666\",\"bankName\":\"工商银行\",\"cityId\":3,\"clientType\":\"0\",\"comment\":\"MY流量主Auto0728191845自动化测试\",\"contactMobile\":\"18828191845\",\"contactName\":\"风先生\",\"entityType\":1,\"id\":312,\"manager\":\"张经理\",\"password\":\"******\",\"source\":\"商务谈判\",\"status\":1,\"trafficName\":\"MY流量主Auto0728191845\"}";
        String getMethodName = new Throwable().getStackTrace()[0].getMethodName();
        advertisePost(parameter,getMethodName );
    }


}
