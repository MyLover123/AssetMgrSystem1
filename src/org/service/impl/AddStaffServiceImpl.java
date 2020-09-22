package org.service.impl;

import org.dao.AddStaffDao;
import org.dao.impl.AddStaffDaoImpl;
import org.service.AddStaffService;

public class AddStaffServiceImpl implements AddStaffService {
    @Override
    public boolean doAdd(String name, Double year, String sex, String account, String password, String role) {
        AddStaffDao ad=new AddStaffDaoImpl();
        return ad.doAdd(name,year,sex,account,password,role);
    }
}
