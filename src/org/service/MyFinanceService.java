package org.service;

import org.model.Finance;

import java.util.List;

public interface MyFinanceService {
    List<Finance> getFinance(String account);
}
