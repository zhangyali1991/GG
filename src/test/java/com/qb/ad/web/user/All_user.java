package com.qb.ad.web.user;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//@RunWith(Suite.class)                   //改变JUnit的默认执行类 
@RunWith(Suite.class)
//添加执行的testcase
@Suite.SuiteClasses({
	                //登录
		            Login.class,          //登录
		            GetInfo.class,        //获取信息
		            Logout.class,         //登出

	                 }) 

public class All_user {

}

