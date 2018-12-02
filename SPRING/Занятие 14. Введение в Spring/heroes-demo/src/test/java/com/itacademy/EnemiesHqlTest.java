package com.itacademy;

import com.itacademy.dto.EnemyNumbersDto;
import com.itacademy.entity.Enemy;
import com.itacademy.entity.Weapon;
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
public class EnemiesHqlTest {

    private static SessionFactory SESSION_FACTORY;

    @BeforeClass
    public static void init() {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void test() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        List<Object[]> enemies = session
                .createQuery("select name, count(e.name) from Enemy e group by e.name", Object[].class)
                .getResultList();
//        enemies.forEach(a -> System.out.println(a[0] + ": " + a[1]));
        enemies.forEach(System.out::println);

        transaction.commit();
        session.close();
    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
