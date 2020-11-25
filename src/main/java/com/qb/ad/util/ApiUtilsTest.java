package com.qb.ad.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.TypeReference;
import com.qb.ad.entity.DataTest;
import com.zzrb.util.ECCCryptUtil;
import com.zzrb.util.ECCSignUtil;
import org.assertj.core.api.Assertions;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import static com.qb.ad.entity.BaseData.encrypt;
import static com.qb.ad.util.HttpGG.*;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
import static org.assertj.core.api.Assertions.*;

/**
 * *************************测试环境*************************
 * 创建流量主、更新流量主
 * 创建车场、更新车场、获取车场
 * 新增广告位、更新广告位、获取广告位
 * 曝光、点击、曝光且点击
 * 后台登录
 */
public class ApiUtilsTest {
//   public static String userLicense = "京A" + randomNumeric(5);
//    public static  String openId = randomNumeric(8);
//    public static   String userIp = randomNumeric(2) + ".1.1." + randomNumeric(2);

    //生成流量主账户
    public static String createAccount(String public_key, String private_key) throws Exception {
        try {
            Map<String, String> createAccountMap = new HashMap<String, String>();
            createAccountMap.put("name", DataTest.name);//用户名称
            createAccountMap.put("regType", DataTest.regType);//注册类型
            createAccountMap.put("cityId", DataTest.cityId);//所在城市
            createAccountMap.put("accountType", DataTest.accountType);//客户类型? 0:车场; 1:媒介; 3:代理商
            createAccountMap.put("contactName", DataTest.contactName);//联系人
            createAccountMap.put("contactMobile", DataTest.contactMobile);//联系电话
            createAccountMap.put("source", DataTest.source);//客户来源
            createAccountMap.put("manager", DataTest.manager);//客户经理
            createAccountMap.put("accountName", DataTest.accountName);//开户人名称
            createAccountMap.put("bankName", DataTest.bankName);//银行名称
            createAccountMap.put("accountNo", DataTest.accountNo);//银行名称
            createAccountMap.put("password", ECCCryptUtil.encrypt(DataTest.password, encrypt));//登录密码
            createAccountMap.put("publicKey", public_key);//公钥
            String createAccountSign = ECCSignUtil.sign(private_key, createAccountMap);
            System.out.println("创建流量主sign ： " + createAccountSign);
            createAccountMap.put("sign", createAccountSign);
            String json = JSONObject.toJSONString(createAccountMap);
//        System.out.println("json： " + json);
            String responseData = HttpGG.doPost(DataTest.create_account_url, json);
            System.out.println("创建流量主名称name ： " + DataTest.name);
//        System.out.println("创建流量主resultresult ： " + result);

            Map<String, Object> resultMap = JSON.parseObject(responseData, Map.class);
            String result = resultMap.get("result").toString();
            Map<String, String> result_map = JSONObject.parseObject(result, new TypeReference<Map<String, String>>() {
            });
            String partnerId = result_map.get("partnerId");
            System.out.println("创建流量主-partnerId ： " + partnerId);
            return partnerId;
        } catch (Exception e) {
            System.out.println("创建流量主失败：" + e);
        }
        return null;
    }

    //更新流量主账户
    public static void updateAccount(String contactMobile, String partnerId, String private_key) throws Exception {
        try {
            Map<String, String> updateAccountMap = new HashMap<String, String>();
//            updateAccountMap.put("name", DataTest.name);//用户名称
//            updateAccountMap.put("regType", DataTest.regType);//注册类型
//            updateAccountMap.put("cityId", DataTest.cityId);//所在城市
//            updateAccountMap.put("accountType", DataTest.accountType);//客户类型? 0:车场; 1:媒介; 3:代理商
//            updateAccountMap.put("contactName", DataTest.contactName);//联系人
            updateAccountMap.put("contactMobile", contactMobile);//联系电话
//            updateAccountMap.put("source", DataTest.source);//客户来源
//            updateAccountMap.put("manager", DataTest.manager);//客户经理
//            updateAccountMap.put("accountName", DataTest.accountName);//开户人名称
//            updateAccountMap.put("bankName", DataTest.bankName);//银行名称
//            updateAccountMap.put("accountNo", DataTest.accountNo);//银行名称
            updateAccountMap.put("password", ECCCryptUtil.encrypt(DataTest.password, encrypt));//登录密码
            updateAccountMap.put("partnerId", partnerId);           //流量主业务id
            String updateAccountSign = ECCSignUtil.sign(private_key, updateAccountMap);
            System.out.println("更新流量主sign ： " + updateAccountSign);
            updateAccountMap.put("sign", updateAccountSign);
            String json = JSONObject.toJSONString(updateAccountMap);
            HttpGG.doPut(DataTest.create_account_url, json);

        } catch (Exception e) {
            System.out.println("更新流量主失败:" + e);
        }
    }

    //创建车场
    public static String createPark(String partnerId, String private_key) throws Exception {
        try {
            Map<String, String> parkMap = new HashMap<>();
//        map.put("parkId", parkId);
            parkMap.put("parkName", DataTest.parkName);
            parkMap.put("cityId", DataTest.cityId);
            parkMap.put("partnerId", partnerId);
            String parkSign = ECCSignUtil.sign(private_key, parkMap);
            parkMap.put("sign", parkSign);
            String park_json = JSONObject.toJSONString(parkMap);
            String requestData = doPost(DataTest.park_url, park_json);
            Map<String, Object> resultMap = JSON.parseObject(requestData, Map.class);
            String result = resultMap.get("result").toString();
            Map<String, String> result_map = JSONObject.parseObject(result, new TypeReference<Map<String, String>>() {
            });
            String parkId = result_map.get("parkId").toString();
            System.out.println("车场ID parkId: " + parkId);
            return parkId;
        } catch (Exception e) {
            System.out.println("新增车场失败：" + e);
        }
        return null;
    }

    //更新车场
    public static void updatePark(String parkId, String partnerId, String private_key) throws Exception {
        try {
            Map<String, String> parkMap = new HashMap<>();
            parkMap.put("parkName", DataTest.updateparkName);
            parkMap.put("cityId", DataTest.parkCityId);
//            parkMap.put( "status", "1" );    //v2需要注释
            parkMap.put("partnerId", partnerId);
            parkMap.put("parkId", parkId);
            String parkSign = ECCSignUtil.sign(private_key, parkMap);
            parkMap.put("sign", parkSign);
            String park_json = JSONObject.toJSONString(parkMap);
            HttpGG.doPut(DataTest.park_url, park_json);

        } catch (Exception e) {
            System.out.println("更新车场失败：" + e);
        }
    }

