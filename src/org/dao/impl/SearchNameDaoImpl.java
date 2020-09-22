package org.dao.impl;

import org.dao.SearchNameDao;
import org.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchNameDaoImpl implements SearchNameDao {
    @Override
    public String getName(String account) {
        String name=null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JdbcUtils.getConnection();
            ps = con.prepareStatement("select name from account WHERE account=?");
            // 设置SQL的参数
            ps.setString(1, account);
            // 执行
            rs = ps.executeQuery();
            while (rs.next()){
                name=rs.getString(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(con, ps, rs);
        }
        return name;
    }
}
