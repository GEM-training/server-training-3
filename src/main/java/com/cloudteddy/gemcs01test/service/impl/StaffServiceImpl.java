package com.cloudteddy.gemcs01test.service.impl;

import com.cloudteddy.gemcs01test.dao.StaffDao;
import com.cloudteddy.gemcs01test.model.Staff;
import com.cloudteddy.gemcs01test.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by quanda on 27/01/2016.
 */
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffDao staffDao;

    @Override
    public void saveStaff(Staff staff) {
        staffDao.saveStaff(staff);
    }

    @Override
    public List<Staff> findAllStaff() {
        return staffDao.findAllStaffs();
    }

    @Override
    public Staff findStaffById(long id) {
        return staffDao.findStaffById(id);
    }

    @Override
    public void deleteStaff(long id) {
        staffDao.deleteStaffById(id);
    }

    @Override
    public void updateStaff(Staff staff) {
        staffDao.updateStaff(staff);
    }
}
