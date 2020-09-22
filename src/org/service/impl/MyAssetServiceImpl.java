package org.service.impl;

import org.dao.MyAssetDao;
import org.dao.impl.MyAssetDaoImpl;
import org.model.MyAsset;
import org.service.MyAssetService;

import java.util.List;

public class MyAssetServiceImpl implements MyAssetService {
    @Override
    public List<MyAsset> getAsset(String account) {
        MyAssetDao md=new MyAssetDaoImpl();
        return md.getAsset(account);
    }
}
