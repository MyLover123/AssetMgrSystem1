package org.dao.impl;

import org.dao.ApplyAssetDao;
import org.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ApplyAssetDaoImpl implements ApplyAssetDao {
    @Override
    public boolean doApply(Integer id, String account) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JdbcUtils.getConnection();
            ps = con.prepareStatement("select id from account where account=?");
            ps.setString(1, account);
            rs = ps.executeQuery();
            while (rs.next()) {
                int uid = rs.getInt(1);
                ps = con.prepareStatement("UPDATE asset SET state=0,uid=? where id=?");
                ps.setInt(1, uid);
                ps.setInt(2, id);
                ps.executeUpdate();
                return true;
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(con, ps, rs);
        }
        return false;
    }
}
