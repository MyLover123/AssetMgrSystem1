package org.service.impl;

import org.dao.DeleteStaffDao;
import org.dao.impl.DeleteStaffDaoImpl;
import org.service.DeleteStaffService;

public class DeleteStaffServiceImpl implements DeleteStaffService {
    @Override
    public boolean doDelete(Integer id) {
        DeleteStaffDao ds=new DeleteStaffDaoImpl();
        return ds.doDelete(id);
    }
}
