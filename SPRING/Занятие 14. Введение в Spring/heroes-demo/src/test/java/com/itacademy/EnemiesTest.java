package com.itacademy;

import com.itacademy.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

/**
 * @author i.sukach
 */
public class EnemiesTest {


    private static SessionFactory SESSION_FACTORY;

    @BeforeClass
    public static void init() {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void testSaveEnemies() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        ArmoredEnemy armoredEnemy = new ArmoredEnemy();
        armoredEnemy.setArmorType(ArmorType.STEEL);
        armoredEnemy.setArmorDurability(100);
        armoredEnemy.setName("Bozo");
        session.save(armoredEnemy);

        RangedEnemy rangedEnemy = new RangedEnemy();
        rangedEnemy.setRangeOfFire(30);
        rangedEnemy.setWeaponType(WeaponType.BOW);
        rangedEnemy.setName("Archer");
        session.save(rangedEnemy);

        InvisibleEnemy invisibleEnemy = new InvisibleEnemy();
        invisibleEnemy.setInvisibilityDuration(10);
        invisibleEnemy.setName("Ghost");
        session.save(invisibleEnemy);

        transaction.commit();
        session.close();
    }

    @Test
    public void testAddWeapons() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Enemy enemy = session.get(Enemy.class, 1L);

        Weapon bow = new Weapon();
        bow.setName("Bow");
        bow.setEnemy(enemy);
        session.save(bow);

        Weapon sword = new Weapon();
        sword.setName("Sword");
        sword.setEnemy(enemy);
        session.save(sword);

        transaction.commit();
        session.close();
    }

    @Test
    public void testGetAllEnemies() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        List<Enemy> enemies = session
                .createQuery("from Enemy", Enemy.class)
                .getResultList();
        enemies.forEach(System.out::println);

        transaction.commit();
        session.close();
    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
