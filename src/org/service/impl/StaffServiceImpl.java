package org.service.impl;

import org.dao.StaffDao;
import org.dao.impl.StaffDaoImpl;
import org.model.Staff;
import org.service.StaffService;

import java.util.List;

public class StaffServiceImpl implements StaffService {
    @Override
    public List<Staff> getStaff() {
        StaffDao sd=new StaffDaoImpl();
        return sd.getStaff();
    }
}
