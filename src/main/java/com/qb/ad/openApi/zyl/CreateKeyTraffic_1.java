package com.qb.ad.openApi.zyl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.qb.ad.jdbc.MysqlDeal;
import org.testng.annotations.Test;

import java.util.Map;

import static com.qb.ad.util.ApiUtilsTest.createAccount;
import static com.zzrb.ecc.AnboECCKey.generateKeyPair;

/**
 * 创建计划：生成密钥，插入密钥到数据库，生成流量主账户
 */
public class CreateKeyTraffic_1 {

    @Test
    public static void createKeyTraffic() throws Exception {
        //生成密钥串
        String getKey = generateKeyPair();
        System.out.println("getKey: " + getKey);
        Map<String, Object> keyMap = JSON.parseObject(getKey, Map.class);
//        System.out.println(keyMap);
        String priv_key = keyMap.get("priv_key").toString();
        String pub_key = keyMap.get("pub_key").toString();
//        System.out.println("priv_key:  "+keyMap.get( "priv_key" ).getClass());

        Map<String, String> priv_key_map = JSONObject.parseObject(priv_key, new TypeReference<Map<String, String>>() {
        });
        Map<String, String> pub_key_map = JSONObject.parseObject(pub_key, new TypeReference<Map<String, String>>() {
        });
        String priv_key_value = priv_key_map.get("value");
        String pub_key_value = pub_key_map.get("value");
        System.out.println("priv_key_value: " + priv_key_value);
        System.out.println("pub_key_value: " + pub_key_value);

        //插入密钥到数据库
        String insert_sql = "INSERT INTO traffic_info (traffic_name,entity_type,type,client_type ,city_id ,parking_cnt ,parking_on_cnt ,contact_id,manager_name,operator_id,partner_id ,user_id,public_key ,private_key ,source ,comment ,status ,whitelisted,profit_share ,json_str,create_time ,update_time) VALUES ('', '1', '1', '0', '0', '0', '0', '90', 'my测试', '1', '', '89', '" + pub_key_value + "' , '" + priv_key_value + "'," + " '内推', 'my测试', '3', '0', '0', '{}', NOW(), NOW())";
        System.out.print("insert_sql: " + insert_sql);
        MysqlDeal.mysqlExecute(insert_sql);

        //生成流量主账户
        createAccount(pub_key_value, priv_key_value);
    }

}


