package com.itacademy.dao;

import com.itacademy.dao.common.BaseDao;
import com.itacademy.entity.BaseEntity;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * @author i.sukach
 */
public abstract class BaseDaoTest<T extends BaseEntity> {

    protected abstract BaseDao<T> getDao();
    protected abstract T getModel();

    @Test
    public void testFindById() {
        T model = getModel();
        getDao().save(model);

        T entity = getDao().findOne(1L);
        assertNotNull(entity);

        getDao().delete(entity);
    }

    @Test
    public void testDelete() {
        T model = getModel();
        getDao().save(model);

        getDao().delete(model);

        T entity = getDao().findOne(1L);
        assertNull(entity);
    }
}
