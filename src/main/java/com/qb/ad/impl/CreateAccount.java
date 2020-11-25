package com.qb.ad.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.qb.ad.util.HttpGG;
import com.qb.ad.entity.DataTest;
import com.zzrb.util.ECCCryptUtil;
import com.zzrb.util.ECCSignUtil;

import java.util.HashMap;
import java.util.Map;

import static com.qb.ad.entity.BaseData.encrypt;
/**
 * 外放接口生成流量主方法
 */
public class CreateAccount {

    //生成流量主账户
    public static String createAccount(String public_key, String private_key) throws Exception {
        try {
            Map<String, String> createAccountMap = new HashMap<String, String>();
            createAccountMap.put( "name", DataTest.name );//用户名称
            createAccountMap.put( "regType", DataTest.regType );//注册类型
            createAccountMap.put( "cityId", DataTest.cityId );//所在城市
            createAccountMap.put( "accountType", DataTest.accountType );//客户类型? 0:车场; 1:媒介; 3:代理商
            createAccountMap.put( "contactName", DataTest.contactName );//联系人
            createAccountMap.put( "contactMobile", DataTest.contactMobile );//联系电话
            createAccountMap.put( "source", DataTest.source );//客户来源
            createAccountMap.put( "manager", DataTest.manager );//客户经理
            createAccountMap.put( "accountName", DataTest.accountName );//开户人名称
            createAccountMap.put( "bankName", DataTest.bankName );//银行名称
            createAccountMap.put( "accountNo", DataTest.accountNo );//银行名称
            createAccountMap.put( "password", ECCCryptUtil.encrypt( DataTest.password, encrypt ) );//登录密码
            createAccountMap.put( "publicKey", public_key );//公钥
            String createAccountSign = ECCSignUtil.sign( private_key, createAccountMap );
            System.out.println( "创建流量主sign ： " + createAccountSign );
            createAccountMap.put( "sign", createAccountSign );
            String json = JSONObject.toJSONString( createAccountMap );
//        System.out.println("json： " + json);
            String responseData = HttpGG.doPost( DataTest.create_account_url, json );
            System.out.println( "创建流量主名称name ： " + DataTest.name );
//        System.out.println("创建流量主resultresult ： " + result);

            Map<String, Object> resultMap = JSON.parseObject( responseData, Map.class );
            String result = resultMap.get( "result" ).toString();
            Map<String, String> result_map = JSONObject.parseObject( result, new TypeReference<Map<String, String>>() {
            } );
            String partnerId = result_map.get( "partnerId" );
            System.out.println( "创建流量主-partnerId ： " + partnerId );
            return partnerId;
        } catch (Exception e) {
            System.out.println( "创建流量主失败：" + e );
        }
        return null;
    }

}
