package com.qb.ad.util;

import static com.qb.ad.util.StringFunction.toUpperCaseFirstOne;

public class OutputTitle {

	/**
	 * 标题打印方法
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
			;
		}
		return null;
	}
	
	
}
