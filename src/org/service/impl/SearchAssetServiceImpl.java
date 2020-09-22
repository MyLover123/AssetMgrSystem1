package org.service.impl;

import org.dao.SearchAssetDao;
import org.dao.impl.SearchAssetDaoImpl;
import org.model.Asset;
import org.service.SearchAssetService;

import java.util.List;

public class SearchAssetServiceImpl implements SearchAssetService {
    @Override
    public List<Asset> getAsset(Integer id) {
        SearchAssetDao sd=new SearchAssetDaoImpl();
        return sd.getAsset(id);
    }
}
