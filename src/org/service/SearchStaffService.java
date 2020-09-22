package org.service;

import org.model.Staff;

import java.util.List;

public interface SearchStaffService {
    List<Staff> getStaff(String account);
}
