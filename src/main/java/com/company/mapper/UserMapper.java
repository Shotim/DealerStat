package com.company.mapper;

import com.company.entity.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        return new User(resultSet.getInt("id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("password"),
                resultSet.getString("email"),
                resultSet.getDate("created_at"),
                Role.valueOf(resultSet.getString("role")));
    }
}
