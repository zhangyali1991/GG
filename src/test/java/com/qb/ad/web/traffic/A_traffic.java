package com.qb.ad.web.traffic;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//@RunWith(Suite.class)                   //改变JUnit的默认执行类 
@RunWith(Suite.class)
//添加执行的testcase
@Suite.SuiteClasses({
	                //流量主
		            TrafficList.class,   //流量主列表
		            TrafficDetail.class,   //查看信息列表
		            ShareDetail.class,   //分成信息查看
		            ShareUpdate.class,   //分成信息更新
		            TrafficUpdate.class,   //基本信息更新
		            UserUpdate.class,   //账户状态操作
		            AdvertList.class,   //广告位列表
		            ParkList.class,   //车场列表
		            ParkStatus.class,   //车场状态列表
		            AdnesStatus.class,   //广告位的启用禁用
		            SelectCity.class,   //查询城市列表单选
		            GetParkType.class,   //查询车场状态
		            GetParkUpdate.class,   //车场状态更新
})

public class A_traffic {

}

