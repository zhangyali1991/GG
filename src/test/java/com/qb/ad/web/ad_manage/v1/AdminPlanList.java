package com.qb.ad.web.ad_manage.v1;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class AdminPlanList {

    @Test
    public void adminPlanList() throws IOException {
        String parameter = "{\"exportFields\":[\"id\",\"advertiserName\",\"clientType\",\"name\",\"industryName\",\"mediaTypeName\",\"positionName\",\"content\",\"rangeTypeName\",\"cityCount\",\"trafficCount\",\"parkTypeCount\",\"parkCount\",\"posCount\",\"priceTypeName\",\"priceUnit\",\"targetShow\",\"price\",\"priceTotal\",\"scheduleType\",\"weight\",\"ceilingCntDaily\",\"startTime\",\"process\",\"endTime\",\"openTotal\",\"clickTotal\",\"clickRatio\",\"createTime\",\"creatorName\",\"updateTime\",\"operatorName\",\"statusName\",\"isSubstitution\",\"comment\"],\"adIds\":[],\"adsensePositionId\":\"\",\"priceType\":\"\",\"status\":\"\",\"planStartTimes\":[],\"planEndTimes\":[],\"scheduleType\":\"\",\"advertiserIds\":[],\"industryId\":\"\",\"isSubstitution\":\"\",\"pageSize\":10,\"pageNo\":1}";
        String getMethodName = new Throwable().getStackTrace()[0].getMethodName();
        advertisePost(parameter,getMethodName );
    }


}
