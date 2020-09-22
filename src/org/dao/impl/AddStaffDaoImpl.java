package org.dao.impl;

import org.dao.AddStaffDao;
import org.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddStaffDaoImpl implements AddStaffDao {
    @Override
    public boolean doAdd(String name, Double year, String sex, String account, String password, String role) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JdbcUtils.getConnection();
            ps = con.prepareStatement("INSERT INTO account VALUES(null,?,?,?,?,?,?,1,null)");
            // 设置SQL的参数
            if(role.equals("财务员")){
                ps.setInt(1, 1);
            }else if(role.equals("普通员工")){
                ps.setInt(1, 2);
            }else if(role.equals("管理员")){
                ps.setInt(1, 3);
            }
            ps.setString(2, name);
            ps.setDouble(3, year);
            ps.setString(4,sex);
            ps.setString(5,account);
            ps.setString(6,password);
            // 执行
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(con, ps, rs);
        }
        return false;
    }
}
