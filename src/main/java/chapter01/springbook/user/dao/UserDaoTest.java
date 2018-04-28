package chapter01.springbook.user.dao;

import chapter01.springbook.user.domain.User;
import org.junit.jupiter.api.Assertions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserDaoTest {
    @Test
    public void addAndGet() throws SQLException, ClassNotFoundException {
        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
        UserDao dao = context.getBean("userDao", UserDao.class);
        User user1 = new User("gyumee", "박성철", "springno1");
        User user2 = new User("leegw70", "이길원", "springno2");

        dao.deleteAll();
        assertEquals(0, dao.getCount());

        dao.add(user1);
        dao.add(user2);
        assertEquals(2, dao.getCount());

        User userget1 = dao.get(user1.getId());
        assertEquals(user1.getName(), userget1.getName());
        assertEquals(user1.getPassword(), userget1.getPassword());

        User userget2 = dao.get(user2.getId());
        assertEquals(user2.getName(), userget2.getName());
        assertEquals(user2.getPassword(), userget2.getPassword());

    }

    @Test
    public void count() throws SQLException, ClassNotFoundException {
        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");

        UserDao dao = context.getBean("userDao", UserDao.class);
        User user1 = new User("gyumee","박성철","spring01");
        User user2 = new User("naramp3","유상욱","spring02");
        User user3 = new User("naramp4","유상욱2","spring03");

        dao.deleteAll();
        assertEquals(0, dao.getCount());
        dao.add(user1);
        assertEquals(1, dao.getCount());
        dao.add(user2);
        assertEquals(2, dao.getCount());
        dao.add(user3);
        assertEquals(3, dao.getCount());

    }

    @Test
    public void getUserFailure(){
        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
            ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
            UserDao dao = context.getBean("userDao", UserDao.class);
            dao.deleteAll();
            assertEquals(0, dao.getCount());
            dao.get("unkown_id");
        });


    }



}
