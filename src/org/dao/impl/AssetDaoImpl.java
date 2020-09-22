package org.dao.impl;

import org.dao.AssetDao;
import org.model.Asset;
import org.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AssetDaoImpl implements AssetDao {
    @Override
    public List<Asset> getAsset() {
        List<Asset> list = new ArrayList<>();

        Connection con = null;
        java.sql.PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JdbcUtils.getConnection();
            ps = con.prepareStatement("SELECT t1.*,t2.tid,t2.id,t2.state,t3.id,t3.voucherno,t3.datetime,t4.name FROM product t1 INNER JOIN asset t2 ON t1.id=t2.pid INNER JOIN finance t3 on t2.id=t3.aid INNER JOIN account t4 ON t3.uid=t4.id");
            rs = ps.executeQuery();

            while (rs.next()) {
                Asset asset = new Asset(rs.getInt(1),
                        rs.getInt(10),
                        rs.getString(2),
                        rs.getString(9),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getDouble(7),
                        rs.getString(8),
                        rs.getString(11),
                        rs.getInt(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15));
                if(asset.getTypeId().equals("1")){
                    asset.setTypeId("机械设备");
                }else if (asset.getTypeId().equals("2")){
                    asset.setTypeId("电子设备");
                }else{
                    asset.setTypeId("工程设备");
                }
                if(asset.getState().equals("1")){
                    asset.setState("空闲");
                }else{
                    asset.setState("使用中");
                }
                list.add(asset);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(con, ps, rs);
        }
        return list;
    }
}
