package com.qb.ad.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.qb.ad.entity.DataTest;
import com.zzrb.util.ECCCryptUtil;
import com.zzrb.util.ECCSignUtil;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import static com.qb.ad.entity.BaseData.encrypt;
import static com.qb.ad.util.HttpGG.*;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

/**
 * *************************测试环境*************************
 * 创建流量主、更新流量主
 * 创建车场、更新车场、获取车场
 * 新增广告位、更新广告位、获取广告位
 * 曝光、点击、曝光且点击
 * 后台登录
 */
public class ApiUtilsTest {
   public static String userLicense = "京A" + randomNumeric(5);
    public static  String openId = randomNumeric(8);
    public static   String userIp = randomNumeric(2) + ".1.1." + randomNumeric(2);

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
            String responseData = HttpGG.doPost(DataTest.create_account_url, json);
            System.out.println("创建流量主名称name ： " + DataTest.name);

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

    //创建车场partnerId
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
    public static String exposureScenePost(String gridId, String partnerId, String private_key, String adPosId, String medium) throws Exception {
        String userLicense = "京A" + randomNumeric(5);
        String openId = randomNumeric(8);
        String userIp = randomNumeric(2) + ".1.1." + randomNumeric(2);
        String responseData = "";
        Map<String, String> getAdvertMap = new HashMap<>();
        getAdvertMap.put("gridId", gridId);
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
            responseData = doPost(DataTest.exposure_url_scene, exposure_json);
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
        getAdvertMap.put("userMobile", "188" + randomNumeric(7));
//        getAdvertMap.put("userMobile", "18811321090");
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

    //    商家小票曝光无场景POST
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
//    商家小票场景曝光post
    public static String exposure_sjxp_scene_Post(String gridId, String partnerId, String private_key) throws Exception {
        String  responseData ="";
        String userLicense = "京A" + randomNumeric(5);
        String openId = randomNumeric(8);
        String userIp = randomNumeric(2) + ".1.1." + randomNumeric(2);
        Map<String, String> getAdvertMap = new HashMap<>();
        getAdvertMap.put("gridId", gridId);
        getAdvertMap.put("partnerId", partnerId);
        getAdvertMap.put("userMobile", DataTest.userMobile);
        getAdvertMap.put("userLicense", userLicense);
        getAdvertMap.put("openId", openId);
        getAdvertMap.put("userIp", userIp);
        String exposure_sign = ECCSignUtil.sign(private_key, getAdvertMap);
        getAdvertMap.put("sign", exposure_sign);
        String exposure_json = JSONObject.toJSONString(getAdvertMap);
        try {
            responseData = doPost(DataTest.exposure_sjxp_scene, exposure_json);
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
//    商家小票曝光无场景GET
    public static String exposure_sjxp_get(String park_Id, String partnerId, String private_key) throws Exception {
        String userLicense = "京A" + randomNumeric(5);
        String openId = randomNumeric(8);
        String userIp = randomNumeric(2) + ".1.1." + randomNumeric(2);
        String responseData = "";
        Map<String, String> getAdvertMap = new HashMap<>();
        getAdvertMap.put("park_Id", park_Id);
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
        String click_params = "?" + "adId=" + adId + "&" + "partnerId=" + partnerId + "&" + "parkId=" + park_Id + "&" + "openId=" + openId + "&" + "userMobile=" + userMobile +"&"+"userLicense="+userLicense+ "&" + "sign=" + sign;
        String res = "";
        try {
            res = doGet02(url + click_params, click_json);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //点击click
    public static void clickScene( String adId, String gridId, String partnerId, String private_key) throws Exception {
        String openId = randomNumeric(8);
        String userLicense = "京A" + randomNumeric(5);
        String userMobile="188" + randomNumeric(7);
        Map<String, String> clickMap = new HashMap<>();
        clickMap.put("adId", adId);
        clickMap.put("gridId", gridId);
        clickMap.put("partnerId", partnerId);
        clickMap.put("userMobile", userMobile);
        clickMap.put("userLicense", userLicense);
        clickMap.put("openId", openId);
        clickMap.put("userIp", userIp);
        String sign = ECCSignUtil.sign(private_key, clickMap);
        clickMap.put("sign", sign);
        String click_json = JSONObject.toJSONString(clickMap);
        String res = "";
        try {
            res = doPost(DataTest.click_url_scene, click_json);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //点击上报click【场景】
    public static void click_POST(String adId, String park_Id, String partnerId, String private_key) throws Exception {
        String openId = randomNumeric(8);
        String userLicense = "川A" + randomNumeric(5);
        Map<String, String> clickMap = new HashMap<>();
        clickMap.put("adId", adId);
        clickMap.put("parkId", park_Id);
        clickMap.put("partnerId", partnerId);
        clickMap.put("userMobile", DataTest.userMobile);
        clickMap.put("userLicense", userLicense);
        clickMap.put("openId", openId);
        String click_sign = ECCSignUtil.sign(private_key, clickMap);
        clickMap.put("sign", click_sign);
        String click_json = JSONObject.toJSONString(clickMap);
        try {
            doPost2(DataTest.click_url_up, click_json, click_json);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
//    场景小程序上报点击
    public static void clickUpScene (String adId, String gridId, String partnerId, String private_key) throws Exception {
        String openId = randomNumeric(8);
        String userLicense = "川A" + randomNumeric(5);
        Map<String, String> clickMap = new HashMap<>();
        clickMap.put("adId", adId);
        clickMap.put("gridId", gridId);
        clickMap.put("partnerId", partnerId);
        clickMap.put("userMobile", DataTest.userMobile);
        clickMap.put("userLicense", userLicense);
        clickMap.put("openId", openId);
        clickMap.put("userIp", userIp);
        String click_sign = ECCSignUtil.sign(private_key, clickMap);
        clickMap.put("sign", click_sign);
        String click_json = JSONObject.toJSONString(clickMap);
        try {
            doPost(DataTest.click_scene_up, click_json);
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

    //**场景**流量主新增场地
    public static String createGrid(String partnerId, String private_key, String scene) throws Exception {
        try {
            //接口地址：[POST] https://api-test.anbokeji.net/api/v1/grid
            Map <String, String> sceneMap = new HashMap <>();
            sceneMap.put("partnerId", partnerId);//流量主ID
            sceneMap.put("gridId", DataTest.gridId);//自定义场地ID(非必填)
            sceneMap.put("gridName", DataTest.parkName);//场地名称
            sceneMap.put("scene", scene);//场地场景
            sceneMap.put("cityId", DataTest.cityId);//城市ID
            sceneMap.put("type", "0");//场地类型(非必填)
            //场地类型枚举： 0其他1商超2写字楼3酒店4风景区5游乐场6医院7事业单位8交通枢纽9住宅小区
            sceneMap.put("lng", "东经116°20");//经度(非必填)
            sceneMap.put("lat", "北纬39°56′");//纬度(非必填)
            String parkSign = ECCSignUtil.sign(private_key, sceneMap);
            sceneMap.put("sign", parkSign);
            String park_json = JSONObject.toJSONString(sceneMap);
            String requestData = doPost(DataTest.grid_url, park_json);
            Map <String, Object> resultMap = JSON.parseObject(requestData, Map.class);
            String result = resultMap.get("result").toString();
            Map <String, String> result_map = JSONObject.parseObject(result, new TypeReference <Map <String, String>>() {
            });
            String gridId = result_map.get("gridId").toString();
            System.out.println("场地ID gridId: " + gridId);
            return gridId;
        } catch (Exception e) {
            System.out.println("新增场地失败：" + e);
        }
        return null;
    }
    //**场景**流量主更新场地
    public static void updateGrid(String gridId, String partnerId, String private_key,String scene) throws Exception {
        try {
            //接口地址：[PUT] https://api-test.anbokeji.net/api/v1/grid
            Map<String, String> sceneMap = new HashMap<>();
            sceneMap.put("partnerId", partnerId);//流量主ID(必填)
            sceneMap.put("gridId", gridId);//自定义场地ID(必填)
            sceneMap.put("gridName", DataTest.parkName);//场地名称
            sceneMap.put("scene", scene);//场地场景
            sceneMap.put("cityId", DataTest.cityId);//城市ID
            sceneMap.put("type", "0");//场地类型
            //场地类型枚举:0其他1商超2写字楼3酒店4风景区5游乐场6医院7事业单位8交通枢纽9住宅小区
            sceneMap.put("lng", "东经116°20");//经度(非必填)
            sceneMap.put("lat", "北纬39°56′");//纬度(非必填)
            String parkSign = ECCSignUtil.sign(private_key, sceneMap);
            sceneMap.put("sign", parkSign);
            String park_json = JSONObject.toJSONString(sceneMap);
            HttpGG.doPut(DataTest.grid_url, park_json);
        } catch (Exception e) {
            System.out.println("更新场地失败：" + e);
        }
    }

    //**场景**根据场地ID，流量主ID获取场地信息
    public static void getGrid(String gridId, String partnerId) {
        //接口地址：[GET] https://api-test.anbokeji.net/api/v1/grid
        try {
            Map<String, String> map = new HashMap<>();
            map.put("gridId", gridId);
            map.put("partnerId", partnerId);
            String json = JSONObject.toJSONString(map);
            System.out.println(json);
            String params = "?" + "gridId=" + gridId + "&" + "partnerId=" + partnerId;
            doGet02(DataTest.grid_url + params, json);
        } catch (Exception e) {

        }
    }
    //**场地场景****开通广告页
    public static void createSceneAdvertisePosition(String adPosIds, String gridId, String partnerId, String private_key) {
        try {
            //接口地址：[POST] https://api-test.anbokeji.net/api/v1/grid-pos
            Map<String, String> adPosMap = new HashMap<>();
            adPosMap.put("adPosIds", adPosIds);//若是多个广告页ID，则以#分割
            adPosMap.put("partnerId", partnerId);
            adPosMap.put("gridId", gridId);
            String adPosSign = ECCSignUtil.sign(private_key, adPosMap);
            adPosMap.put("sign", adPosSign);
            String adPos_json = JSONObject.toJSONString(adPosMap);
            doPost(DataTest.adPos_grid_url, adPos_json);
        } catch (Exception e) {
            System.out.println("新增带场景广告位失败！");
        }
    }

    //**场地场景****获取广告页信息
    public static void getSceneAdvertisePosition(String gridId, String partnerId) {
        try {//接口地址：[GET] https://api-test.anbokeji.net/api/v1/grid-pos
            Map<String, String> adPosMap = new HashMap<>();
            adPosMap.put("gridId", gridId);
            adPosMap.put("partnerId", partnerId);
            String json = JSONObject.toJSONString(adPosMap);
            System.out.println(json);
            String params = "?" + "gridId=" + gridId + "&" + "partnerId=" + partnerId;
            doGet02(DataTest.adPos_grid_url + params, json);
        } catch (Exception e) {
            System.out.println("获取场景广告位失败！");
        }
    }
}
