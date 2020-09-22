package org.service;

public interface AddFinanceService {
    boolean doAdd(Integer productId,String voucherId,String datetime,String account);
}
