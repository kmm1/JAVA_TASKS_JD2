package com.itacademy.dao;

import com.itacademy.dao.common.BaseDao;
import com.itacademy.entity.ArmoredEnemy;
import com.itacademy.entity.Enemy;

/**
 * @author i.sukach
 */
public class EnemyDaoTest extends BaseDaoTest<Enemy> {
    private BaseDao<Enemy> dao = new EnemyDao();

    @Override
    protected BaseDao<Enemy> getDao() {
        return dao;
    }

    @Override
    protected Enemy getModel() {
        return new ArmoredEnemy();
    }
}
