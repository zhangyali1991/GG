package com.qb.ad.web.ad_manage.v1;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class AdminPlanUpdate {

    @Test
    public void adminPlanUpdate() throws IOException {
        String parameter = "{\"appId\":\"\",\"ceilingCntDaily\":0,\"comment\":\"前端自动化接口测试\",\"content\":\"\",\"endTime\":1911989943000,\"id\":213,\"imageUri\":\"https://anbokeji.oss-cn-hangzhou.aliyuncs.com/images/20200803/46.5202057.jpg\",\"isRedirect\":0,\"isSubstitution\":0,\"scheduleIntervalCnt\":0,\"scheduleIntervalHours\":0,\"scheduleIntervalType\":1,\"startTime\":1596457143000,\"target\":0,\"url\":\"www.baidu.com\",\"weight\":65535}";
        String getMethodName = new Throwable().getStackTrace()[0].getMethodName();
        advertisePost(parameter,getMethodName );
    }


}
