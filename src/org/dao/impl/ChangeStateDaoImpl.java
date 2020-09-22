package org.dao.impl;

import org.dao.ChangeStateDao;
import org.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ChangeStateDaoImpl implements ChangeStateDao {
    @Override
    public boolean changeState(Integer id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JdbcUtils.getConnection();
            ps = con.prepareStatement("select state from account where id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int state = rs.getInt(1);
                if (state == 1) {
                    ps = con.prepareStatement("UPDATE account SET state=0 where id=?");
                    ps.setInt(1, id);
                    ps.executeUpdate();
                    return true;
                } else {
                    ps = con.prepareStatement("UPDATE account SET state=1 where id=?");
                    ps.setInt(1, id);
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
