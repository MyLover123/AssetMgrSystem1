package org.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * 数据库连接工具
 */
public class JdbcUtils {

    /**
     * 获取连接
     * @return 数据库连接
     */
    public static Connection getConnection() {
        try {

            //1.读取db.properties中的数据
            Properties pro = new Properties();
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
            pro.load(inputStream);

            String forname = pro.getProperty("forname");
            String url = pro.getProperty("url");
            String user = pro.getProperty("user");
            String password = pro.getProperty("password");

            // 2.加载驱动
            Class.forName(forname);
            // 3.连接数据库
            Connection con = DriverManager.getConnection(url,user,password);
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 关闭资源
     *
     * @param con 连接
     * @param ps  PreparedStatement
     */
    public static void close(Connection con, PreparedStatement ps) {
        close(con, ps, null);
    }

    /**
     * 关闭资源
     *
     * @param con 连接
     * @param ps  PreparedStatement
     * @param rs  ResultSet
     */
    public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
        // 6.关闭
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
