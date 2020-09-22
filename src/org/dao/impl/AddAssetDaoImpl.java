package org.dao.impl;

import org.dao.AddAssetDao;
import org.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddAssetDaoImpl implements AddAssetDao {
    @Override
    public boolean doAdd(String productId, String name, String model, String unit, Integer num, Double price, String datetime) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JdbcUtils.getConnection();
            ps = con.prepareStatement("INSERT INTO product VALUES(null,?,?,?,?,?,?,?)");
            // 设置SQL的参数
            ps.setString(1, productId);
            ps.setString(2, name);
            ps.setString(3, model);
            ps.setString(4,unit);
            ps.setInt(5,num);
            ps.setDouble(6,price);
            ps.setString(7,datetime);
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
