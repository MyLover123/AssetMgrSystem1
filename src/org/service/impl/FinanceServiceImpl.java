package org.service.impl;

import org.dao.FinanceDao;
import org.dao.impl.FinanceDaoImpl;
import org.model.Finance;
import org.service.FinanceService;

import java.util.List;

public class FinanceServiceImpl implements FinanceService {
    @Override
    public List<Finance> getFinance() {
        FinanceDao fd=new FinanceDaoImpl();
        return fd.getFinance();
    }
}
