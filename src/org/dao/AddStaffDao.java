package org.dao;

public interface AddStaffDao {
    boolean doAdd(String name,Double year,String sex,String account,String password,String role);
}
