package com.qb.ad.web.traffic;

import org.junit.Test;

import java.io.IOException;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class UserUpdate {

    @Test
    public void userUpdate() throws IOException {
        String parameter = "{\"id\":312,\"operatorId\":1,\"userStatus\":1}";
        String getMethodName = new Throwable().getStackTrace()[0].getMethodName();
        advertisePost(parameter,getMethodName );
    }


}
