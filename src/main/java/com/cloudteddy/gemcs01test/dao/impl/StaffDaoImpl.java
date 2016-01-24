package com.cloudteddy.gemcs01test.dao.impl;

import com.cloudteddy.gemcs01test.dao.AbstractDao;
import com.cloudteddy.gemcs01test.dao.PromotionDao;
import com.cloudteddy.gemcs01test.dao.StaffDao;
import com.cloudteddy.gemcs01test.model.Bill;
import com.cloudteddy.gemcs01test.model.Promotion;
import com.cloudteddy.gemcs01test.model.Staff;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kimtung on 1/20/16.
 */
@Repository("staff")
public class StaffDaoImpl extends AbstractDao implements StaffDao {
    @Override
    public void saveStaff(Staff staff) {
        persist(staff);
    }

    @Override
    public List<Staff> findAllStaffs() {
        Criteria criteria = getSession().createCriteria(Staff.class);
        return criteria.list();
    }

    @Override
    public Staff findStaffById(long id) {
        Criteria criteria = getSession().createCriteria(Staff.class);
        criteria.add(Restrictions.eq("id", id));
        return (Staff) criteria.uniqueResult();
    }

    @Override
    public void deleteStaff(long id) {
        Query deleteQuery  = getSession().createSQLQuery("DELETE FROM staff where staff_id = :id");
        deleteQuery.setLong("id", id);
        deleteQuery.executeUpdate();
    }

    @Override
    public void updateStaff(Staff staff) {
        getSession().update(staff);
    }
}