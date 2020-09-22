package org.dao.impl;

import org.dao.MyAssetDao;
import org.model.MyAsset;
import org.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MyAssetDaoImpl implements MyAssetDao {
    @Override
    public List<MyAsset> getAsset(String account) {
        List<MyAsset> list = new ArrayList<>();

        Connection con = null;
        java.sql.PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JdbcUtils.getConnection();
            ps = con.prepareStatement("SELECT t1.*,t2.tid,t2.id FROM product t1 INNER JOIN asset t2 on t1.id=t2.pid INNER JOIN account t3 on t2.uid=t3.id where account = ?");
            ps.setString(1, account);
            rs = ps.executeQuery();

            while (rs.next()) {
                MyAsset myAsset = new MyAsset(rs.getInt(1),
                        rs.getInt(10),
                        rs.getString(2),
                        rs.getString(9),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getDouble(7),
                        rs.getString(8));
                if(myAsset.getTypeId().equals("1")){
                    myAsset.setTypeId("机械设备");
                }else if (myAsset.getTypeId().equals("2")){
                    myAsset.setTypeId("电子设备");
                }else{
                    myAsset.setTypeId("工程设备");
                }
                list.add(myAsset);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(con, ps, rs);
        }
        return list;
    }
}