    //获取车场
    public static void getPark(String parkId, String partnerId) {
        try {
            Map<String, String> map = new HashMap<>();
            map.put("parkId", parkId);
            map.put("partnerId", partnerId);
            String json = JSONObject.toJSONString(map);
            System.out.println(json);
            String params = "?" + "parkId=" + parkId + "&" + "partnerId=" + partnerId;
            doGet02(DataTest.park_url_1 + params, json);  //只支持v1版本
        } catch (Exception e) {

        }
    }
    //新增广告位v1
    public static void createAdvertisePosition_v1(String adPosIds, String parkId, String partnerId, String private_key) {
        try {
            Map<String, String> adPosMap = new HashMap<>();
            adPosMap.put("adPosIds", adPosIds);
            adPosMap.put("parkId", parkId);
            adPosMap.put("partnerId", partnerId);
            adPosMap.put( "status", "1" );  //v2版本需要注释
            String adPosSign = ECCSignUtil.sign(private_key, adPosMap);
            adPosMap.put("sign", adPosSign);
            String adPos_json = JSONObject.toJSONString(adPosMap);
            doPut(DataTest.adPos_url_v1, adPos_json);
        } catch (Exception e) {
            System.out.println("新增广告位失败！");
        }
    }

    //新增广告位v2
    public static void createAdvertisePosition_v2(String adPosIds, String parkId, String partnerId, String private_key) {
        try {
            Map<String, String> adPosMap = new HashMap<>();
            adPosMap.put("adPosIds", adPosIds);
            adPosMap.put("parkId", parkId);
            adPosMap.put("partnerId", partnerId);
            String adPosSign = ECCSignUtil.sign(private_key, adPosMap);
            adPosMap.put("sign", adPosSign);
            String adPos_json = JSONObject.toJSONString(adPosMap);
            doPut(DataTest.adPos_url_v2, adPos_json);
        } catch (Exception e) {
            System.out.println("新增广告位失败！");
        }
    }

    public static void createAdvertisePosition_v3(String adPosIds, String parkId, String partnerId, String private_key, String medium) {
        try {
            Map<String, String> adPosMap = new HashMap<>();
            adPosMap.put("adPosIds", adPosIds);
            adPosMap.put("parkId", parkId);
            adPosMap.put("partnerId", partnerId);
            adPosMap.put("medium", medium);
            String adPosSign = ECCSignUtil.sign(private_key, adPosMap);
            adPosMap.put("sign", adPosSign);
            String adPos_json = JSONObject.toJSONString(adPosMap);
            doPut(DataTest.adPos_url_v3, adPos_json);
        } catch (Exception e) {
            System.out.println("新增广告位失败！");
        }
    }

    //获取广告位
    public static void getAdvertisePosition(String parkId, String partnerId, String private_key) {
        try {
            Map<String, String> adPosMap = new HashMap<>();
            adPosMap.put("parkId", parkId);
            adPosMap.put("partnerId", partnerId);
            String json = JSONObject.toJSONString(adPosMap);
            System.out.println(json);
            String params = "?" + "parkId=" + parkId + "&" + "partnerId=" + partnerId;
            doGet02(DataTest.adPos_url_1 + params, json);  //只支持v1版本
        } catch (Exception e) {
            System.out.println("新增广告位失败！");
        }
    }

