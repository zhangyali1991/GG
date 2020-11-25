package com.qb.ad.util;

import com.qb.ad.entity.DataProduct;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.zzrb.util.ECCCryptUtil;
import com.zzrb.util.ECCSignUtil;

import java.util.HashMap;
import java.util.Map;

import static com.qb.ad.entity.BaseData.anboPubKey;
import static com.qb.ad.util.HttpGG.*;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
/**
 * *************************生产环境*************************
 * 创建流量主、更新流量主
 * 创建车场、更新车场、获取车场
 * 新增广告位、更新广告位、获取广告位
 * 曝光和点击
 */
public class ApiUtilsPro {
    static String userLicense = "川A" + randomNumeric(5);
    static String openId =  randomNumeric(8);
    static String userIp = randomNumeric(2)+"."+randomNumeric(1)+"."+randomNumeric(1)+"."+ randomNumeric(2);

    //生成流量主账户
    public static String createAccount(String public_key ,String private_key) throws Exception{
        try {
        Map<String, String> createAccountMap = new HashMap<String,String>();
        createAccountMap.put("name", DataProduct.name);//用户名称
        createAccountMap.put("regType", DataProduct.regType);//注册类型
        createAccountMap.put("cityId", DataProduct.cityId);//所在城市
        createAccountMap.put("accountType", DataProduct.accountType);//客户类型? 0:车场; 1:媒介; 3:代理商
        createAccountMap.put("contactName", DataProduct.contactName);//联系人
        createAccountMap.put("contactMobile", DataProduct.contactMobile);//联系电话
        createAccountMap.put("source", DataProduct.source);//客户来源
        createAccountMap.put("manager", DataProduct.manager);//客户经理
        createAccountMap.put("accountName", DataProduct.accountName);//开户人名称
        createAccountMap.put("bankName", DataProduct.bankName);//银行名称
        createAccountMap.put("accountNo", DataProduct.accountNo);//银行名称
        createAccountMap.put("password", ECCCryptUtil.encrypt(DataProduct.password, anboPubKey));//登录密码
        createAccountMap.put("publicKey", public_key);//公钥
        String createAccountSign = ECCSignUtil.sign(private_key, createAccountMap);
        System.out.println("创建流量主sign ： " + createAccountSign);
        createAccountMap.put("sign", createAccountSign);
        String json = JSONObject.toJSONString(createAccountMap);
        String responseData = HttpGG.doPost(DataProduct.create_account_url, json);
        System.out.println("创建流量主名称name ： " + DataProduct.name);
//        System.out.println("创建流量主resultresult ： " + result);

        Map<String, Object> resultMap = JSON.parseObject(responseData, Map.class);
        String result = resultMap.get( "result" ).toString();
        Map<String, String> result_map = JSONObject.parseObject(result, new TypeReference<Map<String, String>>(){});
        String partnerId = result_map.get( "partnerId" );
        System.out.println("创建流量主-partnerId ： "+ partnerId);
        return  partnerId;
        }catch (Exception e) {
            System.out.println("创建账户失败:" + e);
        }
        return null;
    }
     //更新流量主账户
     public static void updateAccount(String private_key) throws Exception {
         try {
             Map<String, String> updateAccountMap = new HashMap<String,String>();
             updateAccountMap.put("name", DataProduct.name);//用户名称
             updateAccountMap.put("regType", DataProduct.regType);//注册类型
             updateAccountMap.put("cityId", DataProduct.cityId);//所在城市
             updateAccountMap.put("accountType", DataProduct.accountType);//客户类型? 0:车场; 1:媒介; 3:代理商
             updateAccountMap.put("contactName", DataProduct.contactName);//联系人
             updateAccountMap.put("contactMobile", DataProduct.contactMobile);//联系电话
             updateAccountMap.put("source", DataProduct.source);//客户来源
             updateAccountMap.put("manager", DataProduct.manager);//客户经理
             updateAccountMap.put("accountName", DataProduct.accountName);//开户人名称
             updateAccountMap.put("bankName", DataProduct.bankName);//银行名称
             updateAccountMap.put("accountNo", DataProduct.accountNo);//银行名称
             updateAccountMap.put("password", ECCCryptUtil.encrypt(DataProduct.password, anboPubKey));//登录密码
             updateAccountMap.put("partnerId", DataProduct.partnerId);//公钥
             String updateAccountSign = ECCSignUtil.sign(private_key, updateAccountMap);
             System.out.println("更新流量主sign ： " + updateAccountSign);
             updateAccountMap.put("sign", updateAccountSign);
             String json = JSONObject.toJSONString(updateAccountMap);
             HttpGG.doPut(DataProduct.create_account_url, json);

         }catch (Exception e) {
             System.out.println("创建账户失败:" + e);
         }
     }

