package com.qb.ad.web.ad_manage.v1;

import com.qb.ad.entity.DataTest;
import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class AdminPlanCreate {

    @Test
    public void adminPlanCreate() throws IOException {
        String parameter = "{\"adsensePositionId\":5,\"advertiserId\":402,\"ceilingCntDaily\":0,\"checkAllData\":false,\"cityIds\":[3],\"comment\":\"前端自动化接口测试\",\"content\":\"\",\"endTime\":1911989943000,\"imageUri\":\"https://anbokeji.oss-cn-hangzhou.aliyuncs.com/images/20200803/46.5202057.jpg\",\"industryId\":4,\"isApi\":0,\"isRedirect\":0,\"mediaType\":1,\"name\":\"前端自动化接口"+DataTest.current +"\",\"parkIds\":[2147483647,845],\"parkTypeIds\":[2147483647,0],\"price\":0,\"priceTotal\":0,\"priceType\":0,\"scheduleIntervalCnt\":0,\"scheduleIntervalHours\":0,\"scheduleIntervalType\":0,\"scheduleType\":1,\"startTime\":1596457143000,\"target\":0,\"trafficIds\":[177],\"url\":\"www.baidu.com\"}";
        String getMethodName = new Throwable().getStackTrace()[0].getMethodName();
        advertisePost(parameter,getMethodName );
    }


}
