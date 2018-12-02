package com.itacademy.dao.common;

import com.itacademy.entity.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author i.sukach
 */
public abstract class BaseDao<T extends BaseEntity> {

    private static SessionFactory SESSION_FACTORY =
            new Configuration().configure().buildSessionFactory();

    private Class<T> entityClass; //Class<Weapon> <-> Weapon.class

    public BaseDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T findOne(Long id) {
        Session session = SESSION_FACTORY.openSession();

        T result = session.get(entityClass, id);

        session.close();
        return result;
    }

    public void save(T entity) {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        session.save(entity);

        session.getTransaction().commit();
        session.close();
    }

    public void delete(T entity) {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        session.delete(entity);

        session.getTransaction().commit();
        session.close();
    }

//    protected abstract Class<T> getEntityClass();
}