    //创建车场
    public static String createPark(String partnerId ,String private_key) throws Exception{
        try {
            Map<String, String> parkMap = new HashMap<>();
//            parkMap.put("parkId", "010222222222222");
            parkMap.put("parkName", DataProduct.parkName);
            parkMap.put("cityId", DataProduct.parkCityId);
//            parkMap.put("status", DataProduct.updateStatus);
            parkMap.put("partnerId", partnerId);
            String parkSign = ECCSignUtil.sign(private_key, parkMap);
            parkMap.put("sign", parkSign);
            String park_json = JSONObject.toJSONString(parkMap);
            String requestData = doPost(DataProduct.park_url_2, park_json);
            Map<String, Object> resultMap = JSON.parseObject(requestData, Map.class);
            String result = resultMap.get( "result" ).toString();
            Map<String, String> result_map = JSONObject.parseObject(result, new TypeReference<Map<String, String>>(){});
            String parkId = result_map.get( "parkId" ).toString();
            System.out.println("车场ID parkId: " + parkId);
            return parkId;
        }catch (Exception e){
            System.out.println("新增车场失败：" + e);
        }
        return null;
    }
    //更新车场
    public static void updatePark(String parkId, String partnerId ,String private_key) throws Exception{
        try {
            Map<String, String> parkMap = new HashMap<>();
            parkMap.put("parkName", DataProduct.updateparkName);
            parkMap.put("cityId", DataProduct.parkCityId);
//            parkMap.put("status", DataProduct.updateStatus);    //v2需要注释
            parkMap.put("partnerId", partnerId);
            parkMap.put("parkId", parkId);
            String parkSign = ECCSignUtil.sign(private_key, parkMap);
            parkMap.put("sign", parkSign);
            String park_json = JSONObject.toJSONString(parkMap);
            HttpGG.doPut(DataProduct.park_url_2, park_json);

        }catch (Exception e){
            System.out.println("更新车场失败：" + e);
        }
    }
    //获取车场
    public static void getPark(String parkId, String partnerId) {
        try {
            Map<String, String> map = new HashMap<>();
//            map.put("parkId", parkId);
            map.put("partnerId", partnerId);
            String json = JSONObject.toJSONString(map);System.out.println(json);
            String params = "?" + "parkId=" + parkId + "&" + "partnerId=" + partnerId;
            doGet02(DataProduct.park_url_1 + params,json);  //只支持v1版本
        } catch (Exception e) {

        }
    }

    //新增或更新广告位
    public static void createAdvertisePosition(String adPosIds ,String parkId,String partnerId,String private_key,String medium){
        try {
            Map<String, String> adPosMap = new HashMap<>();
            adPosMap.put("adPosIds", adPosIds);
            adPosMap.put("partnerId", partnerId);
            adPosMap.put("parkId", parkId);
            adPosMap.put("medium",medium);
            String adPosSign = ECCSignUtil.sign(private_key, adPosMap);
            adPosMap.put("sign", adPosSign);
            String adPos_json = JSONObject.toJSONString(adPosMap);
            doPut( DataProduct.adPos_url_3,adPos_json);
        } catch (Exception e) {
            System.out.println("新增广告位失败！");
        }
    }
    public static void createAdvertisePositionV1(String adPosIds ,String parkId,String partnerId,String private_key){
        try {
            Map<String, String> adPosMap = new HashMap<>();
            adPosMap.put("adPosIds", adPosIds);
            adPosMap.put("partnerId", partnerId);
            adPosMap.put("parkId", parkId);
            adPosMap.put( "status", "1" );  //v2版本需要注释
            String adPosSign = ECCSignUtil.sign(private_key, adPosMap);
            adPosMap.put("sign", adPosSign);
            String adPos_json = JSONObject.toJSONString(adPosMap);
            doPut( DataProduct.adPos_url_1,adPos_json);
        } catch (Exception e) {
            System.out.println("新增广告位失败！");
        }
    }
    public static void createAdvertisePositionV2(String adPosIds ,String parkId,String partnerId,String private_key){
        try {
            Map<String, String> adPosMap = new HashMap<>();
            adPosMap.put("adPosIds", adPosIds);
            adPosMap.put("partnerId", partnerId);
            adPosMap.put("parkId", parkId);
            adPosMap.put( "status", "1" );  //v2版本需要注释
            String adPosSign = ECCSignUtil.sign(private_key, adPosMap);
            adPosMap.put("sign", adPosSign);
            String adPos_json = JSONObject.toJSONString(adPosMap);
            doPut( DataProduct.adPos_url_2,adPos_json);
        } catch (Exception e) {
            System.out.println("新增广告位失败！");
        }
    }
    //获取广告位
    public static void getAdvertisePosition(String parkId,String partnerId,String private_key){
        try {
            Map<String, String> adPosMap = new HashMap<>();
            adPosMap.put("parkId", parkId);
            adPosMap.put("partnerId", partnerId);
            String json = JSONObject.toJSONString(adPosMap);
            System.out.println(json);
            String params = "?" + "parkId=" + parkId + "&" + "partnerId=" + partnerId;
            doGet02(DataProduct.adPos_url_1 + params,json);  //只支持v1版本
        } catch (Exception e) {
            System.out.println("新增广告位失败！");
        }
    }

