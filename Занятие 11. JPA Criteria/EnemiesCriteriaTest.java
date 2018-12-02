package com.itacademy;

import com.itacademy.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by Admin on 07.06.2017.
 */
public class EnemiesCriteriaTest {

    private static SessionFactory SESSION_FACTORY;

    @BeforeClass
    public static void init() {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void testGetAllWeapons() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Weapon> criteria = cb.createQuery(Weapon.class);
        criteria.select(criteria.from(Weapon.class));
        session.createQuery(criteria).getResultList();

        transaction.commit();
        session.close();
    }

    @Test
    public void testGetWeaponByName() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Weapon> criteria = cb.createQuery(Weapon.class);

        Root<Weapon> weapon = criteria.from(Weapon.class);
        Path<String> weaponName = weapon.get(Weapon_.name);
        criteria.select(weapon).where(cb.equal(weaponName, "Bow"));

        session.createQuery(criteria).getResultList();

        transaction.commit();
        session.close();
    }

    /**
     * select e from Weapon w join w.enemy e where w.name=:weaponName
     */
    @Test
    public void testJoin() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Enemy> criteria = cb.createQuery(Enemy.class);

        Root<Weapon> w = criteria.from(Weapon.class);
        Join<Weapon, Enemy> e = w.join(Weapon_.enemy);
        Path<String> weaponName = w.get(Weapon_.name);
        criteria.select(e)
                .where(cb.equal(weaponName, "Bow"));

        session.createQuery(criteria).getResultList();

        transaction.commit();
        session.close();
    }

    @Test
    public void testGrouping() {
        // select name, count(e.name) from Enemy e group by e.name order by e.name asc
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteria = cb.createQuery(Object[].class);

        Root<Enemy> e = criteria.from(Enemy.class);
        Path<String> enemyName = e.get(Enemy_.name);
        criteria.multiselect(enemyName, cb.count(enemyName))
                .groupBy(enemyName)
                .orderBy(cb.asc(enemyName));

        session.createQuery(criteria).getResultList();

        transaction.commit();
        session.close();
    }

    @Test
    public void testSubselect() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteria = cb.createQuery(Object[].class);
        Root<Enemy> mainRoot = criteria.from(Enemy.class);

        Subquery<String> subquery = criteria.subquery(String.class);
        Root<Weapon> subqueryRoot = subquery.from(Weapon.class);
        subquery.select(subqueryRoot.get(Weapon_.name));

        Path<String> enemyName = mainRoot.get(Enemy_.name);
        criteria.multiselect(mainRoot, enemyName)
                .where(cb.equal(enemyName, subquery));

        transaction.commit();
        session.close();
    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
