package com.qb.ad.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 数据库操作测试
 */
public class Test {
    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        System.out.println("请输入终端号>> ");
//        String name = input.nextLine();
//        sit("00029394");

    }

    public static void test(String terminalNo) {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = JdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql = "SELECT * FROM pos_terminal_info WHERE terminal_no ='" + terminalNo + "'";
            System.out.println(sql);
            rs = statement.executeQuery(sql);
            if(rs.next()) {
                System.out.println("成功");
                int id  = rs.getInt("id");
                // 输出数据
                System.out.print("ID: " + id);
            } else {
                System.out.println("失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection, statement, rs);
        }
    }
}