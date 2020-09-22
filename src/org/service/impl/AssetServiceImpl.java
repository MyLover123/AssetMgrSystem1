package org.service.impl;

import org.dao.AssetDao;
import org.dao.impl.AssetDaoImpl;
import org.model.Asset;
import org.service.AssetService;

import java.util.List;

public class AssetServiceImpl implements AssetService {
    @Override
    public List<Asset> getAsset() {
        AssetDao assetDao = new AssetDaoImpl();
        return assetDao.getAsset();
    }
}
