package com.qb.ad.util;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.qb.ad.common.AdPostUrlVo;
import com.qb.ad.entity.DataTest;

import java.util.Map;

import static com.qb.ad.util.ApiUtilsTest.loginGetToken;
import static com.qb.ad.util.StrJSONPath.strJSONPath;
import static org.testng.Assert.assertEquals;

public class PartnerPost {

	/**
	 * 流量主请求方法
	 * @param data
	 */
	public static int count = 1;

	public static void partnerPost( String url ,String data ) {

		System.out.println("——" + count++ + "——" + url + "：——————————");
//		System.out.println("推送请求url：" +  URL + url);
        try{
            String results = HttpGG.doPost2( AdPostUrlVo.url_post + url ,data, DataTest.Access_Token );
//            assertTrue(strJSONPath(results,"status").equals( "20000000" ));
			Map<String, String> result_map = JSONObject.parseObject(results, new TypeReference<Map<String, String>>(){});
			if(result_map.get( "status" ).equals( "99999998" )){
				System.out.println("token失效 ： " + results);
				DataTest.Access_Token = loginGetToken("admin","123456");
				results = HttpGG.doPost2( AdPostUrlVo.url_post + url ,data, DataTest.Access_Token );
				System.out.println("重新登录后请求结果 ： " + results);
			}
            assertEquals(strJSONPath(results,"status"),"20000000"  );
        }catch (Exception e){
            System.out.println( "请求异常：" + e );
        }

	}

}
