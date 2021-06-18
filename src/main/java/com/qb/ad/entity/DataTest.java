package com.qb.ad.entity;
import com.zzrb.enumm.CityIdEnum;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
/**
 * 测试数据
 */
public class DataTest {
    public static String Access_Token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImNyZWF0ZWQiOjE1OTc2MzAxMjgxMjYsImV4cCI6MTYyOTE2NjEyOH0.a_8zhFrPptI9hgYv5q2kX3QpsYI4Ipha2s0m6UkLhOlSW_d2x81NZ-EhZjnxrFxOyujgGurV8fS3IBJc0aG9uw";
    //    public static final String url_open = "http://118.178.56.187:8080";
//    public static final String url_open = "http://172.17.15.52:8080";
//    public static final String url_post = "http://172.17.15.51:9000";
      public static final String url_post = "http://api-inner-sit.anbokeji.net:8000";
      public static final String url_inner = "http://api-inner-sit.anbokeji.net:8000";
      public static final String url_open = "http://api-sit.anbokeji.net:8000";
      public static final String url_click = "http://ad-sit.anbokeji.net:8000";
    public static final String create_account_url = url_open + "/api/v1/account";
    public static final String park_url_1 = url_open +"/api/v1/park";
    public static final String park_url = url_open +"/api/v2/park";
    public static final String adPos_url_1 = url_open +"/api/v1/advert-pos";
    public static final String adPos_url_v1 = url_open +"/api/v1/advert-pos";
    public static final String adPos_url_v2= url_open +"/api/v2/advert-pos";
    public static final String adPos_url_v3= url_open +"/api/v3/advert-pos";
    public static final String exposure_url = url_open +"/api/v1/advert";
    public static final String exposure_sjxp_url = url_open +"/api/v1/advert/ticket";
    public static final String exposure_urlNew = url_open +"/api/v1/advert/list";
    public static final String exposure_url_scene = url_open +"/api/v1/grid-advert/list/";
    public static final String exposure_sjxp_scene = url_open +"/api/v1/grid-advert/ticket/";
    public static final String click_url = url_click +"/api/v1/advert/redirect/";
    public static final String click_url_scene = url_click +"/api/v1/grid-advert/redirect";
//    public static final String click_url_landing = url_click +"/api/v1/advert/landing/";
    public static final String click_url_up = url_click +"/api/v1/advert/click/";
    public static final String click_scene_up = url_click +"/api/v1/grid-advert/click/";
    public static final String profit_url = url_open +"/api/v1/park/profit/";
    public static final String login_url = url_post + "/api-user/user/login";
    public static final String traffic_update_url = url_post + "/api-post/traffic/update";
    public static final String traffic_share_url = url_post + "/api-post/traffic/share/update";
    public static final String plan_create_url = url_post + "/api-post/plan/create";
    public static final String payPlatformUrl = url_post + "/api/v1/grid/profit/platform";
    public static final String getPayProfitUrl = url_post + "/api/v1/grid/profit";

    //****场地场景相关新增url
    public static final String grid_url = url_open +"/api/v1/grid";//新增场地，更新场地，获取场地信息
    public static final String adPos_grid_url= url_open +"/api/v1/grid-pos";//开通广告页，获取广告页

    //随机数
    public static final SimpleDateFormat formatter = new SimpleDateFormat("MMddHHmmss");
    public static final String current = formatter.format( new Date() );
    public static final Long startTime = System.currentTimeMillis() - 30000;
    public static final Long endTime = startTime + 1000*3600*24*7;
    //流量主账户信息
    public static final String name = "ZYL流量主Auto" + current; //用户名称            *****不能重复*****
    public static final String contactMobile ="188" + current.substring( 2,10 ); //联系电话  *****不能重复*****
    public static final String regType = "1"; //注册类型
    public static final String cityId = CityIdEnum.BEIJING.getCode(); //所在城市
    public static final String accountType ="15"; //客户类型：15设备供应商30系统供应商45运营管理商60工程服务商75综合服务商90其他
    public static final String contactName ="风先生"; //联系人
    public static final String source ="商务谈判"; //客户来源
    public static final String manager ="张经理"; //客户经理
    public static final String address ="北京市朝阳区国门大厦D座4楼百联优力"; //详细地址
    public static final String mailbox ="123456@qq.com"; //电子邮箱
    public static final String accountName ="周小川"; //开户人名称
    public static final String bankName ="中国工商银行西安电子工业区支行中国工商银行西安电子工"; //银行名称
    public static final String accountNo ="00018877777776666"; //银行名称
    public static final String password ="88888888";

