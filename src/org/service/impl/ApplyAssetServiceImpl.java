package org.service.impl;

import org.dao.ApplyAssetDao;
import org.dao.impl.ApplyAssetDaoImpl;
import org.service.ApplyAssetService;

public class ApplyAssetServiceImpl implements ApplyAssetService {
    @Override
    public boolean doApply(Integer id, String account) {
        ApplyAssetDao ad=new ApplyAssetDaoImpl();
        return ad.doApply(id, account);
    }
}
