package org.service.impl;

import org.dao.ChangeStateDao;
import org.dao.impl.ChangeStateDaoImpl;
import org.service.ChangeStateService;

public class ChangeStateServiceImpl implements ChangeStateService {
    @Override
    public boolean changeState(Integer id) {
        ChangeStateDao cd=new ChangeStateDaoImpl();
        return cd.changeState(id);
    }
}
