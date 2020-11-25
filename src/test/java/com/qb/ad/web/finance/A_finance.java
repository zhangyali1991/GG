package com.qb.ad.web.finance;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//@RunWith(Suite.class)                   //改变JUnit的默认执行类
@RunWith(Suite.class)
//添加执行的testcase
@Suite.SuiteClasses({
	                //财务管理
		            RecordList.class,    //提现记录列表？？
		            ReviewList.class,    //提现审核列表
		            ProfitList.class,    //平台收益列表
		            FinanceStatic.class,    //提现固定数据
		            ReviewUpdate.class,    //提现审核，审核操作
		            ExportWithdraOrderListAdmin.class,    //导出提现审核
		            ExportWithdraOrderSumListAdmin.class,    //导出提现记录
		            ExportWithdraOrderSumListDetailAdmin.class,    //导出查看记录
		            ProfitExport.class,    //导出平台收益

})

public class A_finance {

}

