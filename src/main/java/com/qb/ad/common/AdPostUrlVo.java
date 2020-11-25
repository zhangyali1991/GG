package com.qb.ad.common;
/**
 * 前端请求服务端post接口
 */
public class AdPostUrlVo {
    public static final String url_post = "http://api-inner-sit.anbokeji.net:8000";
    public static final String url_inner = "http://172.17.15.51:9000";

    //user
    public static final String url_login = url_post + "/api-user/user/login";   //登录
    public static final String url_getInfo = url_post + "/api-user/user/info";   //获取信息
    public static final String url_logout = url_post + "/api-user/user/logout";   //登出

    //traffic
    public static final String url_trafficList = url_post + "/api-post/traffic/list";   //流量主列表
    public static final String url_trafficDetail = url_post + "/api-post/traffic/detail";   //查看信息列表
    public static final String url_shareDetail = url_post + "/api-post/traffic/share/detail";   //分成信息查看
    public static final String url_shareUpdate = url_post + "/api-post/traffic/share/update";   //分成信息更新
    public static final String url_trafficUpdate = url_post + "/api-post/traffic/update";   //基本信息更新
    public static final String url_userUpdate = url_post + "/api-post/user/update";   //账户状态操作
    public static final String url_advertList = url_post + "/api-post/advert/list";   //广告位列表
    public static final String url_parkList = url_post + "/api-post/park/list";   //车场列表
    public static final String url_parkStatus = url_post + "/api-post/park/status";   //车场状态列表
    public static final String url_adnesStatus = url_post + "/api-post/park/adnes/status";   //广告位的启用禁用
    public static final String url_selectCity = url_post + "/api-post/select/province-city";   //查询城市列表单选
    public static final String url_getParkType = url_post + "/api-post/select/park/type";   //查询车场状态
    public static final String url_getParkUpdate = url_post + "/api-post/park/update";   //车场状态更新

    //ad_manage
    public static final String url_adminPlanExist = url_post + "/api-post/plan/exist";   //计划是否存在
    public static final String url_adminSelectAdType = url_post + "/api-post/select/ad-type";   //广告类型
    public static final String url_adminPlanCreate = url_post + "/api-post/plan/create";   //创建计划
    public static final String url_adminPlanCityAll = url_post + "/api-post/select/city";   //城市列表 =检索数据接口
    public static final String url_adminInAdvertiserCity = url_post + "/api-post/select/advertiser/city";   //城市列表=广告位收益报表页面的检索数据接口
    public static final String url_adminInParkCity = url_post + "/api-post/select/park/city";   //城市列表=车场列表页面的检索数据接口
    public static final String url_adminInTrafficCity = url_post + "/api-post/select/traffic/city";   //城市列表=流量主列表页面的检索数据接口????
    public static final String url_adminSelectPositionAll = url_post + "/api-post/select/position";   //广告位列表=检索数据接口
    public static final String url_adminSelectPlanname = url_post + "/api-post/select/plan-name";   //计划名称=检索数据接口
    public static final String url_adminPlanCity = url_post + "/api-post/plan/city";   //城市列表 =按需数据接口
    public static final String url_adminPlanPartner = url_post + "/api-post/plan/partner";   //流量主列表
    public static final String url_adminSelectTraffic = url_post + "/api-post/select/traffic";   //全部流量主列表
    public static final String url_adminSelectPark = url_post + "/api-post/select/park";   //全部车场列表
    public static final String url_adminPlanPos = url_post + "/api-post/plan/pos";   //广告位列表
    public static final String url_adminPlanRresource = url_post + "/api-post/plan/resource";   //可投放广告资源
    public static final String url_adminPlanList = url_post + "/api-post/plan/list";   //计划列表
    public static final String url_fileUpload = url_post + "/api-base/file/upload";   //上传图片
    public static final String url_adminPlanInfo = url_post + "/api-post/plan/info";   //计划详情-传id
    public static final String url_adminPlanStatus = url_post + "/api-post/plan/status";   //更改计划状态-传id(暂停、下线、删除等操作)
    public static final String url_adminSelectPlanStatus = url_post + "/api-post/select/plan-status";   //计划状态检索
    public static final String url_adminSelectPriceType = url_post + "/api-post/select/price-type";   //计费模式检索
    public static final String url_adminPlanUpdate = url_post + "/api-post/plan/update";   //编辑广告投放计划
    public static final String url_adminPositionProfit = url_post + "/api-profit/position/profit";   //广告收益统计
    public static final String url_adminSeletAdvertiserName = url_post + "/api-post/select/advertiser-name";   //获取所有广告主名称
    public static final String url_adminSeletLateAdvertiser = url_post + "/api-post/select/late-advertiser";   //获取近7个创建过计划的广告主名称
    public static final String url_adScheduleType = url_post + "/api-post/select/ad-schedule-type";   //获取投放模式
    public static final String url_selectIndustry = url_post + "/api-post/select/industry";   //获取广告内容
    public static final String url_adminPlanName = url_post + "/api-post/plan/name";   //广告计划名称
    public static final String url_adminSelectIndustry = url_post + "/api-post/select/industry";   //广告内容列表
    public static final String url_planSummary = url_post + "/api-post/plan/summary";   //查看详情
    public static final String url_adminSelectAdvertiserPriceTemplate = url_post + "/api-post/select/advertiser-price-template";   //广告主出价模板列表
    public static final String url_adminPlanParkType = url_post + "/api-post/plan/park-type";   //车场类型列表
    public static final String url_adminPlanPark = url_post + "/api-post/plan/park";   //车场名称列表
    public static final String url_detailDateList = url_post + "/api-post/plan/data";   //数据列表
    public static final String url_adminPlanChart = url_post + "/api-post/plan/chart";   //广告计划可用资源图表
    public static final String url_adminPlanResources = url_post + "/api-post/plan/resources";   //广告资源(可投放、新增、详情)-创建计划
    public static final String url_adminSelectAdvertiser = url_post + "/api-post/select/advertiser";   //广告位模糊搜索
    public static final String url_adminSelectClientType = url_post + "/api-post/select/advertiser/client-type";   //查询客户类型
    public static final String url_adminPlanCanApi = url_post + "/api-post/plan/can-api";   //是否api接口投放??

