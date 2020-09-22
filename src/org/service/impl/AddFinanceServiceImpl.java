package org.service.impl;

import org.dao.AddFinanceDao;
import org.dao.impl.AddFinanceDaoImpl;
import org.service.AddFinanceService;

public class AddFinanceServiceImpl implements AddFinanceService {
    @Override
    public boolean doAdd(Integer productId, String voucherId, String datetime, String account) {
        AddFinanceDao ad=new AddFinanceDaoImpl();
        return ad.doAdd(productId,voucherId,datetime,account);
    }
}
