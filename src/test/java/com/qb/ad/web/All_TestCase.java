package com.qb.ad.web;

import com.qb.ad.web.ad_manage.Ad_manage;
import com.qb.ad.web.advert.A_advertiser;
import com.qb.ad.web.finance.A_finance;
import com.qb.ad.web.report.A_report;
import com.qb.ad.web.traffic.A_traffic;
import com.qb.ad.web.user.All_user;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//@RunWith(Suite.class)                   //改变JUnit的默认执行类
@RunWith(Suite.class)
//添加执行的testcase
@Suite.SuiteClasses({
	                //运营管理后台
		All_user.class,
		A_traffic.class,
		Ad_manage.class,
		A_advertiser.class,
		A_finance.class,
		A_report.class,

})

public class All_TestCase {

}

