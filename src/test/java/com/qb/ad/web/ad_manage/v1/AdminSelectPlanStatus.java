package com.qb.ad.web.ad_manage.v1;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class AdminSelectPlanStatus {

    @Test
    public void adminSelectPlanStatus() throws IOException {
        String parameter = "";
        String getMethodName = new Throwable().getStackTrace()[0].getMethodName();
        advertisePost(parameter,getMethodName );
    }


}
