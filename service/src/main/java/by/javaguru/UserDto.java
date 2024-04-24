package by.javaguru;

import by.javaguru.entity.Users;

import java.util.List;

public interface UserDto {
    Users create(Users user);
    Users read(Long id);
    List<Users> userList();
    Users update(Long id, Users user);
    Users delete(Long id);
}
