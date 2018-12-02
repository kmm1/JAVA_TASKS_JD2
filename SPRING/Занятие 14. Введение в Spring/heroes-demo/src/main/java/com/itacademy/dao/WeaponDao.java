package com.itacademy.dao;

import com.itacademy.dao.common.BaseDao;
import com.itacademy.entity.Weapon;

/**
 * @author i.sukach
 */
public class WeaponDao extends BaseDao<Weapon> {
//    @Override
//    protected Class<Weapon> getEntityClass() {
//        return Weapon.class;
//    }
    public WeaponDao() {
        super(Weapon.class);
    }
}
