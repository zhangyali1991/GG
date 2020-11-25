package com.qb.ad.util;

public class StringFunction {

	/**
	 * 字符串处理方法
	 * @param args
	 */
	public static int count = 1;
	
	public static String title(String URL, String url, int check_count) {


		// 特殊域名修改
		if (!URL.contains("qianbao.com")) {
			switch (url) {
			case "sign":
				url = "pos" + toUpperCaseFirstOne(url);
				break;
			}
		}
		return null;
	}
//	stringArray.Contains("A", StringComparer.OrdinalIgnoreCase);
	
	//首字母转小写
	public static String toLowerCaseFirstOne(String s){
	  if(Character.isLowerCase(s.charAt(0)))
	    return s;
	  else
	    return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
	}
	//首字母转大写
	public static String toUpperCaseFirstOne(String s){
	  if(Character.isUpperCase(s.charAt(0)))
	    return s;
	  else
	    return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
	}
	//字符串其他方法
	public static String strMethod(){
		
		return null;
	}
	
	
}
