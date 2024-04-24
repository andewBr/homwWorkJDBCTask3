package by.javaguru.dao;

import by.javaguru.entity.Users;

import java.util.List;

public interface UserDao {
    Users create(Users user);
    Users read(Long id);
    List<Users> userList();
    Users update(Long id, Users user);
    Users delete(Long id);

}