    //创建计划
//    public static String createAdPlan(String parkids_id, String traffic_id, String scheduleType, String cityIds) throws Exception {
//
//        switch (scheduleType) {
//            case "0": //独占
////                String cityIds ="3";
//                String AdPlanIndependent1 = "{\"adsensePositionId\":1,\"advertiserId\":" + DataTest.advertiserId + ",\"checkAllData\":false,\"cityIds\":[" + cityIds + "],\"comment\":\"创建独占广告计划入场推送备注1\",\"content\":\"文案：独占-1入场\",\"endTime\":" + DataTest.endTime + ",\"imageUri\":\"\",\"industryId\":7,\"isRedirect\":0,\"isSubstitution\":0,\"mediaType\":1,\"name\":\"" + DataTest.createAdvertiseName + "_1" + "\",\"parkIds\":[2147483647," + parkids_id + "],\"parkTypeIds\":[2147483647,0],\"price\":" + DataTest.Indep_price[0] + ",\"priceTotal\":" + DataTest.Indep_priceTotal[0] + ",\"priceType\":" + DataTest.Indep_priceType[0] + ",\"scheduleIntervalType\":0,\"scheduleType\":0,\"startTime\":" + DataTest.startTime + ",\"target\":" + DataTest.Indep_target[0] + ",\"trafficIds\":[" + traffic_id + "],\"url\":\"" + DataTest.url[0] + "\"}";
//                String AdPlanIndependent2 = "{\"adsensePositionId\":2,\"advertiserId\":" + DataTest.advertiserId + ",\"checkAllData\":false,\"cityIds\":[" + cityIds + "],\"comment\":\"创建独占广告计划出场推送备注2\",\"content\":\"文案：独占-2出场\",\"endTime\":" + DataTest.endTime + ",\"imageUri\":\"\",\"industryId\":1,\"isRedirect\":0,\"isSubstitution\":1,\"mediaType\":0,\"name\":\"" + DataTest.createAdvertiseName + "_2" + "\",\"parkIds\":[2147483647," + parkids_id + "],\"parkTypeIds\":[2147483647,0],\"price\":" + DataTest.Indep_price[1] + ",\"priceTotal\":" + DataTest.Indep_priceTotal[1] + ",\"priceType\":" + DataTest.Indep_priceType[1] + ",\"scheduleIntervalType\":0,\"scheduleType\":0,\"startTime\":" + DataTest.startTime + ",\"target\":" + DataTest.Indep_target[1] + ",\"trafficIds\":[" + traffic_id + "],\"url\":\"" + DataTest.url[1] + "\"}";
//                String AdPlanIndependent3 = "{\"adsensePositionId\":3,\"advertiserId\":" + DataTest.advertiserId + ",\"checkAllData\":false,\"cityIds\":[" + cityIds + "],\"comment\":\"创建独占广告计划输入车牌备注3\",\"content\":\"\",\"endTime\":" + DataTest.endTime + ",\"imageUri\":\"https://anbokeji.oss-cn-hangzhou.aliyuncs.com/images/20200610/127144414.jpg\",\"industryId\":2,\"isRedirect\":0,\"isSubstitution\":0,\"mediaType\":1,\"name\":\"" + DataTest.createAdvertiseName + "_3" + "\",\"parkIds\":[2147483647," + parkids_id + "],\"parkTypeIds\":[2147483647,0],\"price\":" + DataTest.Indep_price[2] + ",\"priceTotal\":" + DataTest.Indep_priceTotal[2] + ",\"priceType\":" + DataTest.Indep_priceType[2] + ",\"scheduleIntervalType\":0,\"scheduleType\":0,\"startTime\":" + DataTest.startTime + ",\"target\":" + DataTest.Indep_target[2] + ",\"trafficIds\":[" + traffic_id + "],\"url\":\"" + DataTest.url[2] + "\"}";
//                String AdPlanIndependent4 = "{\"adsensePositionId\":4,\"advertiserId\":" + DataTest.advertiserId + ",\"checkAllData\":false,\"cityIds\":[" + cityIds + "],\"comment\":\"创建独占广告计划支付页面备注4\",\"content\":\"\",\"endTime\":" + DataTest.endTime + ",\"imageUri\":\"https://anbokeji.oss-cn-hangzhou.aliyuncs.com/images/20200610/233150047.jpg\",\"industryId\":3,\"isRedirect\":0,\"isSubstitution\":1,\"mediaType\":3,\"appId\":\"wxc3b7d3c12886ade8\",\"name\":\"" + DataTest.createAdvertiseName + "_4" + "\",\"parkIds\":[2147483647," + parkids_id + "],\"parkTypeIds\":[2147483647,0],\"price\":" + DataTest.Indep_price[3] + ",\"priceTotal\":" + DataTest.Indep_priceTotal[3] + ",\"priceType\":" + DataTest.Indep_priceType[3] + ",\"scheduleIntervalType\":0,\"scheduleType\":0,\"startTime\":" + DataTest.startTime + ",\"target\":" + DataTest.Indep_target[3] + ",\"trafficIds\":[" + traffic_id + "],\"url\":\"" + DataTest.url[3] + "\"}";
//                String AdPlanIndependent5 = "{\"adsensePositionId\":5,\"advertiserId\":" + DataTest.advertiserId + ",\"checkAllData\":false,\"cityIds\":[" + cityIds + "],\"comment\":\"创建独占广告计划付款成功备注5\",\"content\":\"\",\"endTime\":" + DataTest.endTime + ",\"imageUri\":\"https://anbokeji.oss-cn-hangzhou.aliyuncs.com/images/20200610/351145032.jpg\",\"industryId\":4,\"isRedirect\":0,\"isSubstitution\":0,\"mediaType\":2,\"name\":\"" + DataTest.createAdvertiseName + "_5" + "\",\"parkIds\":[2147483647," + parkids_id + "],\"parkTypeIds\":[2147483647,0],\"price\":" + DataTest.Indep_price[4] + ",\"priceTotal\":" + DataTest.Indep_priceTotal[4] + ",\"priceType\":" + DataTest.Indep_priceType[4] + ",\"scheduleIntervalType\":0,\"scheduleType\":0,\"startTime\":" + DataTest.startTime + ",\"target\":" + DataTest.Indep_target[4] + ",\"trafficIds\":[" + traffic_id + "],\"url\":\"" + DataTest.url[4] + "\"}";
//                HttpGG.doPost2( DataTest.plan_create_url, AdPlanIndependent1, DataTest.Access_Token );
//                HttpGG.doPost2( DataTest.plan_create_url, AdPlanIndependent2, DataTest.Access_Token );
//                HttpGG.doPost2( DataTest.plan_create_url, AdPlanIndependent3, DataTest.Access_Token );
//                HttpGG.doPost2( DataTest.plan_create_url, AdPlanIndependent4, DataTest.Access_Token );
//                HttpGG.doPost2( DataTest.plan_create_url, AdPlanIndependent5, DataTest.Access_Token );
//                break;
//            case "1": //共享
//                String AdPlanShare1 = "{\"adsensePositionId\":1,\"advertiserId\":" + DataTest.advertiserId + ",\"ceilingCntDaily\":" + DataTest.ceilingCntDaily[0] + ",\"checkAllData\":false,\"cityIds\":[" + cityIds + "],\"comment\":\"" + "创建共享广告计划入场推送备注1" + "\",\"content\":\"" + DataTest.createAdvertiseName + "测试进场\",\"endTime\":" + DataTest.endTime + ",\"imageUri\":\"\",\"industryId\":3,\"isRedirect\":0,\"mediaType\":0,\"name\":\"" + DataTest.createAdvertiseName + "_1" + "\",\"parkIds\":[2147483647," + parkids_id + "],\"parkTypeIds\":[2147483647,0],\"price\":" + DataTest.Share_price[0] + ",\"priceTotal\":28,\"priceType\":" + DataTest.Share_priceType[0] + ",\"scheduleIntervalCnt\":" + DataTest.Share_scheduleIntervalCnt[0] + ",\"scheduleIntervalHours\":" + DataTest.Share_scheduleIntervalHours[0] + ",\"scheduleIntervalType\":" + DataTest.Share_scheduleIntervalType[0] + ",\"scheduleType\":1,\"startTime\":" + DataTest.startTime + ",\"target\":" + DataTest.Share_target[0] + ",\"trafficIds\":[" + traffic_id + "],\"url\":\"" + DataTest.url[0] + "\",\"weight\":1}";
//                String AdPlanShare2 = "{\"adsensePositionId\":2,\"advertiserId\":" + DataTest.advertiserId + ",\"ceilingCntDaily\":" + DataTest.ceilingCntDaily[1] + ",\"checkAllData\":false,\"cityIds\":[" + cityIds + "],\"comment\":\"" + "创建共享广告计划出场推送备注2" + "\",\"content\":\"" + DataTest.createAdvertiseName + "测试出场\",\"endTime\":" + DataTest.endTime + ",\"imageUri\":\"\",\"industryId\":6,\"isRedirect\":0,\"mediaType\":1,\"name\":\"" + DataTest.createAdvertiseName + "_2" + "\",\"parkIds\":[2147483647," + parkids_id + "],\"parkTypeIds\":[2147483647,0],\"price\":" + DataTest.Share_price[1] + ",\"priceTotal\":40,\"priceType\":" + DataTest.Share_priceType[1] + ",\"scheduleIntervalCnt\":" + DataTest.Share_scheduleIntervalCnt[1] + ",\"scheduleIntervalHours\":" + DataTest.Share_scheduleIntervalHours[1] + ",\"scheduleIntervalType\":" + DataTest.Share_scheduleIntervalType[1] + ",\"scheduleType\":1,\"startTime\":" + DataTest.startTime + ",\"target\":" + DataTest.Share_target[1] + ",\"trafficIds\":[" + traffic_id + "],\"url\":\"" + DataTest.url[1] + "\",\"weight\":2}";
//                String AdPlanShare3 = "{\"adsensePositionId\":3,\"advertiserId\":" + DataTest.advertiserId + ",\"ceilingCntDaily\":" + DataTest.ceilingCntDaily[2] + ",\"checkAllData\":false,\"cityIds\":[" + cityIds + "],\"comment\":\"" + "创建共享广告计划输入车牌备注3" + "\",\"content\":\"\",\"endTime\":" + DataTest.endTime + ",\"imageUri\":\"" + DataTest.imageUri_3 + "\",\"industryId\":6,\"isRedirect\":0,\"mediaType\":1,\"name\":\"" + DataTest.createAdvertiseName + "_3" + "\",\"parkIds\":[2147483647," + parkids_id + "],\"parkTypeIds\":[2147483647,0],\"price\":" + DataTest.Share_price[2] + ",\"priceTotal\":30000,\"priceType\":" + DataTest.Share_priceType[2] + ",\"scheduleIntervalCnt\":" + DataTest.Share_scheduleIntervalCnt[2] + ",\"scheduleIntervalHours\":" + DataTest.Share_scheduleIntervalHours[2] + ",\"scheduleIntervalType\":" + DataTest.Share_scheduleIntervalType[2] + ",\"scheduleType\":1,\"startTime\":" + DataTest.startTime + ",\"target\":" + DataTest.Share_target[2] + ",\"trafficIds\":[" + traffic_id + "],\"url\":\"" + DataTest.url[2] + "\",\"weight\":2}";
//                String AdPlanShare4 = "{\"adsensePositionId\":4,\"advertiserId\":" + DataTest.advertiserId + ",\"ceilingCntDaily\":" + DataTest.ceilingCntDaily[3] + ",\"checkAllData\":false,\"cityIds\":[" + cityIds + "],\"comment\":\"" + "创建共享广告计划支付页面备注4" + "\",\"content\":\"\",\"endTime\":" + DataTest.endTime + ",\"imageUri\":\"" + DataTest.imageUri_4 + "\",\"industryId\":55,\"industryName\":\"测试广告内容-其他\",\"isRedirect\":0,\"mediaType\":3,\"appId\":\"wxc3b7d3c12886ade8\",\"name\":\"" + DataTest.createAdvertiseName + "_4" + "\",\"parkIds\":[2147483647," + parkids_id + "],\"parkTypeIds\":[2147483647,0],\"price\":" + DataTest.Share_priceType[3] + ",\"priceTotal\":120,\"priceType\":" + DataTest.Share_priceType[3] + ",\"scheduleIntervalCnt\":" + DataTest.Share_scheduleIntervalCnt[3] + ",\"scheduleIntervalHours\":" + DataTest.Share_scheduleIntervalHours[3] + ",\"scheduleIntervalType\":" + DataTest.Share_scheduleIntervalType[3] + ",\"scheduleType\":1,\"startTime\":" + DataTest.startTime + ",\"target\":" + DataTest.Share_target[3] + ",\"trafficIds\":[" + traffic_id + "],\"url\":\"" + DataTest.url[3] + "\",\"weight\":4}";
//                String AdPlanShare5 = "{\"adsensePositionId\":5,\"advertiserId\":" + DataTest.advertiserId + ",\"ceilingCntDaily\":" + DataTest.ceilingCntDaily[4] + ",\"checkAllData\":false,\"cityIds\":[" + cityIds + "],\"comment\":\"" + "创建共享广告计划付款成功备注5" + "\",\"content\":\"\",\"endTime\":" + DataTest.endTime + ",\"imageUri\":\"" + DataTest.imageUri_5 + "\",\"industryId\":7,\"isRedirect\":0,\"mediaType\":2,\"name\":\"" + DataTest.createAdvertiseName + "_5" + "\",\"parkIds\":[" + parkids_id + "],\"parkTypeIds\":[2147483647,0],\"price\":" + DataTest.Share_price[4] + ",\"priceTotal\":64130,\"priceType\":" + DataTest.Share_priceType[4] + ",\"scheduleIntervalCnt\":" + DataTest.Share_scheduleIntervalCnt[4] + ",\"scheduleIntervalHours\":" + DataTest.Share_scheduleIntervalHours[4] + ",\"scheduleIntervalType\":" + DataTest.Share_scheduleIntervalType[4] + ",\"scheduleType\":1,\"startTime\":" + DataTest.startTime + ",\"target\":" + DataTest.Share_target[3] + ",\"trafficIds\":[" + traffic_id + "],\"url\":\"" + DataTest.url[4] + "\",\"weight\":5}";
//                HttpGG.doPost2( DataTest.plan_create_url, AdPlanShare1, DataTest.Access_Token );
//                HttpGG.doPost2( DataTest.plan_create_url, AdPlanShare2, DataTest.Access_Token );
//                HttpGG.doPost2( DataTest.plan_create_url, AdPlanShare3, DataTest.Access_Token );
//                HttpGG.doPost2( DataTest.plan_create_url, AdPlanShare4, DataTest.Access_Token );
//                HttpGG.doPost2( DataTest.plan_create_url, AdPlanShare5, DataTest.Access_Token );
//                break;
//            case "2":
//                String AdPlanMixture1_1 = "{\"adsensePositionId\":1,\"advertiserId\":" + DataTest.advertiserId + ",\"ceilingCntDaily\":100,\"checkAllData\":false,\"cityIds\":[" + cityIds + "],\"comment\":\"" + "创建共享广告计划入场推送备注1" + "\",\"content\":\"" + DataTest.createAdvertiseName + "测试进场\",\"endTime\":" + DataTest.endTime + ",\"imageUri\":\"\",\"industryId\":3,\"isRedirect\":0,\"mediaType\":0,\"name\":\"" + DataTest.createAdvertiseName + "_1" + "\",\"parkIds\":[2147483647," + parkids_id + "],\"parkTypeIds\":[2147483647,0],\"price\":" + DataTest.Share_price[0] + ",\"priceTotal\":28,\"priceType\":" + DataTest.Share_priceType[0] + ",\"scheduleIntervalCnt\":" + DataTest.Share_scheduleIntervalCnt[0] + ",\"scheduleIntervalHours\":" + DataTest.Share_scheduleIntervalHours[0] + ",\"scheduleIntervalType\":" + DataTest.Share_scheduleIntervalType[0] + ",\"scheduleType\":1,\"startTime\":" + DataTest.startTime + ",\"target\":" + DataTest.Share_target[0] + ",\"trafficIds\":[" + traffic_id + "],\"url\":\"" + DataTest.url[0] + "\",\"weight\":1}";
//                String AdPlanMixture1_2 = "{\"adsensePositionId\":1,\"advertiserId\":" + DataTest.advertiserId + ",\"ceilingCntDaily\":100,\"checkAllData\":false,\"cityIds\":[" + cityIds + "],\"comment\":\"" + "创建共享广告计划入场推送备注1" + "\",\"content\":\"" + DataTest.createAdvertiseName + "测试进场\",\"endTime\":" + DataTest.endTime + ",\"imageUri\":\"\",\"industryId\":3,\"isRedirect\":0,\"mediaType\":0,\"name\":\"" + DataTest.createAdvertiseName + "_1" + "\",\"parkIds\":[2147483647," + parkids_id + "],\"parkTypeIds\":[2147483647,0],\"price\":" + DataTest.Share_price[0] + ",\"priceTotal\":28,\"priceType\":" + DataTest.Share_priceType[0] + ",\"scheduleIntervalCnt\":" + DataTest.Share_scheduleIntervalCnt[0] + ",\"scheduleIntervalHours\":" + DataTest.Share_scheduleIntervalHours[0] + ",\"scheduleIntervalType\":" + DataTest.Share_scheduleIntervalType[0] + ",\"scheduleType\":1,\"startTime\":" + DataTest.startTime + ",\"target\":" + DataTest.Share_target[0] + ",\"trafficIds\":[" + traffic_id + "],\"url\":\"" + DataTest.url[0] + "\",\"weight\":1}";
//                String AdPlanMixture2 = "{\"adsensePositionId\":2,\"advertiserId\":" + DataTest.advertiserId + ",\"checkAllData\":false,\"cityIds\":[" + cityIds + "],\"comment\":\"创建独占广告计划出场推送备注2\",\"content\":\"文案：独占-2出场\",\"endTime\":" + DataTest.endTime + ",\"imageUri\":\"\",\"industryId\":1,\"isRedirect\":0,\"isSubstitution\":1,\"mediaType\":0,\"name\":\"" + DataTest.createAdvertiseName + "_2" + "\",\"parkIds\":[2147483647," + parkids_id + "],\"parkTypeIds\":[2147483647,0],\"price\":" + DataTest.Indep_price[1] + ",\"priceTotal\":" + DataTest.Indep_priceTotal[1] + ",\"priceType\":" + DataTest.Indep_priceType[1] + ",\"scheduleIntervalType\":0,\"scheduleType\":0,\"startTime\":" + DataTest.startTime + ",\"target\":" + DataTest.Indep_target[1] + ",\"trafficIds\":[" + traffic_id + "],\"url\":\"" + DataTest.url[1] + "\"}";
//                String AdPlanMixture3 = "{\"adsensePositionId\":3,\"advertiserId\":" + DataTest.advertiserId + ",\"checkAllData\":false,\"cityIds\":[" + cityIds + "],\"comment\":\"创建独占广告计划输入车牌备注3\",\"content\":\"\",\"endTime\":" + DataTest.endTime + ",\"imageUri\":\"https://anbokeji.oss-cn-hangzhou.aliyuncs.com/images/20200610/127144414.jpg\",\"industryId\":2,\"isRedirect\":0,\"isSubstitution\":0,\"mediaType\":1,\"name\":\"" + DataTest.createAdvertiseName + "_3" + "\",\"parkIds\":[2147483647," + parkids_id + "],\"parkTypeIds\":[2147483647,0],\"price\":" + DataTest.Indep_price[2] + ",\"priceTotal\":" + DataTest.Indep_priceTotal[2] + ",\"priceType\":" + DataTest.Indep_priceType[2] + ",\"scheduleIntervalType\":0,\"scheduleType\":0,\"startTime\":" + DataTest.startTime + ",\"target\":" + DataTest.Indep_target[2] + ",\"trafficIds\":[" + traffic_id + "],\"url\":\"" + DataTest.url[2] + "\"}";
//                String AdPlanMixture4_1 = "{\"adsensePositionId\":4,\"advertiserId\":" + DataTest.advertiserId + ",\"ceilingCntDaily\":400,\"checkAllData\":false,\"cityIds\":[" + cityIds + "],\"comment\":\"" + "创建共享广告计划支付页面备注4" + "\",\"content\":\"\",\"endTime\":" + DataTest.endTime + ",\"imageUri\":\"" + DataTest.imageUri_4 + "\",\"industryId\":55,\"industryName\":\"测试广告内容-其他\",\"isRedirect\":0,\"mediaType\":3,\"appId\":\"wxc3b7d3c12886ade8\",\"name\":\"" + DataTest.createAdvertiseName + "_4" + "\",\"parkIds\":[2147483647," + parkids_id + "],\"parkTypeIds\":[2147483647,0],\"price\":" + DataTest.Share_priceType[3] + ",\"priceTotal\":120,\"priceType\":" + DataTest.Share_priceType[3] + ",\"scheduleIntervalCnt\":" + DataTest.Share_scheduleIntervalCnt[3] + ",\"scheduleIntervalHours\":" + DataTest.Share_scheduleIntervalHours[3] + ",\"scheduleIntervalType\":" + DataTest.Share_scheduleIntervalType[3] + ",\"scheduleType\":1,\"startTime\":" + DataTest.startTime + ",\"target\":" + DataTest.Share_target[3] + ",\"trafficIds\":[" + traffic_id + "],\"url\":\"" + DataTest.url[3] + "\",\"weight\":4}";
//                String AdPlanMixture4_2 = "{\"adsensePositionId\":4,\"advertiserId\":" + DataTest.advertiserId + ",\"ceilingCntDaily\":400,\"checkAllData\":false,\"cityIds\":[" + cityIds + "],\"comment\":\"" + "创建共享广告计划支付页面备注4" + "\",\"content\":\"\",\"endTime\":" + DataTest.endTime + ",\"imageUri\":\"" + DataTest.imageUri_4 + "\",\"industryId\":55,\"industryName\":\"测试广告内容-其他\",\"isRedirect\":0,\"mediaType\":3,\"appId\":\"wxc3b7d3c12886ade8\",\"name\":\"" + DataTest.createAdvertiseName + "_4" + "\",\"parkIds\":[2147483647," + parkids_id + "],\"parkTypeIds\":[2147483647,0],\"price\":" + DataTest.Share_priceType[3] + ",\"priceTotal\":120,\"priceType\":" + DataTest.Share_priceType[3] + ",\"scheduleIntervalCnt\":" + DataTest.Share_scheduleIntervalCnt[3] + ",\"scheduleIntervalHours\":" + DataTest.Share_scheduleIntervalHours[3] + ",\"scheduleIntervalType\":" + DataTest.Share_scheduleIntervalType[3] + ",\"scheduleType\":1,\"startTime\":" + DataTest.startTime + ",\"target\":" + DataTest.Share_target[3] + ",\"trafficIds\":[" + traffic_id + "],\"url\":\"" + DataTest.url[3] + "\",\"weight\":4}";
//                String AdPlanMixture5 = "{\"adsensePositionId\":5,\"advertiserId\":" + DataTest.advertiserId + ",\"checkAllData\":false,\"cityIds\":[" + cityIds + "],\"comment\":\"创建独占广告计划付款成功备注5\",\"content\":\"\",\"endTime\":" + DataTest.endTime + ",\"imageUri\":\"https://anbokeji.oss-cn-hangzhou.aliyuncs.com/images/20200610/351145032.jpg\",\"industryId\":4,\"isRedirect\":0,\"isSubstitution\":0,\"mediaType\":2,\"name\":\"" + DataTest.createAdvertiseName + "_5" + "\",\"parkIds\":[2147483647," + parkids_id + "],\"parkTypeIds\":[2147483647,0],\"price\":" + DataTest.Indep_price[4] + ",\"priceTotal\":" + DataTest.Indep_priceTotal[4] + ",\"priceType\":" + DataTest.Indep_priceType[4] + ",\"scheduleIntervalType\":0,\"scheduleType\":0,\"startTime\":" + DataTest.startTime + ",\"target\":" + DataTest.Indep_target[4] + ",\"trafficIds\":[" + traffic_id + "],\"url\":\"" + DataTest.url[4] + "\"}";
//                HttpGG.doPost2( DataTest.plan_create_url, AdPlanMixture1_1, DataTest.Access_Token );
//                HttpGG.doPost2( DataTest.plan_create_url, AdPlanMixture1_2, DataTest.Access_Token );
//                HttpGG.doPost2( DataTest.plan_create_url, AdPlanMixture2, DataTest.Access_Token );
//                HttpGG.doPost2( DataTest.plan_create_url, AdPlanMixture3, DataTest.Access_Token );
//                HttpGG.doPost2( DataTest.plan_create_url, AdPlanMixture4_1, DataTest.Access_Token );
//                HttpGG.doPost2( DataTest.plan_create_url, AdPlanMixture4_2, DataTest.Access_Token );
//                HttpGG.doPost2( DataTest.plan_create_url, AdPlanMixture5, DataTest.Access_Token );
//
//            default:
////        System.out.println("计划结果 ： " + AdPlanShareResponse);
//        }
//
//        return null;
//    }

