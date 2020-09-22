package org.service.impl;

import org.dao.FinanceEntryDao;
import org.dao.impl.FinanceEntryDaoImpl;
import org.model.Product;
import org.service.FinanceEntryService;

import java.util.List;

public class FinanceEntryServiceImpl implements FinanceEntryService {
    @Override
    public List<Product> getProduct() {
        FinanceEntryDao fd=new FinanceEntryDaoImpl();
        return fd.getProduct();
    }
}
