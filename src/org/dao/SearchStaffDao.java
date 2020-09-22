package org.dao;

import org.model.Staff;

import java.util.List;

public interface SearchStaffDao {
    List<Staff> getStaff(String account);
}
