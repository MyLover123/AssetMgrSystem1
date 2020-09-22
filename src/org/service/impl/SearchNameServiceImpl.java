package org.service.impl;

import org.dao.SearchNameDao;
import org.dao.impl.SearchNameDaoImpl;
import org.service.SearchNameService;

public class SearchNameServiceImpl implements SearchNameService {
    @Override
    public String getName(String account) {
        SearchNameDao sd=new SearchNameDaoImpl();
        return sd.getName(account);
    }
}
