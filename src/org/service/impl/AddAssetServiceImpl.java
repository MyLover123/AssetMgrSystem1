package org.service.impl;

import org.dao.AddAssetDao;
import org.dao.impl.AddAssetDaoImpl;
import org.service.AddAssetService;

public class AddAssetServiceImpl implements AddAssetService {
    @Override
    public boolean doAdd(String productId, String name, String model, String unit, Integer num, Double price, String datetime) {
        AddAssetDao ad=new AddAssetDaoImpl();
        return ad.doAdd(productId,name,model,unit,num,price,datetime);
    }
}
