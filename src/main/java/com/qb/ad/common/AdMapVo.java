package com.qb.ad.common;

import java.util.HashMap;
import java.util.Map;
import static com.qb.ad.common.AdPostUrlVo.*;
/**
 * Value Object值对象
 * 请求地址、方法说明映射关系
 */
public class AdMapVo {
    public static final Map<String, String> URL = new HashMap<String, String>();
    static{
        //user
        URL.put("login",url_login);
        URL.put("getInfo",url_getInfo);
        URL.put("logout",url_logout);

        //traffic
        URL.put("trafficList",url_trafficList);
        URL.put("trafficDetail",url_trafficDetail);
        URL.put("shareDetail",url_shareDetail);
        URL.put("shareUpdate",url_shareUpdate);
        URL.put("trafficUpdate",url_trafficUpdate);
        URL.put("userUpdate",url_userUpdate);
        URL.put("advertList",url_advertList);
        URL.put("parkList",url_parkList);
        URL.put("parkStatus",url_parkStatus);
        URL.put("adnesStatus",url_adnesStatus);
        URL.put("selectCity",url_selectCity);
        URL.put("getParkType",url_getParkType);
        URL.put("getParkUpdate",url_getParkUpdate);

        //ad_manage
        URL.put("adminPlanExist",url_adminPlanExist);
        URL.put("adminSelectAdType",url_adminSelectAdType);
        URL.put("adminPlanCreate",url_adminPlanCreate);
        URL.put("adminPlanCityAll",url_adminPlanCityAll);
        URL.put("adminInAdvertiserCity",url_adminInAdvertiserCity);
        URL.put("adminInParkCity",url_adminInParkCity);
        URL.put("adminInTrafficCity",url_adminInTrafficCity);
        URL.put("adminSelectPositionAll",url_adminSelectPositionAll);
        URL.put("adminSelectPlanname",url_adminSelectPlanname);
        URL.put("adminPlanCity",url_adminPlanCity);
        URL.put("adminPlanPartner",url_adminPlanPartner);
        URL.put("adminSelectTraffic",url_adminSelectTraffic);
        URL.put("adminSelectPark",url_adminSelectPark);
        URL.put("adminPlanPos",url_adminPlanPos);
        URL.put("adminPlanRresource",url_adminPlanRresource);
        URL.put("adminPlanList",url_adminPlanList);
        URL.put("fileUpload",url_fileUpload);
        URL.put("adminPlanInfo",url_adminPlanInfo);
        URL.put("adminPlanStatus",url_adminPlanStatus);
        URL.put("adminSelectPlanStatus",url_adminSelectPlanStatus);
        URL.put("adminSelectPriceType",url_adminSelectPriceType);
        URL.put("adminPlanUpdate",url_adminPlanUpdate);
        URL.put("adminPositionProfit",url_adminPositionProfit);
        URL.put("adminSeletAdvertiserName",url_adminSeletAdvertiserName);
        URL.put("adminSeletLateAdvertiser",url_adminSeletLateAdvertiser);
        URL.put("adScheduleType",url_adScheduleType);
        URL.put("selectIndustry",url_selectIndustry);
        URL.put("adminPlanName",url_adminPlanName);
        URL.put("adminSelectIndustry",url_adminSelectIndustry);
        URL.put("planSummary",url_planSummary);
        URL.put("adminSelectAdvertiserPriceTemplate",url_adminSelectAdvertiserPriceTemplate);
        URL.put("adminPlanParkType",url_adminPlanParkType);
        URL.put("adminPlanPark",url_adminPlanPark);
        URL.put("detailDateList",url_detailDateList);
        URL.put("adminPlanChart",url_adminPlanChart);
        URL.put("adminPlanResources",url_adminPlanResources);
        URL.put("adminSelectAdvertiser",url_adminSelectAdvertiser);
        URL.put("adminSelectClientType",url_adminSelectClientType);
        URL.put("adminPlanCanApi",url_adminPlanCanApi);

        //advert
        URL.put("advertiserList",url_advertiserList);
        URL.put("getIndustryType",url_getIndustryType);
        URL.put("advertiserInfo",url_advertiserInfo);
        URL.put("templateInfo",url_templateInfo);
        URL.put("templateUpdate",url_templateUpdate);
        URL.put("advertiserCreate",url_advertiserCreate);
        URL.put("advertiserUpdate",url_advertiserUpdate);
        URL.put("selectCity",url_selectCity);
        URL.put("clientType",url_clientType);

        //finance
        URL.put("recordList",url_recordList);
        URL.put("reviewList",url_reviewList);
        URL.put("profitList",url_profitList);
        URL.put("financeStatic",url_financeStatic);
        URL.put("reviewUpdate",url_reviewUpdate);
        URL.put("exportWithdraOrderListAdmin",url_exportWithdraOrderListAdmin);
        URL.put("exportWithdraOrderSumListAdmin",url_exportWithdraOrderSumListAdmin);
        URL.put("exportWithdraOrderSumListDetailAdmin",url_exportWithdraOrderSumListDetailAdmin);
        URL.put("profitExport",url_profitExport);

        //report
        URL.put("adminPositionProfit",url_adminPositionProfit);
        URL.put("adminPositionFlow",url_adminPositionFlow);
        URL.put("adminPositionTrend",url_adminPositionTrend);
        URL.put("adminPositionProfitExport",url_adminPositionProfitExport);

    }

