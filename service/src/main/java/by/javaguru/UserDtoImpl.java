package by.javaguru;

import by.javaguru.dao.UserDao;
import by.javaguru.dao.UserDaoImpl;
import by.javaguru.entity.Users;

import java.util.List;

public class UserDtoImpl implements UserDto {

    private UserDao userDao;

    public UserDtoImpl() {
        this.userDao = new UserDaoImpl();
    }

    @Override
    public Users create(Users user) {
        return userDao.create(user);
    }

    @Override
    public Users read(Long id) {
        return userDao.read(id);
    }

    @Override
    public List<Users> userList() {
        return userDao.userList();
    }

    @Override
    public Users update(Long id, Users user) {
        return userDao.update(id, user);
    }

    @Override
    public Users delete(Long id) {
        return userDao.delete(id);
    }
}
