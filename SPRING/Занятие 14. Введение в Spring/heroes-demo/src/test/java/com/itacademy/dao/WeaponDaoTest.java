package com.itacademy.dao;

import com.itacademy.dao.common.BaseDao;
import com.itacademy.entity.Weapon;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author i.sukach
 */
public class WeaponDaoTest extends BaseDaoTest<Weapon> {

    private BaseDao<Weapon> dao = new WeaponDao();

    @Override
    protected BaseDao<Weapon> getDao() {
        return dao;
    }

    @Override
    protected Weapon getModel() {
        return new Weapon();
    }
}
