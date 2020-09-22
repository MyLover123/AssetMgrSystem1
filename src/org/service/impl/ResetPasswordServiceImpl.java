package org.service.impl;

import org.dao.ResetPasswordDao;
import org.dao.impl.ResetPasswordDaoImpl;
import org.service.ResetPasswordService;

public class ResetPasswordServiceImpl implements ResetPasswordService {
    @Override
    public boolean doReset(Integer id) {
        ResetPasswordDao rd= new ResetPasswordDaoImpl();
        return rd.doReset(id);
    }
}
