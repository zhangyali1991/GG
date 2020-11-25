package com.qb.ad.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.qb.ad.util.HttpGG;
import com.qb.ad.entity.DataTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/**
 * 运营后台登录请求方法
 */
public class LoginGetToken {

    //运营后台登录
    public static String loginGetToken(String username, String password) throws IOException {
        Map<String, String> loginMap = new HashMap<>();
        loginMap.put( "username", username );
        loginMap.put( "password", password );
        String response = HttpGG.doPost( DataTest.login_url, JSONObject.toJSONString( loginMap ) );
        System.out.println( "response ： " + response );
        Map<String, Object> resultMap = JSON.parseObject( response, Map.class );

        String result = resultMap.get( "result" ).toString();
        Map<String, String> result_map = JSONObject.parseObject( result, new TypeReference<Map<String, String>>() {
        } );
        String token = result_map.get( "token" );
        System.out.println( "token ： " + token );
        return token;
    }
}
