package com.qb.ad.common;

import com.qb.ad.entity.AdPlanDataTest;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 请求公共参数Vo
 * @author mayun
 * @version 2020-08-14
 * */
public class AdPlanVo implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 广告位 ID：1-5*/
    private String adsensePositionId = "";
    /** 广告主ID */
    private String[] advertiserId = AdPlanDataTest.advertiserId;
    /** 自动补充车场；1-是；0-否 */
    private String[] autoFill = AdPlanDataTest.autoFill;
    /** 单日曝光上限 */
    private int[] ceilingCntDaily = AdPlanDataTest.ceilingCntDaily;
    /**  */
    private boolean[] checkAllData = AdPlanDataTest.checkAllData;
    /** 城市 id[] */
    private int[] cityIds = AdPlanDataTest.cityIds;
    /** 其他备注 */
    private String[] comment = AdPlanDataTest.comment;
    /** 素材内容 ：文案内容为文字时传 */
    private String[] content = AdPlanDataTest.content;
    /** 投放结束时间 */
    private Long endTime = AdPlanDataTest.endTime;
    /** 素材内容 ：文案内容为上传图片地址 */
    private String[] imageUri = AdPlanDataTest.imageUri;
    /** 广告内容： 1旅游2加油3优惠券4游戏5保险6教育7电商8外卖55其他 */
    private int[] industryId = AdPlanDataTest.industryId;
    /** 是否api接口投放；0-否；1-是 */
    private String[] isApi = AdPlanDataTest.isApi;
    /** 是否跳转: 0不跳转; 1跳转 */
    private int[] isRedirect = AdPlanDataTest.isRedirect;
    /** 空挡补位：0 否; 1 是;（共享下不需要传默认否） */
    private String[] isSubstitution = AdPlanDataTest.isSubstitution;
    /** 自动补充-匹配条件 格式：[0,0,0,0] */
    private int[] matchCondition = AdPlanDataTest.matchCondition;
    /** 表现形式: 0 文字链接; 1 banner; 2 页面直跳; 3 微信小程序 */
    private int[] mediaType = AdPlanDataTest.mediaType;
    /** 计划名称 */
    private String[] name = AdPlanDataTest.createAdvertisePlanName;
    /** 车场名称 id[] */
    private int[] parkIds = AdPlanDataTest.parkIds;
    /** 车场类型 */
    private int[] parkTypeIds = AdPlanDataTest.parkTypeIds;
    /** 出价 */
    private String[] price = AdPlanDataTest.price;
    /** 预算总额 */
    private String[] priceTotal = AdPlanDataTest.priceTotal;
    /** 计费方式 0:千次曝光CPM 1：单次点击CPC */
    private String[] priceType = AdPlanDataTest.priceType;
    /** 投放时段配置（三位数字，第一位0-7代表周日到周六，后两位01-48表示一天每30分钟一个时间段） */
    private int[] publishTimeList = AdPlanDataTest.publishTimeList;
    /** 频次：次数 投放频次限制*/
    private String[] scheduleIntervalCnt = AdPlanDataTest.scheduleIntervalCnt;
    /** 频次：小时 投放频次限制，时间区间以小时计*/
    private String[] scheduleIntervalHours = AdPlanDataTest.scheduleIntervalHours;
    /** 频次间隔类型 0:小时 1:天(自然日) */
    private String[] scheduleIntervalType = AdPlanDataTest.scheduleIntervalType;
    /** 投放模式 0：独占 1：共享 */
    private String scheduleType = AdPlanDataTest.scheduleType;
    /** 投放开始时间 */
    private Long startTime = AdPlanDataTest.startTime;
    /** 售卖量 */
    private String[] target = AdPlanDataTest.target;
    /** 是否限制投放时段 0-不限制；1-限制 */
    private String[] timeLimit = AdPlanDataTest.timeLimit;
    /** 流量主 id[] */
    private int[] trafficIds = AdPlanDataTest.trafficIds;
    /** 地址或参数  跳转链接*/
    private String[] url = AdPlanDataTest.url;
    /** 权重值, 展示顺序：为1最高，99可输入范围最低 ，默认不输入65535最低*/
    private String[] weight = AdPlanDataTest.weight;
    /** 小程序*/
    private String appId = AdPlanDataTest.appId;

    public AdPlanVo(){}

    //独占广告计划
    public Map<String, Object> toMap(int id) {
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("adsensePositionId", id);
        map.put("advertiserId",advertiserId[id-1] );
        map.put("ceilingCntDaily",ceilingCntDaily[id-1] );
        map.put("autoFill",autoFill[id-1] );
        map.put("checkAllData",checkAllData[id-1] );
        map.put("cityIds",cityIds );
        map.put("comment",comment[id-1] );
        map.put("content",content[id-1] );
        map.put("endTime",endTime );
        map.put("imageUri",imageUri[id-1] );
        map.put("industryId",industryId[id-1] );
        map.put("isApi",isApi[id-1] );
        map.put("isRedirect",isRedirect[id-1] );
        map.put("isSubstitution",isSubstitution[id-1] );
        map.put("matchCondition",matchCondition );
        map.put("mediaType",mediaType[id-1] );
        map.put("name",name[id-1] );
        map.put("parkIds",parkIds );
        map.put("parkTypeIds",parkTypeIds );
        map.put("price",price[id-1] );
        map.put("priceTotal",priceTotal[id-1] );
        map.put("priceType",priceType[id-1] );
        map.put("publishTimeList",publishTimeList );
        map.put("scheduleIntervalCnt",scheduleIntervalCnt[id-1] );
        map.put("scheduleIntervalHours",scheduleIntervalHours[id-1] );
        map.put("scheduleIntervalType",scheduleIntervalType[id-1] );
        map.put("scheduleType",scheduleType );
        map.put("startTime",startTime );
        map.put("target",target[id-1] );
        map.put("timeLimit",timeLimit[id-1] );
        map.put("trafficIds",trafficIds );
        map.put("url",url[id-1] );
        map.put("weight",weight[id-1] );
        return map;
    }

    //独占广告计划
    public Map<String, Object> toIndependentMap() {
        AdPlanVo adPlanVo = new AdPlanVo();
        TreeMap<String, Object> treeMap = new TreeMap<String, Object>();
        treeMap.putAll(adPlanVo.toMap(1));
        treeMap.remove( "ceilingCntDaily" );
        treeMap.remove( "scheduleIntervalCnt" );
        treeMap.remove( "scheduleIntervalHours" );
        treeMap.remove( "scheduleIntervalType" );
        treeMap.remove( "weight" );
        return treeMap;
    }

    //共享广告计划
    public Map<String, Object> toShareMap() {
        AdPlanVo adPlanVo = new AdPlanVo();
        TreeMap<String, Object> treeMap = new TreeMap<String, Object>();
        treeMap.putAll(adPlanVo.toMap(1));
        treeMap.remove( "isSubstitution" );
        return treeMap;
    }

    /**
    public String getAdsensePositionId() {
		return adsensePositionId;
	}
    public String getAdvertiserId() { return advertiserId; }
    public String getAutoFill() { return autoFill; }
    public String getCheckAllData() { return checkAllData; }
    public String getCityIds() { return cityIds; }
    public String getComment() { return comment; }
    public String getContent() { return content; }
    public String getEndTime() { return endTime; }
    public String getImageUri() { return imageUri; }
    public String getIndustryId() { return industryId; }
    public String getIsApi() { return isApi; }
    public String getIsRedirect() { return isRedirect; }
    public String getIsSubstitution() { return isSubstitution; }
    public String getMatchCondition() { return matchCondition; }
    public String getMediaType() { return mediaType; }
    public String getName() { return name; }
    public String getParkIds() { return parkIds; }
    public String getParkTypeIds() { return parkTypeIds; }
    public String getPrice() { return price; }
    public String getPriceTotal() { return priceTotal; }
    public String getPriceType() { return priceType; }
    public String getPublishTimeList() { return publishTimeList; }
    public String getScheduleIntervalCnt() { return scheduleIntervalCnt; }
    public String getScheduleIntervalHours() { return scheduleIntervalHours; }
    public String getScheduleIntervalType() { return scheduleIntervalType; }
    public String getScheduleType() { return scheduleType; }
    public String getStartTime() { return startTime; }
    public String getTarget() { return target; }
    public String getTimeLimit() { return timeLimit; }
    public String getTrafficIds() { return trafficIds; }
    public String getUrl() { return url; }
    public String getWeight() { return weight; }

	public void setAdsensePositionId(String adsensePositionId) {
		this.adsensePositionId = adsensePositionId;
	}
    public void setAdvertiserId (String advertiserId) {this.advertiserId = advertiserId; }
    public void setAutoFill (String autoFill) {this.autoFill = autoFill; }
    public void setCheckAllData (String checkAllData) {this.checkAllData = checkAllData; }
    public void setCityIds (String cityIds) {this.cityIds = cityIds; }
    public void setComment (String comment) {this.comment = comment; }
    public void setContent (String content) {this.content = content; }
    public void setEndTime (String endTime) {this.endTime = endTime; }
    public void setImageUri (String imageUri) {this.imageUri = imageUri; }
    public void setIndustryId (String industryId) {this.industryId = industryId; }
    public void setIsApi (String isApi) {this.isApi = isApi; }
    public void setIsRedirect (String isRedirect) {this.isRedirect = isRedirect; }
    public void setIsSubstitution (String isSubstitution) {this.isSubstitution = isSubstitution; }
    public void setMatchCondition (String matchCondition) {this.matchCondition = matchCondition; }
    public void setMediaType (String mediaType) {this.mediaType = mediaType; }
    public void setName (String name) {this.name = name; }
    public void setParkIds (String parkIds) {this.parkIds = parkIds; }
    public void setParkTypeIds (String parkTypeIds) {this.parkTypeIds = parkTypeIds; }
    public void setPrice (String price) {this.price = price; }
    public void setPriceTotal (String priceTotal) {this.priceTotal = priceTotal; }
    public void setPriceType (String priceType) {this.priceType = priceType; }
    public void setPublishTimeList (String publishTimeList) {this.publishTimeList = publishTimeList; }
    public void setScheduleIntervalCnt (String scheduleIntervalCnt) {this.scheduleIntervalCnt = scheduleIntervalCnt; }
    public void setScheduleIntervalHours (String scheduleIntervalHours) {this.scheduleIntervalHours = scheduleIntervalHours; }
    public void setScheduleIntervalType (String scheduleIntervalType) {this.scheduleIntervalType = scheduleIntervalType; }
    public void setScheduleType (String scheduleType) {this.scheduleType = scheduleType; }
    public void setStartTime (String startTime) {this.startTime = startTime; }
    public void setTarget (String target) {this.target = target; }
    public void setTimeLimit (String timeLimit) {this.timeLimit = timeLimit; }
    public void setTrafficIds (String trafficIds) {this.trafficIds = trafficIds; }
    public void setUrl (String url) {this.url = url; }
    public void setWeight (String weight) {this.weight = weight; }
    */
}
