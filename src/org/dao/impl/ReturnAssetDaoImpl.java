package org.dao.impl;

import org.dao.ReturnAssetDao;
import org.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReturnAssetDaoImpl implements ReturnAssetDao {
    @Override
    public boolean doReturn(Integer id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JdbcUtils.getConnection();
            ps = con.prepareStatement("UPDATE asset SET uid=0,state=1 where id=?");
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
