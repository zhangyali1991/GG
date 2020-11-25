package com.qb.ad.web.advert;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//@RunWith(Suite.class)                   //改变JUnit的默认执行类 
@RunWith(Suite.class)
//添加执行的testcase
@Suite.SuiteClasses({
	                //广告主
		            AdvertiserList.class,   //广告主列表
		            GetIndustryType.class,   //行业类型
		            AdvertiserInfo.class,   //查看信息列表
		            TemplateInfo.class,   //出价模板查看
		            TemplateUpdate.class,   //出价模板编辑
		            AdvertiserCreate.class,   //新增广告主
		            AdvertiserUpdate.class,   //编辑广告主操作
		            SelectCity.class,   //查询城市列表单选
		            ClientType.class,   //查询客户类型
})

public class A_advertiser {

}

