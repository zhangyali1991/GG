package com.qb.ad.web.advert;

import com.qb.ad.entity.DataTest;
import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public class AdvertiserCreate {

    @Test
    public void advertiserCreate() throws IOException {
        String parameter = "{\"cityId\":2475,\"clientType\":2,\"contactName\":\"马先生\",\"industryType\":\"外卖\",\"managerName\":\"张小姐\",\"mobile\":\"177"+ randomNumeric(8) +"\",\"name\":\"广告主接口测试" + DataTest.current + "\",\"source\":1,\"status\":0}";
        String getMethodName = new Throwable().getStackTrace()[0].getMethodName();
        advertisePost(parameter,getMethodName );
    }

}
