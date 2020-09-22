package org.service.impl;

import org.dao.MyFinanceDao;
import org.dao.impl.MyFinanceDaoImpl;
import org.model.Finance;
import org.service.MyFinanceService;

import java.util.List;

public class MyFinanceServiceImpl implements MyFinanceService {
    @Override
    public List<Finance> getFinance(String account) {
        MyFinanceDao md=new MyFinanceDaoImpl();
        return md.getFinance(account);
    }
}