    //曝光exposure
    public static String exposure(String park_Id, String partnerId, String private_key, String adPosId, String mediumType) throws Exception {
        String userLicense = "京A" + randomNumeric(5);
        String openId = randomNumeric(8);
        String userIp = randomNumeric(2) + ".1.1." + randomNumeric(2);
        String responseData = "";
        Map<String, String> getAdvertMap = new HashMap<>();
        getAdvertMap.put("parkId", park_Id);
        getAdvertMap.put("partnerId", partnerId);
        getAdvertMap.put("adPosId", adPosId);
        getAdvertMap.put("userMobile", DataTest.userMobile);
        getAdvertMap.put("userLicense", userLicense);
        getAdvertMap.put("openId", openId);
        getAdvertMap.put("userIp", userIp);
        getAdvertMap.put("mediumType", mediumType);
        String exposure_sign = ECCSignUtil.sign(private_key, getAdvertMap);
        getAdvertMap.put("sign", exposure_sign);
        String exposure_json = JSONObject.toJSONString(getAdvertMap);
        String exposure_params = "?" + "adPosId=" + adPosId + "&" + "parkId=" + park_Id + "&" + "partnerId=" + partnerId + "&" + "openId=" + openId + "&" + "userMobile=" + DataTest.userMobile + "&" + "userLicense=" + userLicense + "&" + "userIp=" + userIp + "&" + "sign=" + exposure_sign;
//        String exposure_params = "?" + "adPosId=" + adPosId + "&" + "parkId=" + park_Id + "&" + "partnerId=" + partnerId + "&" +"openId="+openId + "&" + "userMobile=" + userMobile + "&"+ "userIp=" + userIp + "sign=" + exposure_sign;
        try {
            responseData = doGet02(DataTest.exposure_url + exposure_params, exposure_json);
        } catch (Exception e) {
            System.out.println(e);
        }

        Map<String, Object> resultMap = JSON.parseObject(responseData, Map.class);
        if (resultMap.get("status").equals("20000000")) {
            String result = resultMap.get("result").toString();
            Map<String, String> result_map = JSONObject.parseObject(result, new TypeReference<Map<String, String>>() {
            });
            String adId = result_map.get("adId").toString();
            System.out.println("广告计划uuid - adId: " + adId);
            return adId;
        } else {
            System.out.println("曝光失败！");
            return null;
        }
    }

