package org.dao.impl;

import org.dao.DeleteStaffDao;
import org.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeleteStaffDaoImpl implements DeleteStaffDao {
    @Override
    public boolean doDelete(Integer id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JdbcUtils.getConnection();
            ps = con.prepareStatement("DELETE FROM account where id=?");
            ps.setInt(1, id);
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
