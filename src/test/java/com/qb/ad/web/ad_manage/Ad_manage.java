package com.qb.ad.web.ad_manage;

import com.qb.ad.web.ad_manage.v1.*;
import com.qb.ad.web.ad_manage.v2.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//@RunWith(Suite.class)                   //改变JUnit的默认执行类 
@RunWith(Suite.class)
//添加执行的testcase
@Suite.SuiteClasses({
	                //
		            AdminPlanExist.class,   //计划是否存在
		            AdminSelectAdType.class,   //广告类型
		            AdminPlanCreate.class,   //创建计划
		            AdminPlanCityAll.class,   //城市列表=检索数据接口
		            AdminInAdvertiserCity.class,   //城市列表=广告位收益报表页面的检索数据接口
		            AdminInParkCity.class,   //城市列表=车场列表页面的检索数据接口
		            AdminInTrafficCity.class,   //城市列表=流量主列表页面的检索数据接口????
		            AdminSelectPositionAll.class,   //广告位列表=检索数据接口
		            AdminSelectPlanname.class,   //计划名称=检索数据接口
		            AdminPlanCity.class,   //城市列表=按需数据接口
		            AdminPlanPartner.class,   //流量主列表
		            AdminSelectTraffic.class,   //全部流量主列表
		            AdminSelectPark.class,   //全部车场列表
		            AdminPlanPos.class,   //广告位列表
		            AdminPlanRresource.class,   //可投放广告资源
		            AdminPlanList.class,   //计划列表
		            FileUpload.class,   //上传图片
		            AdminPlanInfo.class,   //计划详情-传id
		            AdminPlanStatus.class,   //更改计划状态-传id(暂停、下线、删除等操作)
		            AdminSelectPlanStatus.class,   //计划状态检索
		            AdminSelectPriceType.class,   //计费模式检索
		            AdminPlanUpdate.class,   //编辑广告投放计划
		            //二期新增
		            AdminPositionProfit.class,   //广告收益统计
		            AdminSeletAdvertiserName.class,   //获取所有广告主名称
		            AdminSeletLateAdvertiser.class,   //获取近7个创建过计划的广告主名称
		            AdScheduleType.class,   //获取投放模式
		            SelectIndustry.class,   //获取广告内容
		            AdminPlanName.class,   //广告计划名称
		            AdminSelectIndustry.class,   //广告内容列表
		            PlanSummary.class,   //查看详情
		            AdminSelectAdvertiserPriceTemplate.class,   //广告主出价模板列表
		            AdminPlanParkType.class,   //车场类型列表
		            AdminPlanPark.class,   //车场名称列表
		            DetailDateList.class,   //数据列表
		            AdminPlanChart.class,   //广告计划可用资源图表
		            AdminPlanResources.class,   //广告资源(可投放、新增、详情)-创建计划
		            AdminSelectAdvertiser.class,   //广告位模糊搜索
		            AdminSelectClientType.class,   //查询客户类型
		            AdminPlanCanApi.class,   //是否api接口投放??

})

public class Ad_manage {

}

