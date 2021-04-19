package com.qb.ad.jdbc;


import java.sql.*;
/**
 * JDBC驱动方法
 */
public class JdbcUtils {
    // 可以把几个字符串定义成常量：用户名，密码，URL，驱动类
    private static final String DRIVER = "com.mysql.jdbc.Driver";

//    private static final String URL = "jdbc:mysql://172.26.38.61:3306/ipos_trade";
//    private static final String USER = "mysqladmin";
//    private static final String PWD = "123465";
//    private static final String URL = "jdbc:mysql://47.100.168.251:3306/parkingads";
//    private static final String USER = "appuser";
//    private static final String PWD = "qianbao123";
//    private static final String URL = "jdbc:mysql://172.17.15.163:3306/adpost";
//    private static final String USER = "root";
//    private static final String PWD = "qianbao123";
    private static final String URL = "jdbc:mysql://172.17.15.161:3306/adpost";
    private static final String USER = "appuser";
    private static final String PWD = "qianbao123456";

//    private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; //8.0以上

    /**
     * 注册驱动(可以省略)
     */
    static {
        try {
            Class.forName(DRIVER); }
            catch (ClassNotFoundException e) { e.printStackTrace(); }
    }

    /**
     * 得到数据库的连接
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PWD);
    }

    /**
     * 关闭所有打开的资源
     */
    public static void close(Connection conn, Statement stmt){
        if(stmt != null) {
            try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
        if(conn != null) {
            try { conn.close(); }catch (SQLException e) { e.printStackTrace(); }
        }

    }

    /**
     * 关闭所有打开的资源 重载
     */
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        if(rs != null) {
            try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
        }

        close(conn, stmt);
    }
}