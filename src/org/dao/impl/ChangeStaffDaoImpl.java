package org.dao.impl;

import org.dao.ChangeStaffDao;
import org.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ChangeStaffDaoImpl implements ChangeStaffDao {
    @Override
    public boolean doChange(String name, String sex, String password, String account) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JdbcUtils.getConnection();

            ps = con.prepareStatement("UPDATE account SET name=?,sex=?,password=? where account=?");
            ps.setString(1, name);
            ps.setString(2, sex);
            ps.setString(3, password);
            ps.setString(4, account);
            ps.executeUpdate();
            return true;

        } catch (
                Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(con, ps, rs);
        }
        return false;
    }
}
