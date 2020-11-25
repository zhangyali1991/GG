package com.qb.ad.patner;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.PartnerPost.partnerPost;

public class PartnerTest {

    @Test
    public void PartnerTest() throws IOException {
        partnerPost("/api-profit/statistics/park","{\"trafficId\": 239}");
        partnerPost("/api-post/position/list","{\"trafficId\": 239}");
        partnerPost("/api-post/partner/park/list","{\"trafficId\": 239}");
        partnerPost("/api-post/banner/list","");
        partnerPost("/api-profit/statistics/overview","");
        partnerPost("/api-profit/statistics/park/profit","{\"trafficId\":0,\"parkId\":[]}");
        partnerPost("/api-post/notice/list","");
        partnerPost("/api-post/notice/content","{\"contentId\":\"10\",\"type\":\"2\"}");
        partnerPost("/api-post/partner/park/listDetail","{\"parkingIds\":[],\"trafficId\":0,\"pageNo\":1,\"pageSize\":10}");
        partnerPost("/api-post/adsense/list","{\"trafficId\":239,\"parkingIds\":[\"898\"],\"pageNo\":1,\"pageSize\":10}");
        partnerPost("/api-profit/statistics/park/daily","{\"parkingIds\":[],\"trafficId\":239,\"pageNo\":1,\"pageSize\":10,\"startDay\":\"\",\"endDay\":\"\"}");
        partnerPost("/api-profit/statistics/position/daily","{\"adsensePositionId\":\"\",\"parkingId\":null,\"trafficId\":239,\"pageNo\":1,\"pageSize\":10,\"startDay\":\"\",\"endDay\":\"\",\"parkingIds\":[]}");
        partnerPost("/api-profit/withdraw/list","{\"trafficId\":239,\"pageNo\":1,\"pageSize\":10,\"applyTimeStart\":\"\",\"applyTimeEnd\":\"\"}");
//        partnerPost("/api-profit/withdraw/apply","{\"trafficId\":239}");    //提现一次就没有了
        partnerPost("/api-post/partner/detail","{\"trafficId\":239}");
        partnerPost("/api-profit/statistics/exportParkDailyExcel","{\"parkingIds\":[],\"trafficId\":239,\"pageNo\":1,\"pageSize\":10,\"startDay\":\"\",\"endDay\":\"\"}");
    }


}
