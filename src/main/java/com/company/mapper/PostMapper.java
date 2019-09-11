package com.company.mapper;

import com.company.entity.Post;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostMapper implements RowMapper<Post> {

    @Override
    public Post mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Post(resultSet.getInt("id"),
                resultSet.getInt("dealer_id"));
    }
}
