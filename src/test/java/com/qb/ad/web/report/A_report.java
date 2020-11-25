package com.qb.ad.web.report;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//@RunWith(Suite.class)                   //改变JUnit的默认执行类 
@RunWith(Suite.class)
//添加执行的testcase
@Suite.SuiteClasses({
	                //财务管理
		            AdminPositionFlow.class,          //广告计划收益报表
		            AdminPositionProfit.class,        //广告位流量趋势
		            AdminPositionProfitExport.class,  //广告位收益趋势
		            AdminPositionTrend.class,         //获取广告位收益统计导出数据

	                 }) 

public class A_report {

}

