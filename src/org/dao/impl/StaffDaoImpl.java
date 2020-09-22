package org.dao.impl;

import org.dao.StaffDao;
import org.model.Staff;
import org.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StaffDaoImpl implements StaffDao {
    @Override
    public List<Staff> getStaff() {
        List<Staff> list = new ArrayList<>();

        Connection con = null;
        java.sql.PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JdbcUtils.getConnection();
            ps = con.prepareStatement("SELECT * FROM account;");
            rs = ps.executeQuery();

            while (rs.next()) {
                Staff staff = new Staff(rs.getInt(1),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(2),
                        rs.getString(8));
                if(staff.getRole().equals("1")){
                    staff.setRole("财务员");
                }else if (staff.getRole().equals("2")){
                    staff.setRole("普通员工");
                }else{
                    staff.setRole("管理员");
                }
                if(staff.getState().equals("1")){
                    staff.setState("解锁");
                }else{
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