    public static final Map<String, String> INTERFACE_NAME = new HashMap<String, String>();
    static{
        //user
        INTERFACE_NAME.put("login","登录");
        INTERFACE_NAME.put("getInfo","获取信息");
        INTERFACE_NAME.put("logout","登出");

        //traffic
        INTERFACE_NAME.put("trafficList","流量主列表");
        INTERFACE_NAME.put("trafficDetail","查看信息列表");
        INTERFACE_NAME.put("shareDetail","分成信息查看");
        INTERFACE_NAME.put("shareUpdate","分成信息更新");
        INTERFACE_NAME.put("trafficUpdate","基本信息更新");
        INTERFACE_NAME.put("userUpdate","账户状态操作");
        INTERFACE_NAME.put("advertList","广告位列表");
        INTERFACE_NAME.put("parkList","车场列表");
        INTERFACE_NAME.put("parkStatus","车场状态列表");
        INTERFACE_NAME.put("adnesStatus","广告位的启用禁用");
        INTERFACE_NAME.put("selectCity2","查询城市列表单选");
        INTERFACE_NAME.put("getParkType","查询车场状态");
        INTERFACE_NAME.put("getParkUpdate","车场状态更新");

        //ad_manage
        INTERFACE_NAME.put("adminPlanExist","计划是否存在");
        INTERFACE_NAME.put("adminSelectAdType","广告类型");
        INTERFACE_NAME.put("adminPlanCreate","创建计划");
        INTERFACE_NAME.put("adminPlanCityAll","城市列表=检索数据接口");
        INTERFACE_NAME.put("adminInAdvertiserCity","城市列表=广告位收益报表页面的检索数据接口");
        INTERFACE_NAME.put("adminInParkCity","城市列表=车场列表页面的检索数据接口");
        INTERFACE_NAME.put("adminInTrafficCity","城市列表=流量主列表页面的检索数据接口????");
        INTERFACE_NAME.put("adminSelectPositionAll","广告位列表=检索数据接口");
        INTERFACE_NAME.put("adminSelectPlanname","计划名称=检索数据接口");
        INTERFACE_NAME.put("adminPlanCity","城市列表=按需数据接口");
        INTERFACE_NAME.put("adminPlanPartner","流量主列表");
        INTERFACE_NAME.put("adminSelectTraffic","全部流量主列表");
        INTERFACE_NAME.put("adminSelectPark","全部车场列表");
        INTERFACE_NAME.put("adminPlanPos","广告位列表");
        INTERFACE_NAME.put("adminPlanRresource","可投放广告资源");
        INTERFACE_NAME.put("adminPlanList","计划列表");
        INTERFACE_NAME.put("fileUpload","上传图片");
        INTERFACE_NAME.put("adminPlanInfo","计划详情-传id");
        INTERFACE_NAME.put("adminPlanStatus","更改计划状态-传id(暂停、下线、删除等操作)");
        INTERFACE_NAME.put("adminSelectPlanStatus","计划状态检索");
        INTERFACE_NAME.put("adminSelectPriceType","计费模式检索");
        INTERFACE_NAME.put("adminPlanUpdate","编辑广告投放计划");
        INTERFACE_NAME.put("adminPositionProfit","广告收益统计");
        INTERFACE_NAME.put("adminSeletAdvertiserName","获取所有广告主名称");
        INTERFACE_NAME.put("adminSeletLateAdvertiser","获取近7个创建过计划的广告主名称");
        INTERFACE_NAME.put("adScheduleType","获取投放模式");
        INTERFACE_NAME.put("selectIndustry","获取广告内容");
        INTERFACE_NAME.put("adminPlanName","广告计划名称");
        INTERFACE_NAME.put("adminSelectIndustry","广告内容列表");
        INTERFACE_NAME.put("planSummary","查看详情");
        INTERFACE_NAME.put("adminSelectAdvertiserPriceTemplate","广告主出价模板列表");
        INTERFACE_NAME.put("adminPlanParkType","车场类型列表");
        INTERFACE_NAME.put("adminPlanPark","车场名称列表");
        INTERFACE_NAME.put("detailDateList","数据列表");
        INTERFACE_NAME.put("adminPlanChart","广告计划可用资源图表");
        INTERFACE_NAME.put("adminPlanResources","广告资源(可投放、新增、详情)-创建计划");
        INTERFACE_NAME.put("adminSelectAdvertiser","广告位模糊搜索");
        INTERFACE_NAME.put("adminSelectClientType","查询客户类型");
        INTERFACE_NAME.put("adminPlanCanApi","是否api接口投放??");

        //advert
        INTERFACE_NAME.put("advertiserList","广告主列表");
        INTERFACE_NAME.put("getIndustryType","行业类型");
        INTERFACE_NAME.put("advertiserInfo","查看信息列表");
        INTERFACE_NAME.put("templateInfo","出价模板查看");
        INTERFACE_NAME.put("templateUpdate","出价模板编辑");
        INTERFACE_NAME.put("advertiserCreate","新增广告主");
        INTERFACE_NAME.put("advertiserUpdate","编辑广告主操作");
        INTERFACE_NAME.put("selectCity","查询城市列表单选");
        INTERFACE_NAME.put("clientType","查询客户类型");

        //finance
        INTERFACE_NAME.put("recordList","提现记录列表？？");
        INTERFACE_NAME.put("reviewList","提现审核列表");
        INTERFACE_NAME.put("profitList","平台收益列表");
        INTERFACE_NAME.put("financeStatic","提现固定数据");
        INTERFACE_NAME.put("reviewUpdate","提现审核，审核操作");
        INTERFACE_NAME.put("exportWithdraOrderListAdmin","导出提现审核");
        INTERFACE_NAME.put("exportWithdraOrderSumListAdmin","导出提现记录");
        INTERFACE_NAME.put("exportWithdraOrderSumListDetailAdmin","导出查看记录");
        INTERFACE_NAME.put("profitExport","导出平台收益");

        //report
        INTERFACE_NAME.put("adminPositionProfit","广告计划收益报表");
        INTERFACE_NAME.put("adminPositionFlow","广告位流量趋势");
        INTERFACE_NAME.put("adminPositionTrend","广告位收益趋势");
        INTERFACE_NAME.put("adminPositionProfitExport","获取广告位收益统计导出数据");

    }
}
