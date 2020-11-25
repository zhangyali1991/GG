package com.qb.ad.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试环境
 * 创建计划字段
 */
public class AdPlanDataTest {

    //随机数
    public static final SimpleDateFormat formatter = new SimpleDateFormat("MMddHHmmss");
    public static final String current = formatter.format( new Date() );
    public static final Long startTime = System.currentTimeMillis() - 30000;
    public static final Long endTime = startTime + 1000*3600*24*7;

    /** 广告主出价 */
    public static final String createAdvertiseName = "自动创建广告计划Auto" + current;
    public static final String[] advertiserId = new String[]{"385","385","385","385","385"};//337:01010  339:00101  342:11010  344:10010 362:10010
    public static final int[] industryId = new int[]{1,2,3,4,5};
    public static final String[] createAdvertisePlanName = new String[]{createAdvertiseName+"_1",createAdvertiseName+"_2",createAdvertiseName+"_3",createAdvertiseName+"_4",createAdvertiseName+"_5"};
    public static final String[] priceType  = new String[]{"0","1","1","0","0"};  //计费方式 0:千次曝光CPM 1：单次点击CPC
    public static final String[] price = new String[]{"2850","51200","8888800","666600","6553555"};   //出价 单位分
    public static final String[] target = new String[]{"0","0","0","0","0"};       //售卖量
    public static final String[] priceTotal = new String[]{"142","40","12000","120","13288"};

    /** 投放设置 */
    public static final String scheduleType = "1";  //0：独占 1：共享 2：填充 3:混合
    public static final String[] scheduleTypeName = new String[]{"独占","2","3","4","5"};
//    public static final String startTime = "0";
//    public static final String adsensePositionId = "0";
    public static final int[] cityIds = new int[]{21,3};
    public static final int[] trafficIds = new int[]{330};
    public static final int[] parkTypeIds = new int[]{2147483647,0};
    public static final int[] parkIds = new int[]{1075};

    public static final String[] scheduleIntervalCnt   = new String[]{"60","2000","300","4000","555"};   //频次：次数
    public static final int[] ceilingCntDaily = new int[]{0,0,0,0,0};                    //单日曝光上限
    public static final String[] scheduleIntervalHours = new String[]{"1","2","3","4","5"};              //频次：小时/天
    public static final String[] scheduleIntervalType  = new String[]{"0","1","0","1","0"};              //频次间隔类型 0:小时 1:天(自然日)

    //    public static final String endTime = "0";
    public static final String[] isSubstitution = new String[]{"0","0","0","0","0"};
    public static final String[] autoFill = new String[]{"0","0","0","0","0"};
    public static final int[] matchCondition = new int[]{0,0,0,0};

    /**上传素材 */
    public static final int[] mediaType = new int[]{0,1,1,3,2};
    //文案
    public static final String[] content = new String[]{
            "文案：独占-1入场", "文案：独占-2出场", "", "", ""
    };
    //图片
    public static final String[] imageUri = new String[]{"", "",
            "https://anbokeji.oss-cn-hangzhou.aliyuncs.com/images/20200610/305145845.jpg",
            "https://anbokeji.oss-cn-hangzhou.aliyuncs.com/images/20200610/233150047.jpg",
            "https://anbokeji.oss-cn-hangzhou.aliyuncs.com/images/20200610/351145032.jpg"
    };
    //url
    public static final String[] url = new String[]{
            "www.baidu.com",
            "www.sina.com.cn",
            "www.tencent.com",
            "www.tmall.com",
            "www.360.cn"
    };

    /**其他 */
    public static final String[] comment = new String[]{"备注1","备注2","备注3","备注4","备注5"};
    public static final boolean[] checkAllData = new boolean[]{false,false,false,false,false};
    public static final String[] isApi = new String[]{"","","0","0","0"};
    public static final int[] isRedirect = new int[]{0,0,0,0,0}; //独占才有
    public static final int[] publishTimeList = new int[]{}; //投放时段配置（三位数字，第一位0-7代表周日到周六，后两位01-48表示一天每30分钟一个时间段）
    public static final String[] timeLimit = new String[]{"0","0","0","0","0"};
    public static final String[] weight = new String[]{"1","1","1","1","1"};
    public static final String appId = "idausj8190w1u2jdjjdj";
    public static final int[] nullArray = new int[]{};
//    //独占 0
//    public static final String[] Indep_price      = new String[]{"2850","51200","8888800","666600","6553555"};   //出价 单位分
//    public static final String[] Indep_target     = new String[]{"5000","200","500","4000","7150"};      //售卖量
//    public static final String[] Indep_priceTotal = new String[]{"142","40","12000","120","13288"};      //预算总额 单位元 仅参考值
//    public static final String[] Indep_priceType  = new String[]{"0","1","1","0","0"};               //计费方式 0:千次曝光CPM 1：单次点击CPC
//
//    //共享 1
//    public static final String[] Share_price      = new String[]{"2850","2000","10000","3000","11555"};   //出价 单位分
//    public static final String[] Share_target     = new String[]{"0","0","0","0","0"};       //售卖量
//    public static final String[] ceilingCntDaily  = new String[]{"0","0","0","0","0"};       //单日上限，0无限制
//    public static final String[] Share_priceTotal = new String[]{"28","40","30000","1200","64130"};       //预算总额 单位元
//    public static final String[] Share_priceType  = new String[]{"1","1","0","1","0"};              //计费方式 0:千次曝光CPM 1：单次点击CPC
//    public static final String[] Share_scheduleIntervalCnt   = new String[]{"60","2000","300","4000","555"};   //频次：次数
//    public static final String[] Share_scheduleIntervalHours = new String[]{"1","2","3","4","5"};              //频次：小时/天
//    public static final String[] Share_scheduleIntervalType  = new String[]{"0","1","0","1","0"};   //频次间隔类型 0:小时 1:天(自然日)

}