    //曝光exposure【POST】
    public static String exposure_POST(String park_Id, String partnerId, String private_key, String adPosId) throws Exception {
        String userLicense = "京A27848";
        String openId = "53294186";
        String userIp = "55.1.1.98";
        String responseData = "";
        Map<String, String> getAdvertMap = new HashMap<>();
        getAdvertMap.put("parkId", park_Id);
        getAdvertMap.put("partnerId", partnerId);
        getAdvertMap.put("adPosId", adPosId);
        getAdvertMap.put("userMobile", DataTest.userMobile);
        getAdvertMap.put("userMobile", "18811321090");
        getAdvertMap.put("userLicense", userLicense);
        getAdvertMap.put("openId", openId);
        getAdvertMap.put("userIp", userIp);
        String exposure_sign = ECCSignUtil.sign(private_key, getAdvertMap);
        getAdvertMap.put("sign", exposure_sign);
//        getAdvertMap.put("sign", "MEUCIGDAQXp45GYzESJXdDsrrPcL+BFsLpPlP7goDinom/otAiEAypOz77sC8gYepghwOnoN25ArB86YQGCkuSWoIpfvOJQ=");
        String exposure_json = JSONObject.toJSONString(getAdvertMap);
        try {
            responseData = doPost2(DataTest.exposure_url, exposure_json, exposure_json);
        } catch (Exception e) {
            System.out.println(e);
        }

        Map<String, Object> resultMap = JSON.parseObject(responseData, Map.class);
        if (resultMap.get("status").equals("20000000")) {
            String result = resultMap.get("result").toString();
            Map<String, String> result_map = JSONObject.parseObject(result, new TypeReference<Map<String, String>>() {
            });
            String adId = result_map.get("adId").toString();
            System.out.println("广告计划uuid - adId: " + adId);
            return adId;
        } else {
            System.out.println("曝光失败！");
            return null;
        }
    }

