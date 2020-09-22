package org.dao.impl;

import org.dao.ResetPasswordDao;
import org.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ResetPasswordDaoImpl implements ResetPasswordDao {
    @Override
    public boolean doReset(Integer id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JdbcUtils.getConnection();
            ps = con.prepareStatement("UPDATE account SET password='123456' where id=?");
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
