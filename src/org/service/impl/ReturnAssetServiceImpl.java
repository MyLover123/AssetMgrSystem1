package org.service.impl;

import org.dao.ReturnAssetDao;
import org.dao.impl.ReturnAssetDaoImpl;
import org.service.ReturnAssetService;

public class ReturnAssetServiceImpl implements ReturnAssetService {
    @Override
    public boolean doReturn(Integer id) {
        ReturnAssetDao rd=new ReturnAssetDaoImpl();
        return rd.doReturn(id);
    }
}
