package by.javaguru;

import by.javaguru.dao.UserDaoImpl;
import by.javaguru.entity.Users;

import java.util.Optional;

public class UserService {
    private final UserDaoImpl userDao = new UserDaoImpl();

    public Optional<Users> getUser(Long id) {
        return Optional.of(userDao.read(id));
    }
}
