package com.itacademy.dao;

import com.itacademy.dao.common.BaseDao;
import com.itacademy.entity.Enemy;

/**
 * @author i.sukach
 */
public class EnemyDao extends BaseDao<Enemy> {
    public EnemyDao() {
        super(Enemy.class);
    }
}
