package org.dao.impl;

import org.dao.SearchStaffDao;
import org.model.Staff;
import org.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SearchStaffDaoImpl implements SearchStaffDao {
    @Override
    public List<Staff> getStaff(String account) {
        List<Staff> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JdbcUtils.getConnection();
            ps = con.prepareStatement("select t1.id,t1.name,t1.year,t1.sex,t1.account,t1.password,t2.name,t1.state from account t1 inner join stafftype t2 ON t1.role = t2.id WHERE t1.account=?");
            // 设置SQL的参数
            ps.setString(1, account);
            // 执行
            rs = ps.executeQuery();
            while (rs.next()) {
                Staff staff = new Staff();
                staff.setId(rs.getInt(1));
                staff.setName(rs.getString(2));
                staff.setYear(rs.getDouble(3));
                staff.setSex(rs.getString(4));
                staff.setAccount(rs.getString(5));
                staff.setPassword(rs.getString(6));
                staff.setRole(rs.getString(7));
                staff.setState(rs.getString(8));
                if (staff.getState().equals("1")) {
                    staff.setState("解锁");
                } else {
                    staff.setState("锁定");
                }
                list.add(staff);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(con, ps, rs);
        }
        return list;
    }
}
