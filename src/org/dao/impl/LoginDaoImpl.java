package org.dao.impl;

import org.dao.LoginDao;
import org.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDaoImpl implements LoginDao {
    @Override
    public boolean doLogin(String username, String password , int role) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JdbcUtils.getConnection();
            ps = con.prepareStatement("select count(*) from account where account = ? and password = ? and role = ? and state = 1");
            // 设置SQL的参数
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setInt(3, role);
            // 执行
            rs = ps.executeQuery();
            while (rs.next()) {
                int r = rs.getInt(1);
                if (r == 1) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(con, ps, rs);
        }
        return false;
    }
}
