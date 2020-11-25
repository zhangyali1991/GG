package com.qb.ad.web.user;

import com.qb.ad.common.AdPostUrlVo;
import com.qb.ad.entity.DataTest;
import com.qb.ad.util.HttpGG;
import org.junit.Test;

import java.io.IOException;

public class GetInfo {

    @Test
    public void getInfo() throws IOException {
        String parameter = "";
        HttpGG.doPost2( AdPostUrlVo.url_getInfo,parameter, DataTest.Access_Token );
    }
}