    //车场信息及广告位
    public static final String parkName = "ZYL场地Auto" + current; // 车场名称 *****不能重复*****
    public static final String gridId = "2021场地ID" + current; // 自定义场地id名称 *****不能重复*****

    public static final String updateparkName = "测试专用-更新停车场"+ current;
    public static final String parkCityId ="010"; //车场所在城市
//    static String cityId = "010";
    //    static String parkId = "022202004207050"; // 非必填，可自定义也可以系统自动生成
//    static String parkName = "";
    public static final String adPosIds = "1#2#3#4#5";//1#2#3#4#5  1入场推送，2出场推送，3输入车牌 ，4支付页面，5付款成功

    //创建计划广告名
    public static final String createAdvertiseName = "孵化拆分广告主Auto" + current;
    public static final String advertiserId = "385"; //337:01010  339:00101  342:11010  344:10010 362:10010
    public static final String scheduleType = "0";  //0：独占 1：共享  2:混合
//    public static final String ad_name = "testzx200602广告主202006_02";        //*****计划列表的计划名称*****
//    public static final String adPosId = "5";//1入场推送，2出场推送，3输入车牌 ，4支付页面，5付款成功  *****需要创建计划类型*****
//    public static int[] open_cnt  = {300,120,320,200,504};
//    public static int[] click_cnt = {268,88,268,120,382};
//    public static int[] open_cnt  = {1230,1230,3230,1500,12230};
//    public static int[] click_cnt = {670,770,870,870,870};
    public static int[] open_cnt  = {1,1,1,1,1};
    public static int[] click_cnt = {1,1,1,1,1};
    //创建广告计划数据设置

    public static final String imageUri_3 = "https://anbokeji.oss-cn-hangzhou.aliyuncs.com/images/20200610/305145845.jpg";
    public static final String imageUri_4 = "https://anbokeji.oss-cn-hangzhou.aliyuncs.com/images/20200610/233150047.jpg";
    public static final String imageUri_5 = "https://anbokeji.oss-cn-hangzhou.aliyuncs.com/images/20200610/351145032.jpg";

    //独占 0
    public static final String[] Indep_price      = new String[]{"2850","51200","8888800","666600","6553555"};   //出价 单位分
    public static final String[] Indep_target     = new String[]{"5000","200","500","4000","7150"};      //售卖量
    public static final String[] Indep_priceTotal = new String[]{"142","40","12000","120","13288"};      //预算总额 单位元 仅参考值
    public static final String[] Indep_priceType  = new String[]{"0","1","1","0","0"};               //计费方式 0:千次曝光CPM 1：单次点击CPC

    //共享 1
    public static final String[] Share_price      = new String[]{"2850","2000","10000","3000","11555"};   //出价 单位分
    public static final String[] Share_target     = new String[]{"0","0","0","0","0"};       //售卖量
    public static final String[] ceilingCntDaily  = new String[]{"0","0","0","0","0"};       //单日上限，0无限制
    public static final String[] Share_priceTotal = new String[]{"28","40","30000","1200","64130"};       //预算总额 单位元
    public static final String[] Share_priceType  = new String[]{"1","1","0","1","0"};              //计费方式 0:千次曝光CPM 1：单次点击CPC
    public static final String[] Share_scheduleIntervalCnt   = new String[]{"60","2000","300","4000","555"};   //频次：次数
    public static final String[] Share_scheduleIntervalHours = new String[]{"1","2","3","4","5"};              //频次：小时/天
    public static final String[] Share_scheduleIntervalType  = new String[]{"0","1","0","1","0"};   //频次间隔类型 0:小时 1:天(自然日)

    //url
    public static final String[] url = new String[]{
            "www.baidu.com",
            "www.sina.com.cn",
            "www.tencent.com",
            "www.tmall.com",
            "www.360.cn"
    };

    public static final String userMobile = "188" + randomNumeric(7);
    public static final String userLicense = "川A" + randomNumeric(5);
//  public static final String userLicense = "京A66666" ;
    public static final String openId =  randomNumeric(8);
//  public static final String openId =  "99999999";
}