    //advert
    public static final String url_advertiserList = url_post + "/api-post/advertiser/list";   //广告主列表
    public static final String url_getIndustryType = url_post + "/api-post/select/park/type";   //行业类型
    public static final String url_advertiserInfo = url_post + "/api-post/advertiser/info";   //查看信息列表
    public static final String url_templateInfo = url_post + "/api-post/advertiser/template/info";   //出价模板查看
    public static final String url_templateUpdate = url_post + "/api-post/advertiser/template/update";   //出价模板编辑
    public static final String url_advertiserCreate = url_post + "/api-post/advertiser/create";   //新增广告主
    public static final String url_advertiserUpdate = url_post + "/api-post/advertiser/update";   //编辑广告主操作
//    public static final String url_selectCity2 = url_post + "/api-post/select/province-city";   //查询城市列表单选
    public static final String url_clientType = url_post + "/api-post/select/advertiser/client-type";   //查询客户类型

    //finance
    public static final String url_recordList = url_post + "/api-profit/finance/record/list";   //提现记录列表？？
    public static final String url_reviewList = url_post + "/api-profit/finance/review/list";   //提现审核列表
    public static final String url_profitList = url_post + "/api-profit/platform/profit";   //平台收益列表
    public static final String url_financeStatic = url_post + "/api-profit/finance/static";   //提现固定数据
    public static final String url_reviewUpdate = url_post + "/api-profit/finance/review/update";   //提现审核，审核操作
//    public static final String url_exportWithdraOrderListAdmin = url_post + "/api-profit/finance/exportWithdrawOrderListAdmin";   //导出提现审核
    public static final String url_exportWithdraOrderListAdmin = url_post + "/api-profit/finance/review/list/export";   //导出提现审核
//    public static final String url_exportWithdraOrderSumListAdmin = url_post + "/api-profit/finance/exportWithdrawOrderSumListAdmin";   //导出提现记录
    public static final String url_exportWithdraOrderSumListAdmin = url_post + "/api-profit/finance/record/list/export";   //导出提现记录
    public static final String url_exportWithdraOrderSumListDetailAdmin = url_post + "/api-profit/finance/exportWithdrawOrderSumListDetailAdmin";   //导出查看记录
    public static final String url_profitExport = url_post + "/api-profit/platform/profit/export";   //导出平台收益

    //report
//    public static final String url_adminPositionProfit = url_post + "/api-profit/position/profit";   //广告计划收益报表
    public static final String url_adminPositionFlow = url_post + "/api-profit/position/flow";   //广告位流量趋势
    public static final String url_adminPositionTrend = url_post + "/api-profit/position/trend";   //广告位收益趋势
    public static final String url_adminPositionProfitExport = url_post + "/api-profit/position/profit/export";   //获取广告位收益统计导出数据
}
