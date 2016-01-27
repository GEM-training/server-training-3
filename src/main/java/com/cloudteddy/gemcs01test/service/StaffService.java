package com.cloudteddy.gemcs01test.service;

import com.cloudteddy.gemcs01test.model.Staff;

import java.util.List;

/**
 * Created by quanda on 27/01/2016.
 */
public interface StaffService {

    void saveStaff(Staff staff);

    List<Staff> findAllStaff();

    Staff findStaffById(long id);

    void deleteStaff(long id);

    void updateStaff(Staff staff);

}
