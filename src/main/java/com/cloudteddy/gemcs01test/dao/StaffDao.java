package com.cloudteddy.gemcs01test.dao;

import com.cloudteddy.gemcs01test.model.Promotion;
import com.cloudteddy.gemcs01test.model.Staff;

import java.util.List;

/**
 * Created by kimtung on 1/20/16.
 */
public interface StaffDao {

    void saveStaff(Staff staff);

    List<Staff> findAllStaffs();

    Staff findStaffById(long id);

    void deleteStaffById(long id);

    void updateStaff(Staff staff);

}
