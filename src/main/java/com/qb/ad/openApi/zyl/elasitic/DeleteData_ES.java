package com.qb.ad.openApi.zyl.elasitic;

import com.alibaba.fastjson.JSONObject;
import com.qb.ad.util.ApiUtilsTest;
import com.qb.ad.util.HttpGG;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
* 删除es数据
* */
public class DeleteData_ES {
    @Test
    public void test() throws IOException {
//        登录获取token
        String token = ApiUtilsTest.getToken();
        Map<String,String> map=new HashMap<>();
        map.put("startTime","");
        map.put("endTime","");
       String param= JSONObject.toJSONString(map);
        HttpGG.doPost2("http://api-inner-sit.anbokeji.net:8000/openlog/index/delete/document",param,token);
    }
}
