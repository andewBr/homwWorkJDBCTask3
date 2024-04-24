package by.javaguru;


import by.javaguru.dao.UserDaoImpl;
import by.javaguru.entity.Users;

public class JdbcRunner {



    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        Users users = new Users();
        users.setName("AndreyAndrew");
        users.setEmail("andreyBR@gmail.com");
        users.setPassword("fsdlkfjsdlkjf");

        System.out.println(userDao.read(1L));
    }

}
