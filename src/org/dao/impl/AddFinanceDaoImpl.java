package org.dao.impl;

import org.dao.AddFinanceDao;
import org.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddFinanceDaoImpl implements AddFinanceDao {
    @Override
    public boolean doAdd(Integer productId, String voucherId, String datetime, String account) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JdbcUtils.getConnection();
            ps = con.prepareStatement("select id from account where account = ?");
            ps.setString(1, account);
            rs = ps.executeQuery();
            while (rs.next()) {
                int fid = rs.getInt(1);
                ps = con.prepareStatement("INSERT INTO asset VALUES(null,1,?,?,0,1)");
                ps.setInt(1, fid);
                ps.setInt(2, productId);
                ps.executeUpdate();

                ps = con.prepareStatement("select id from asset where pid=?");
                ps.setInt(1, productId);
                rs = ps.executeQuery();
                while(rs.next()){
                    int aid = rs.getInt(1);

                    ps = con.prepareStatement("INSERT INTO finance VALUES(null,?,?,?,?)");
                    ps.setInt(1,aid);
                    ps.setInt(2,fid);
                    ps.setString(3,voucherId);
                    ps.setString(4,datetime);
                    ps.executeUpdate();
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
