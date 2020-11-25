package com.qb.ad.util;

import static com.qb.ad.impl.CreateFillAdPlan.createFillAdPlan;
import static com.qb.ad.impl.CreateIndependentAdPlan.createIndeAdPlan;
import static com.qb.ad.impl.CreateShareAdPlan.createShareAdPlan;

/**
 * 创建计划方法
 */
public class CreateAdvertisePlanTest {

    //创建计划
    public void createAdvertisePlan(String scheduleType) throws Exception {

        switch (scheduleType) {
            case "0": //独占
                createIndeAdPlan(1);
                createIndeAdPlan(2);
                createIndeAdPlan(3);
                createIndeAdPlan(4);
                createIndeAdPlan(5);
                break;
            case "1": //共享
                createShareAdPlan(1);
                createShareAdPlan(2);
                createShareAdPlan(3);
                createShareAdPlan(4);
                createShareAdPlan(5);
                break;
            case "2"://填充
//                createFillAdPlan(3,0);
//                createFillAdPlan(4,0);
//                createFillAdPlan(5,0);
                createFillAdPlan(3,1);
                createFillAdPlan(4,1);
                createFillAdPlan(5,1);
            default:
//        System.out.println("计划结果 ： " + );
        }
    }
}
