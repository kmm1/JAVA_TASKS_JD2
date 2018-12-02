package com.itacademy;

import com.itacademy.entity.ArmoredEnemy;
import com.itacademy.entity.Enemy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author i.sukach
 */
public class TransactionsTest {

    private static SessionFactory SESSION_FACTORY;

    @BeforeClass
    public static void init() {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void testTransactions() {
        Session originalSession = SESSION_FACTORY.openSession();
        Transaction originalTransaction = originalSession.beginTransaction();

        ArmoredEnemy originalEnemy = new ArmoredEnemy();
        originalEnemy.setName("OriginalName");
        originalSession.save(originalEnemy);

        originalTransaction.commit();
        originalSession.close();

        Session firstSession = SESSION_FACTORY.openSession();
        Transaction firstTransaction = firstSession.beginTransaction();

        Session secondSession = SESSION_FACTORY.openSession();
        Transaction secondTransaction = secondSession.beginTransaction();

        Enemy firstEnemy = firstSession.get(Enemy.class, 1L);
        Enemy secondEnemy = secondSession.get(Enemy.class, 1L);

        firstEnemy.setName("ChangedName");
        firstTransaction.commit();
        firstSession.close();

        secondEnemy.setName("ChangedSecondTimeName");
        secondTransaction.commit();
        secondSession.close();
    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
