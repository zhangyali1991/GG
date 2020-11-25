package concurrency;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.github.houbb.junitperf.core.annotation.JunitPerfConfig;
import com.github.houbb.junitperf.core.report.impl.ConsoleReporter;
import com.github.houbb.junitperf.core.report.impl.HtmlReporter;
import com.qb.ad.jdbc.MysqlDeal;
import com.zzrb.util.ECCSignUtil;
import org.testng.annotations.Test;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import static com.qb.ad.entity.DataTest.url_open;
import static com.qb.ad.util.HttpGG.doGet02;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

/**
 * 多流量主、多车场、随机车场 获取广告---曝光和点击
 * 运行主函数 该方法未调整完
 */

public class OpenAndClick_perf {
    static String exposure_url = url_open +"/api/v1/advert";
    static String click_url = url_open +"/api/v1/advert/redirect/";

//    static String parking_name = "车场0530184756";                  //*****需要存在计划的车场名称*****
    static String ad_name = "孵化拆分广告主001202007_45";        //*****计划列表的计划名称*****
//    static String parking_Id = "车场0630112730";
    static String adPosId = "3";//1入场推送，2出场推送，3输入车牌 ，4支付页面，5付款成功  *****需要创建计划类型*****
    static int count = 1;
    static int open_cnt  = 1;
    static int click_cnt = 1;

    static String userMobile = "188" + randomNumeric(7);
    static String userLicense = "川A" + randomNumeric(5);
    static String openId =  randomNumeric(8);
    static String userIp = randomNumeric(2)+"."+randomNumeric(1)+"."+randomNumeric(1)+"."+ randomNumeric(2);



    @Test
    public static void openAndClick_perf(String parking_Id) throws Exception {
        //根据车场名parking_name查出partnerId和private_key
//        String select_sql_1 = "SELECT serial_number,traffic_id FROM parking_info WHERE id IN (SELECT parking_id from ad_location_strategy WHERE ad_id=(SELECT id from ad_info WHERE name='"+ ad_name +"'))";
//        String select_sql_1 = "SELECT serial_number,traffic_id FROM parking_info WHERE id=(SELECT parking_id from ad_location_strategy WHERE ad_id=(SELECT id from ad_info WHERE name='"+ ad_name +"') limit 1)";
        String select_sql_1 = "SELECT serial_number,traffic_id FROM parking_info WHERE id="+parking_Id;
//        System.out.println("sql: " + select_sql);
        String[] str_1=new String[]{"serial_number","traffic_id"};
        Map<String,String> selectMap_1 = MysqlDeal.mysqlDeal( select_sql_1 ,str_1);
        System.out.println("selectMap1: " + selectMap_1);
        String serial_number = selectMap_1.get( "serial_number" ).toString();
        String traffic_id = selectMap_1.get( "traffic_id" ).toString();
        String partnerId = serial_number.split( "-" )[0];
        String park_Id = serial_number.split( "-" )[1];
        System.out.println("park_Id: " + park_Id);

        String select_sql_2 = "SELECT private_key FROM traffic_info WHERE id = '"+ traffic_id +"'";
        String[] str_2 = new String[]{"private_key"};
        Map<String,String> selectMap_2 = MysqlDeal.mysqlDeal( select_sql_2 ,str_2);
        String private_key = selectMap_2.get( "private_key" ).toString();

        System.out.println("private_key: " + private_key);
        int click_count = click_cnt;
        try {
            for (int tmp1 = 0;tmp1 < open_cnt;tmp1++){
                String adId = exposure(park_Id , partnerId ,private_key);
//                String adId ="45459068138053632";
                if(click_count-- > 0 && adId != null){
                    click( adId ,park_Id , partnerId ,private_key);
                }
            }
        }catch (NullPointerException e){
            System.out.println("曝光失败，空指针异常！" );
        }catch (UnknownHostException e){
            System.out.println("曝光失败，域名无法访问！" );
        }
    }