    public static String exposure_POSTNew(String park_Id, String partnerId, String private_key, String adPosId, String medium) throws Exception {
        String userLicense = "京A" + randomNumeric(5);
        String openId = randomNumeric(8);
        String userIp = randomNumeric(2) + ".1.1." + randomNumeric(2);
        String responseData = "";
        Map<String, String> getAdvertMap = new HashMap<>();
        getAdvertMap.put("parkId", park_Id);
        getAdvertMap.put("partnerId", partnerId);
        getAdvertMap.put("adPosId", adPosId);
        getAdvertMap.put("userMobile", DataTest.userMobile);
        getAdvertMap.put("userLicense", userLicense);
        getAdvertMap.put("openId", openId);
        getAdvertMap.put("userIp", userIp);
        getAdvertMap.put("medium", medium);
        String exposure_sign = ECCSignUtil.sign(private_key, getAdvertMap);
        getAdvertMap.put("sign", exposure_sign);
        String exposure_json = JSONObject.toJSONString(getAdvertMap);
        try {
            responseData = doPost(DataTest.exposure_urlNew, exposure_json);
        } catch (Exception e) {
            System.out.println(e);
        }

        Map<String, Object> resultMap = JSON.parseObject(responseData, Map.class);
        if (resultMap.get("status").equals("20000000")) {
            String result = resultMap.get("result").toString();
            return result;
        } else {
            System.out.println("曝光失败！");
            return null;
        }
    }