    //曝光传媒体类型
    public static String exposure_new(String park_Id ,String partnerId ,String private_key ,String adPosId,String medium) throws Exception{
        String userLicense = "京A" + randomNumeric(5);
        String openId =  randomNumeric(8);
        String userIp = randomNumeric(2)+".1.1."+ randomNumeric(2);
        String responseData = "";
        Map <String, String> getAdvertMap = new HashMap <>();
        getAdvertMap.put("parkId", park_Id);
        getAdvertMap.put("partnerId", partnerId);
        getAdvertMap.put("adPosId", adPosId);
        getAdvertMap.put("userMobile", DataProduct.userMobile);
        getAdvertMap.put("userLicense", userLicense);
        getAdvertMap.put("openId", openId);
        getAdvertMap.put("userIp", userIp);
        getAdvertMap.put("medium", medium);
        String exposure_sign = ECCSignUtil.sign(private_key, getAdvertMap);
        getAdvertMap.put("sign", exposure_sign);
        String exposure_json = JSONObject.toJSONString(getAdvertMap);

        try {
            responseData = doGet02(DataProduct.exposure_url_new ,exposure_json);
        }catch (Exception e){
            System.out.println(e);
        }

        Map<String, Object> resultMap = JSON.parseObject(responseData, Map.class);
        if(resultMap.get( "status" ).equals( "20000000" )){
            String result = resultMap.get( "result" ).toString();
            return responseData ;
        }else {
            System.out.println("曝光失败！");
            return "";
        }
    }
    public static String exposure_sjxp(String park_Id ,String partnerId ,String private_key) throws Exception{
        String userLicense = "京A" + randomNumeric(5);
        String openId =  randomNumeric(8);
        String userIp = randomNumeric(2)+".1.1."+ randomNumeric(2);
        String responseData = "";
        Map <String, String> getAdvertMap = new HashMap <>();
        getAdvertMap.put("parkId", park_Id);
        getAdvertMap.put("partnerId", partnerId);
        getAdvertMap.put("userMobile", DataProduct.userMobile);
        getAdvertMap.put("userLicense", userLicense);
        getAdvertMap.put("openId", openId);
        getAdvertMap.put("userIp", userIp);
        String exposure_sign = ECCSignUtil.sign(private_key, getAdvertMap);
        getAdvertMap.put("sign", exposure_sign);
        String exposure_json = JSONObject.toJSONString(getAdvertMap);

        try {
            responseData = doGet02(DataProduct.exposure_url_new ,exposure_json);
        }catch (Exception e){
            System.out.println(e);
        }

        Map<String, Object> resultMap = JSON.parseObject(responseData, Map.class);
        if(resultMap.get( "status" ).equals( "20000000" )){
            String result = resultMap.get( "result" ).toString();
            return responseData ;
        }else {
            System.out.println("曝光失败！");
            return "";
        }
    }
    public static Map<String, String> exposure(String park_Id ,String partnerId ,String private_key ,String adPosId) throws Exception{
        String userLicense = "京A" + randomNumeric(5);
        String openId =  randomNumeric(8);
        String userIp = randomNumeric(2)+".1.1."+ randomNumeric(2);
        String responseData = "";
        Map <String, String> getAdvertMap = new HashMap <>();
        getAdvertMap.put("parkId", park_Id);
        getAdvertMap.put("partnerId", partnerId);
        getAdvertMap.put("adPosId", adPosId);
        getAdvertMap.put("userMobile", DataProduct.userMobile);
        getAdvertMap.put("userLicense", userLicense);
        getAdvertMap.put("openId", openId);
        getAdvertMap.put("userIp", userIp);
        String exposure_sign = ECCSignUtil.sign(private_key, getAdvertMap);
        getAdvertMap.put("sign", exposure_sign);
        String exposure_json = JSONObject.toJSONString(getAdvertMap);
        String exposure_params = "?" + "adPosId=" + adPosId + "&" + "parkId=" + park_Id + "&" + "partnerId=" + partnerId + "&"+ "openId="+openId + "&" + "userMobile=" + DataProduct.userMobile + "&" + "userLicense=" + userLicense + "&"+ "userIp=" + userIp + "&" + "sign=" + exposure_sign;
//        String exposure_params = "?" + "adPosId=" + adPosId + "&" + "parkId=" + park_Id + "&" + "partnerId=" + partnerId + "&" +"openId="+openId + "&" + "userMobile=" + userMobile + "&"+ "userIp=" + userIp + "sign=" + exposure_sign;
//        exposure_params = "?adPosId=5&parkId=010202007219736&partnerId=1462510737&openId=83305867&userMobile=1885577077&userLicense=京A01329&userIp=95.1.1.13&sign=MEUCIHmiRY9mcQs0IN+z088AOwkexPHCGzK3jIUYAczsHCJFAiEA25vvJP8aJitVoI7zH/2carKDaOjI4a/KCaIFDkrYjEo=";
//        exposure_json = "{\"adPosId\":\"5\",\"userLicense\":\"京A01329\",\"userMobile\":\"1885577077\",\"openId\":\"83305867\",\"sign\":\"MEUCIHmiRY9mcQs0IN+z088AOwkexPHCGzK3jIUYAczsHCJFAiEA25vvJP8aJitVoI7zH/2carKDaOjI4a/KCaIFDkrYjEo=\",\"userIp\":\"95.1.1.13\",\"partnerId\":\"1462510737\",\"parkId\":\"010202007219736\"}";
        try {
            responseData = doGet02(DataProduct.exposure_url + exposure_params,exposure_json);
        }catch (Exception e){
            System.out.println(e);
        }

        Map<String, Object> resultMap = JSON.parseObject(responseData, Map.class);
        if(resultMap.get( "status" ).equals( "20000000" )){
            String result = resultMap.get( "result" ).toString();
            Map<String, String> result_map = JSONObject.parseObject(result, new TypeReference<Map<String, String>>(){});
            String adId = result_map.get( "adId" ).toString();
            System.out.println("广告计划uuid - adId: " + adId);
            return  result_map;
        }else {
            System.out.println("曝光失败！");
            return null;
        }
    }
    //点击click
    public static void click(String url,String adId ,String park_Id ,String partnerId,String private_key) throws Exception{
        String openId =  randomNumeric(8);
        String userLicense = "川A" + randomNumeric(5);
        Map <String, String> clickMap = new HashMap <>();
        clickMap.put("adId", adId);
        clickMap.put("parkId", park_Id);
        clickMap.put("partnerId", partnerId);
        clickMap.put("userMobile", DataProduct.userMobile);
//        clickMap.put("userLicense", userLicense);
        clickMap.put("openId", openId);
        String click_sign = ECCSignUtil.sign(private_key, clickMap);
        clickMap.put("sign", click_sign);
        String click_json = JSONObject.toJSONString(clickMap);
//        System.out.println(click_json);
//        String click_params = "?" + "adId=" + adId + "&" + "partnerId=" + partnerId + "&" + "parkId=" + park_Id + "&" +"openId="+openId+ "&" + "userLicense=" + userLicense +"&" + "userMobile=" + userMobile +"&"+ "sign=" + click_sign;
        String click_params = "?" + "adId=" + adId + "&" + "partnerId=" + partnerId + "&" + "parkId=" + park_Id + "&" +"openId="+openId+ "&" + "userMobile=" + DataProduct.userMobile +"&"+ "sign=" + click_sign;
//        click_params = "?adId=47856525083975680&partnerId=1462510737&parkId=010202007219736&openId=24889746&userMobile=1885577077&sign=MEUCID0HY2OItpSJ+/P0Gg73YuprQRHaDWgfJWnolcrA23m+AiEAvwP0lUlxRfdWo/vH4LBMOyS+pVPOghxRWDYAWJT7/HA=";
        try {
            doGet02(url + click_params , click_json);
        }catch (Exception e){
            System.out.println(e);
        }

    }


}