    //曝光exposure
    public static String exposure(String park_Id ,String partnerId ,String private_key) throws Exception{
        String openId =  randomNumeric(8);
        String userLicense = "川A" + randomNumeric(5);
        String userIp = randomNumeric(2)+".1.1."+ randomNumeric(2);
        String responseData = "";
        Map <String, String> getAdvertMap = new HashMap <>();
        getAdvertMap.put("parkId", park_Id);
        getAdvertMap.put("partnerId", partnerId);
        getAdvertMap.put("adPosId", adPosId);
        getAdvertMap.put("userMobile", userMobile);
        getAdvertMap.put("openId", openId);
        getAdvertMap.put("userLicense", userLicense);
        getAdvertMap.put("userIp", userIp);
        String exposure_sign = ECCSignUtil.sign(private_key, getAdvertMap);
        getAdvertMap.put("sign", exposure_sign);
        String exposure_json = JSONObject.toJSONString(getAdvertMap);
        String exposure_params = "?" + "adPosId=" + adPosId + "&" + "parkId=" + park_Id + "&" + "partnerId=" + partnerId + "&"+ "openId="+openId + "&" + "userMobile=" + userMobile + "&" + "userLicense=" + userLicense + "&"+ "userIp=" + userIp + "&" + "sign=" + exposure_sign;
//        String exposure_params = "?" + "adPosId=" + adPosId + "&" + "parkId=" + park_Id + "&" + "partnerId=" + partnerId + "&" +"openId="+openId + "&" + "userMobile=" + userMobile + "&"+ "userIp=" + userIp + "sign=" + exposure_sign;
        try {
            responseData = doGet02(exposure_url + exposure_params,exposure_json);
        }catch (Exception e){
            System.out.println(e);
        }

        Map<String, Object> resultMap = JSON.parseObject(responseData, Map.class);
        if(resultMap.get( "status" ).equals( "20000000" )){
            String result = resultMap.get( "result" ).toString();
            Map<String, String> result_map = JSONObject.parseObject(result, new TypeReference<Map<String, String>>(){});
            String adId = result_map.get( "adId" ).toString();
            System.out.println("广告计划uuid - adId: " + adId);
            return  adId;
        }else {
            System.out.println("曝光失败！");
            return null;
        }
    }

    //点击click
    public static void click(String adId ,String park_Id ,String partnerId,String private_key) throws Exception{
        String openId =  randomNumeric(8);
        String userLicense = "川A" + randomNumeric(5);
        Map <String, String> clickMap = new HashMap <>();
        clickMap.put("adId", adId);
        clickMap.put("parkId", park_Id);
        clickMap.put("partnerId", partnerId);
        clickMap.put("userMobile", userMobile);
//        clickMap.put("userLicense", userLicense);
        clickMap.put("openId", openId);
        String click_sign = ECCSignUtil.sign(private_key, clickMap);
        clickMap.put("sign", click_sign);
        String click_json = JSONObject.toJSONString(clickMap);
//        System.out.println(click_json);
//        String click_params = "?" + "adId=" + adId + "&" + "partnerId=" + partnerId + "&" + "parkId=" + park_Id + "&" +"openId="+openId+ "&" + "userLicense=" + userLicense +"&" + "userMobile=" + userMobile +"&"+ "sign=" + click_sign;
        String click_params = "?" + "adId=" + adId + "&" + "partnerId=" + partnerId + "&" + "parkId=" + park_Id + "&" +"openId="+openId+ "&" + "userMobile=" + userMobile +"&"+ "sign=" + click_sign;
        try {
            doGet02(click_url + click_params , click_json);
        }catch (Exception e){
            System.out.println(e);
        }

    }


    public static void main(String[] args) throws Exception {

        String sql = "SELECT parking_id from ad_location_strategy WHERE ad_id=(SELECT id from ad_info WHERE name='孵化拆分广告主001202007_45')";
        String strs[] = MysqlDeal.mysqlDeals(sql,"parking_id");
        for (int tmp2 = 0;tmp2 < count;tmp2++){
            openAndClick_perf(strs[(int)(Math.random()*100)%(strs.length)]);
        }
    }


    @JunitPerfConfig(threads = 50, warmUp = 0_500, duration = 60_000
            , reporter = {HtmlReporter.class, ConsoleReporter.class})
    public void newStrTestStringBuilder() throws Exception {
        openAndClick_perf("923");
        openAndClick_perf("924");
        openAndClick_perf("925");
        openAndClick_perf("926");
        openAndClick_perf("927");
        openAndClick_perf("928");
    }

}



