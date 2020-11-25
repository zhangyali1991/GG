package com.qb.ad.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;

public class StrJSONPath {

	/**
	 * json寻址（寻值）方法
	 * @param parameter
	 */
	//返回格式化当前时间
    public static String strJSONPath(String parameter,String key){
		JSONObject jsonObject = JSON.parseObject(parameter);
//		System.out.println("jsonObject:"+jsonObject);
		Object value = JSONPath.eval(jsonObject,key);
//		System.out.println("key:" + value);
		return value.toString();
	}
	
}