    public static String exposure_GetNew(String park_Id, String partnerId, String private_key, String adPosId, String medium) throws Exception {
        String userLicense = "京A" + randomNumeric(5);
        String openId = randomNumeric(8);
        String userIp = randomNumeric(2) + ".1.1." + randomNumeric(2);
//        String userLicense = "京A27848";
//        String openId = "53294186";
//        String userIp = "55.1.1.98";
        String responseData = "";
        Map<String, String> getAdvertMap = new HashMap<>();
        getAdvertMap.put("parkId", park_Id);
        getAdvertMap.put("partnerId", partnerId);
        getAdvertMap.put("adPosId", adPosId);
//        getAdvertMap.put("userMobile", DataTest.userMobile);
        getAdvertMap.put("userMobile", "18811321090");
        getAdvertMap.put("userLicense", userLicense);
        getAdvertMap.put("openId", openId);
        getAdvertMap.put("userIp", userIp);
        getAdvertMap.put("medium", medium);
        String exposure_sign = ECCSignUtil.sign(private_key, getAdvertMap);
        getAdvertMap.put("sign", exposure_sign);
//        getAdvertMap.put("sign", "MEUCIGDAQXp45GYzESJXdDsrrPcL+BFsLpPlP7goDinom/otAiEAypOz77sC8gYepghwOnoN25ArB86YQGCkuSWoIpfvOJQ=");

        String exposure_json = JSONObject.toJSONString(getAdvertMap);
        try {
            responseData = doGet02(DataTest.exposure_urlNew, exposure_json);
        } catch (Exception e) {
            System.out.println(e);
        }

        Map<String, Object> resultMap = JSON.parseObject(responseData, Map.class);
        if (resultMap.get("status").equals("20000000")) {
            String result = resultMap.get("result").toString();
            return result;
        } else {
            System.out.println("曝光失败！");
            return null;
        }
    }

