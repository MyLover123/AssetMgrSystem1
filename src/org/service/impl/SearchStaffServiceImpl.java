package org.service.impl;

import org.dao.SearchStaffDao;
import org.dao.impl.SearchStaffDaoImpl;
import org.model.Staff;
import org.service.SearchStaffService;

import java.util.List;

public class SearchStaffServiceImpl implements SearchStaffService {
    @Override
    public List<Staff> getStaff(String account) {
        SearchStaffDao sd = new SearchStaffDaoImpl();
        return sd.getStaff(account);
    }
}
