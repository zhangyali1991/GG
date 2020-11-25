package com.qb.ad.web.ad_manage.v2;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class DetailDateList {

    @Test
    public void detailDateList() throws IOException {
        String parameter = "{\"adId\":214,\"adPosId\":5,\"pageNo\":1,\"pageSize\":10,\"exportFields\":[\"adId\",\"advertiserName\",\"adName\",\"mediaTypeName\",\"adPosIdName\",\"adContent\",\"timeRange\",\"openHourCnt\",\"ipCount\",\"clickHourCnt\",\"clickRate\",\"hasAssetUpdatedDesc\",\"operatorName\"]}";
        advertisePost( parameter , new Throwable().getStackTrace()[0].getMethodName() );
    }


}
