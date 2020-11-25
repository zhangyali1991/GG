package com.qb.ad.web.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.qb.ad.common.AdPostUrlVo;
import com.qb.ad.util.HttpGG;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.qb.ad.util.AdvertisePost.advertisePost;

public class Login {

    @Test
    public void login() throws IOException {
        String parameter = "{\"username\": \"admin\", \"password\": \"123456\"}";
        String getMethodName = new Throwable().getStackTrace()[0].getMethodName();
        advertisePost(parameter,getMethodName );
    }


    public static String login(String username, String password) throws IOException {
        Map<String, String> loginMap = new HashMap<>();
        loginMap.put( "username", username );
        loginMap.put( "password", password );
        String response = HttpGG.doPost( AdPostUrlVo.url_login, JSONObject.toJSONString( loginMap ) );
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
