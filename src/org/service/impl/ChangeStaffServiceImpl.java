package org.service.impl;


import org.dao.ChangeStaffDao;
import org.dao.impl.ChangeStaffDaoImpl;
import org.service.ChangeStaffService;

public class ChangeStaffServiceImpl implements ChangeStaffService {
    @Override
    public boolean doChange(String name, String sex, String password, String account) {
        ChangeStaffDao cd = new ChangeStaffDaoImpl();
        return cd.doChange(name, sex, password, account);
    }
}
