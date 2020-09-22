package org.dao;

import org.model.Finance;

import java.util.List;

public interface MyFinanceDao {
    List<Finance> getFinance(String account);
}
