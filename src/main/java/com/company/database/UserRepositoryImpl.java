package com.company.database;

import com.company.entity.user.User;
import com.company.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private static final String INSERT_NEW_USER = "INSERT INTO users (first_name, last_name, password, email, created_at, role)VALUES (?,?,?,?,?,?)";
    private static final String SELECT_ALL_USERS = "SELECT * FROM users WHERE role='DEALER'";
    private static final String SELECT_USER_WITH_ID = "SELECT * FROM users WHERE id=?";
    private static final String SELECT_USER_WITH_EMAIL = "SELECT * FROM users WHERE email=?";
    private static final String DELETE_USER_WITH_ID = "DELETE FROM users WHERE id=?";
    private static final String EDIT_USER_WITH_ID = "UPDATE users SET first_name=?, last_name=?, password=?, email=? WHERE id=?";


    public final JdbcTemplate jdbcTemplate;

    @Override
    public List<User> getAllUsers() {
        return jdbcTemplate.query(SELECT_ALL_USERS,
                new UserMapper());
    }

    @Override
    public User getUser(int userId) {
        return jdbcTemplate.queryForObject(SELECT_USER_WITH_ID,
                new UserMapper(), userId);
    }

    @Override
    public User getUser(String email) {
        return jdbcTemplate.queryForObject(SELECT_USER_WITH_EMAIL,
                new UserMapper(), email);
    }

    @Override
    public void addUser(User user) {
        jdbcTemplate.update(INSERT_NEW_USER, user.getFirstName(),
                user.getLastName(), user.getPassword(),
                user.getEmail(), user.getCreatedAt(),
                user.getRole().toString());
    }

    @Override
    public void deleteUser(int userId) {
        jdbcTemplate.update(DELETE_USER_WITH_ID,
                userId);
    }

    @Override
    public void editUser(User user) {
        jdbcTemplate.update(EDIT_USER_WITH_ID, user.getFirstName(),
                user.getLastName(), user.getPassword(),
                user.getEmail(), user.getId());
    }
}
