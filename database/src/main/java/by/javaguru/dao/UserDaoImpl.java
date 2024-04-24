package by.javaguru.dao;

import by.javaguru.entity.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static by.javaguru.util.ConnectionManager.openConnection;

// вопросы
//1) нужно ли Users обрабатывать через Optional
//2) как правильно называть методы CRUD при создании service
//3) где указывается слой UserDTO в service?

public class UserDaoImpl implements UserDao {

    private static final String CREATE_USER_SQL = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
    private static final String SELECT_USER_SQL = "SELECT id, name, email, password FROM users WHERE id = ?";
    private static final String SELECT_ALL_USERS_SQL = "select id, name, email, password FROM users";
    private static final String DELETE_USER_SQL = "DELETE FROM users WHERE id = ?";
    private static final String UPDATE_USER_SQL = "UPDATE users SET name = ?, email = ?, password = ? WHERE id = ?";

    @Override
    public Users create(Users userParam) {
        try (Connection connection = openConnection()) {
            PreparedStatement statement = connection.prepareStatement(CREATE_USER_SQL);
            statement.setString(1, userParam.getName());
            statement.setString(2, userParam.getEmail());
            statement.setString(3, userParam.getPassword());
            statement.executeUpdate();
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                return userSet(result);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Users read(Long id) {
        try (Connection connection = openConnection()) {
            PreparedStatement statement = connection.prepareStatement(SELECT_USER_SQL);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return userSet(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Users> userList() {
        List<Users> userList = new ArrayList<>();
        try (Connection connection = openConnection()) {
            Statement statement = connection.prepareStatement(SELECT_ALL_USERS_SQL);
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_USERS_SQL);
            if (resultSet.next()) {
                userList.add(userSet(resultSet));
            }
            return userList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Users update(Long id, Users user) {
        try (Connection connection = openConnection()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_USER_SQL);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setLong(4, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return userSet(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Users delete(Long id) {
        Users user = null;
        try (Connection connection = openConnection()) {
            PreparedStatement statement = connection.prepareStatement(DELETE_USER_SQL);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = userSet(resultSet);
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private Users userSet(ResultSet result) throws SQLException {
        return new Users(
                result.getString("name"),
                result.getString("email"),
                result.getString("password")
        );
    }
}