    public static String exposure_sjxp_POST(String park_Id, String partnerId, String private_key) throws Exception {
        String  responseData ="";
        String userLicense = "京A" + randomNumeric(5);
        String openId = randomNumeric(8);
        String userIp = randomNumeric(2) + ".1.1." + randomNumeric(2);
        Map<String, String> getAdvertMap = new HashMap<>();
        getAdvertMap.put("parkId", park_Id);
        getAdvertMap.put("partnerId", partnerId);
        getAdvertMap.put("userMobile", DataTest.userMobile);
        getAdvertMap.put("userLicense", userLicense);
        getAdvertMap.put("openId", openId);
        getAdvertMap.put("userIp", userIp);
        String exposure_sign = ECCSignUtil.sign(private_key, getAdvertMap);
        getAdvertMap.put("sign", exposure_sign);
        String exposure_json = JSONObject.toJSONString(getAdvertMap);
        try {
           responseData = doPost2(DataTest.exposure_sjxp_url, exposure_json, exposure_json);
        } catch (Exception e) {
            System.out.println(e);
        }

        Map<String, Object> resultMap = JSON.parseObject(responseData, Map.class);
        if (resultMap.get("status").equals("20000000")) {
            String result = resultMap.get("result").toString();
            Map<String, String> result_map = JSONObject.parseObject(result, new TypeReference<Map<String, String>>() {
            });
            String adId = result_map.get("adId").toString();
            System.out.println("广告计划uuid - adId: " + adId);
            return adId;
        } else {
            System.out.println("曝光失败！");
            return null;
        }
    }
    public static String exposure_sjxp_get(String park_Id, String partnerId, String private_key) throws Exception {
        String userLicense = "京A" + randomNumeric(5);
        String openId = randomNumeric(8);
        String userIp = randomNumeric(2) + ".1.1." + randomNumeric(2);
        String responseData = "";
        Map<String, String> getAdvertMap = new HashMap<>();
        getAdvertMap.put("parkId", park_Id);
        getAdvertMap.put("partnerId", partnerId);
        getAdvertMap.put("userMobile", DataTest.userMobile);
        getAdvertMap.put("userLicense", userLicense);
        getAdvertMap.put("openId", openId);
        getAdvertMap.put("userIp", userIp);
       String exposure_sign = ECCSignUtil.sign(private_key, getAdvertMap);
        getAdvertMap.put("sign", exposure_sign);
        String exposure_json = JSONObject.toJSONString(getAdvertMap);
        try {
            responseData = doGet02(DataTest.exposure_sjxp_url, exposure_json);
        } catch (Exception e) {
            System.out.println(e);
        }

        Map<String, Object> resultMap = JSON.parseObject(responseData, Map.class);
        if (resultMap.get("status").equals("20000000")) {
            String result = resultMap.get("result").toString();
            return result;
        } else {
            System.out.println("曝光失败！");
            return null;
        }
    }
    //点击click
    public static void click(String url, String adId, String park_Id, String partnerId, String private_key) throws Exception {
        String openId = randomNumeric(8);
        String userLicense = "京A" + randomNumeric(5);
        String userMobile="188" + randomNumeric(7);
        Map<String, String> clickMap = new HashMap<>();
        clickMap.put("adId", adId);
        clickMap.put("parkId", park_Id);
        clickMap.put("partnerId", partnerId);
        clickMap.put("userMobile", userMobile);
        clickMap.put("userLicense", userLicense);
        clickMap.put("openId", openId);
        String sign = ECCSignUtil.sign(private_key, clickMap);
        clickMap.put("sign", sign);
        String click_json = JSONObject.toJSONString(clickMap);
//        String click_params = "?" + "adId=" + adId + "&" + "partnerId=" + partnerId + "&" + "parkId=" + park_Id + "&" +"openId="+openId+ "&" + "userLicense=" + userLicense +"&" + "userMobile=" + userMobile +"&"+ "sign=" + click_sign;
//        String click_params = "?" + "adId=" + adId + "&" + "partnerId=" + partnerId + "&" + "parkId=" + park_Id +  "&" + "sign=" + sign;
        String click_params = "?" + "adId=" + adId + "&" + "partnerId=" + partnerId + "&" + "parkId=" + park_Id + "&" + "openId=" + openId + "&" + "userMobile=" + userMobile +"&"+"userLicense="+userLicense+ "&" + "sign=" + sign;
        String res = "";
        try {
            res = doGet02(url + click_params, click_json);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //点击click【POST请求】
    public static void click_POST(String adId, String park_Id, String partnerId, String private_key) throws Exception {
        String openId = randomNumeric(8);
//        String userLicense = "川A" + randomNumeric(5);
        Map<String, String> clickMap = new HashMap<>();
        clickMap.put("adId", adId);
        clickMap.put("parkId", park_Id);
        clickMap.put("partnerId", partnerId);
        clickMap.put("userMobile", DataTest.userMobile);
//        clickMap.put("userLicense", userLicense);
        clickMap.put("openId", openId);
        String click_sign = ECCSignUtil.sign(private_key, clickMap);
        clickMap.put("sign", click_sign);
        String click_json = JSONObject.toJSONString(clickMap);
//        System.out.println(click_json);
        try {
            doPost2(DataTest.click_url, click_json, click_json);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    //曝光并且点击
    public static void openAndClick(String park_Id, String partnerId, String private_key, String adPosId, int openCount, int clickCount, String mediumType) throws Exception {
        //首先曝光一次
        String adId = "";
        try {
//            adId = exposure(park_Id , partnerId ,private_key ,adPosId);
            for (int tmp1 = 0; tmp1 < openCount; tmp1++) {
                adId = exposure(park_Id, partnerId, private_key, adPosId, mediumType);
                if (clickCount-- > 0 && adId != null) {
//                    非小程序
                    click(DataTest.click_url, adId, park_Id, partnerId, private_key);
//                    小程序
//                    click(DataTest.click_url_landing,adId, park_Id, partnerId, private_key);
                }
            }
            //点击click
//            for (int tmp2 = 0;tmp2 < clickCount ;tmp2++){
//
//            }
        } catch (NullPointerException e) {
            System.out.println("曝光失败，空指针异常！");
        } catch (UnknownHostException e) {
            System.out.println("曝光失败，域名无法访问！");
        } catch (Exception e) {
            System.out.println("其他异常：" + e);
        }
    }

    //运营后台登录
    public static String loginGetToken(String username, String password) throws IOException {
        Map<String, String> loginMap = new HashMap<>();
        loginMap.put("username", username);
        loginMap.put("password", password);
        String response = HttpGG.doPost(DataTest.login_url, JSONObject.toJSONString(loginMap));
        System.out.println("response ： " + response);
        Map<String, Object> resultMap = JSON.parseObject(response, Map.class);

        String result = resultMap.get("result").toString();
        Map<String, String> result_map = JSONObject.parseObject(result, new TypeReference<Map<String, String>>() {
        });
        String token = result_map.get("token");
        System.out.println("token ： " + token);
        return token;
    }
}
