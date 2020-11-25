package com.qb.ad.web.user;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//@RunWith(Suite.class)                   //改变JUnit的默认执行类 
@RunWith(Suite.class)
//添加执行的testcase
@Suite.SuiteClasses({
	                //登录
		            Login.class,          //获取秘钥
//		            GetInfo.class,        //密码修改
//		            Logout.class,         //主管密码验证

	                 }) 

public class All_Trade_Test {

}

