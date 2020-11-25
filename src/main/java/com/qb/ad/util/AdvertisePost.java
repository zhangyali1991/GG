package com.qb.ad.util;

import com.qb.ad.common.AdMapVo;
import com.qb.ad.entity.DataTest;

import static com.qb.ad.util.StrJSONPath.strJSONPath;
import static org.testng.Assert.assertEquals;

public class AdvertisePost {

	/**
	 * 前端请求服务端post接口实现类
	 * @param url,data,token
	 */
	public static int count = 1;

	public static void advertisePost( String data , String interfaceName) {

		System.out.println("——" + count++ + "——" + AdMapVo.INTERFACE_NAME.get(interfaceName) + "：—————" + AdMapVo.URL.get( interfaceName ) + "—————");
//		System.out.println("推送请求url：" +  URL + url);
        try{
            String results = HttpGG.doPost2( AdMapVo.URL.get( interfaceName ) ,data, DataTest.Access_Token );
//            assertTrue(strJSONPath(results,"status").equals( "20000000" ));
            assertEquals(strJSONPath(results,"status"),"20000000"  );
        }catch (Exception e){
            System.out.println( "请求异常：" + e );
        }

	}

}
