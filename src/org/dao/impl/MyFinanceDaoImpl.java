package org.dao.impl;

import org.dao.MyFinanceDao;
import org.model.Finance;
import org.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MyFinanceDaoImpl implements MyFinanceDao {
    @Override
    public List<Finance> getFinance(String account) {
        List<Finance> list = new ArrayList<>();

        Connection con = null;
        java.sql.PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JdbcUtils.getConnection();
            ps = con.prepareStatement("SELECT t1.id,t1.uid,t1.voucherno,t1.datetime,t2.name FROM finance t1 INNER JOIN account t2 on t1.uid=t2.id where account = ?");
            ps.setString(1, account);
            rs = ps.executeQuery();

            while (rs.next()) {
                Finance finance = new Finance(rs.getInt(1),rs.getString(3),rs.getString(4),rs.getString(5));
                list.add(finance);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(con, ps, rs);
        }
        return list;
    }
}
