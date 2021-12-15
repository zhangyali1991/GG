package com.qb.ad.openApi.zyl.elasitic;

import com.qb.ad.util.ApiUtilsTest;
import com.qb.ad.util.HttpGG;
import org.testng.annotations.Test;

import java.io.IOException;

/*
* 创建曝光日志索引库
* */
public class CreateDataBase_ES {
    @Test
    public void test() throws IOException {
        //   登录后台获取token
        String token = ApiUtilsTest.getToken();
//        创建库
        String result = HttpGG.doPost2("http://api-inner-sit.anbokeji.net:8000/api-profit/openlog/index/createIndex", "",token);
    }

}
