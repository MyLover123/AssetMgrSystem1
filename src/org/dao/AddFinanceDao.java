package org.dao;

public interface AddFinanceDao {
    boolean doAdd(Integer productId,String voucherId,String datetime,String account);
}
