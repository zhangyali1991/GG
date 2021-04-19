package com.qb.ad.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * 数据库操作
 */

public class MysqlDeal {
    static Connection connection = null;
    static Statement statement = null;
    static ResultSet rs = null;

    //查询单条记录，返回map，对应value通过get(key)方法获取
    public static Map<String, String> mysqlDeal(String sql, String[] keys) {

        try {
            connection = JdbcUtils.getConnection();
            statement = connection.createStatement();
//            String sql2 = "SELECT * FROM pos_terminal_info WHERE terminal_no ='" + sql + "'";
            System.out.println(sql);
            rs = statement.executeQuery(sql);
            if (rs.next()) {
                System.out.println("成功");

                //创建map
                Map<String, String> resMap = new HashMap();
                //遍历数组
                for (String key : keys) {
//                    System.out.println(key);
                    String value = rs.getString(key);
                    resMap.put(key, value);
                }
                return resMap;
            } else {
                System.out.println("失败！");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //JdbcUtils.close(connection, statement, rs);
        }
        return null;
    }

    //查询多条记录，返回数组
    public static String[] mysqlDeals(String sql, String key) {

        try {
            connection = JdbcUtils.getConnection();
            statement = connection.createStatement();
            System.out.println(sql);
            rs = statement.executeQuery(sql);
            String values = "";
            while (rs.next()) {//循环判断结果集是否存在下一行数据
                //ResultSet对象的getXxx()方法根据数据库的字段名称将数据取出来
                String value = rs.getString(key);
//                String password1 = rs.getString("password1");
                //打印取出来的第一条数据
                if (values.equals("")) {
                    values = value;
                } else {
                    values = values + "-" + value;
                }

            }
            System.out.println(values);
            return values.split("-");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //JdbcUtils.close(connection, statement, rs);
        }
        return null;
    }

    //返回单条数据
    public static String mysqlDealsString(String sql, String key) {

        try {
            connection = JdbcUtils.getConnection();
            statement = connection.createStatement();

            rs = statement.executeQuery(sql);
            String value="";
            while(rs.next()){
                 value = rs.getString(key);
            }

            return value;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //JdbcUtils.close(connection, statement, rs);
        }
        return null;
    }

    //sqll指定方法，无返回
    public static void mysqlExecute(String sql) {

        try {
            connection = JdbcUtils.getConnection();
            statement = connection.createStatement();
            System.out.println(sql);
//            rs = statement.executeQuery(sql);
//            System.out.println("返回结果: "+statement.executeUpdate( sql ));
            if (statement.executeUpdate(sql) == 1) {
                System.out.println("执行成功");
            } else {
                System.out.println("执行失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection, statement, rs);
        }
    }


    public static void main(String[] args) throws SQLException {
//        String[] str=new String[]{"id","terminal_no"};
//        System.out.println("sql:  "+ mysqlDeal("SELECT * FROM pos_terminal_info WHERE terminal_no ='00029394'",str));
//        mysqlDeal("SELECT * FROM pos_terminal_info WHERE terminal_no ='00029394'",str);
//        mysqlDeal("SELECT * FROM pos_terminal_info WHERE terminal_no ='00029394'");
//        int id  = rs.getInt("id");
//        System.out.print("ID: " + id);
//        String insert_sql = "INSERT INTO traffic_info (traffic_name,entity_type,type,client_type ,city_id ,parking_cnt ,parking_on_cnt ,contact_id,manager_name,operator_id,partner_id ,user_id,public_key ,private_key ,source ,comment ,status ,whitelisted,profit_share ,json_str,create_time ,update_time) VALUES ('', '1', '1', '0', '0', '0', '0', '90', 'my测试', '1', '', '89', '" + "dsdasdaa" + "' , '" + "adasdasd" +"' ," + " '内推', 'my测试', '3', '0', '0', '{}', NOW(), NOW())";
//        System.out.print("insert_sql: " + insert_sql);
//        mysqlExecute( insert_sql );

//        SimpleDateFormat formatter = new SimpleDateFormat("MMddHHmmss");
//        String current = formatter.format( new Date() );
//        String contactMobile ="188" + current.substring( 2,10 );
//        System.out.print("contactMobile: " + contactMobile);
        String[] str = new String[]{"serial_number", "traffic_id"};
        String sql = "SELECT parking_id from ad_location_strategy WHERE ad_id=(SELECT id from ad_info WHERE name='孵化拆分广告主001202007_45')";

        String strs[] = mysqlDeals(sql, "parking_id");
        System.out.println(strs.length);
//        int number = (int)(Math.random()*100);

        for (int tmp2 = 0; tmp2 < 100; tmp2++) {
//            System.out.println((int)(Math.random()*100)%(strs.length));

        }
    }
}

