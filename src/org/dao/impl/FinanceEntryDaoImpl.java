package org.dao.impl;

import org.dao.FinanceEntryDao;
import org.model.Product;
import org.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FinanceEntryDaoImpl implements FinanceEntryDao {
    @Override
    public List<Product> getProduct() {
        List<Product> list = new ArrayList<>();

        Connection con = null;
        java.sql.PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JdbcUtils.getConnection();
            ps = con.prepareStatement("SELECT t1.* FROM product t1 left JOIN asset t2 on t1.id=t2.pid WHERE t2.pid is null");
            rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getDouble(7),rs.getString(8));
                list.add(product);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(con, ps, rs);
        }
        return list;
    }
}
