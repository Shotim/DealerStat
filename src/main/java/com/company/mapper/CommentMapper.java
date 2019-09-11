package com.company.mapper;

import com.company.entity.Comment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentMapper implements RowMapper<Comment> {

    @Override
    public Comment mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Comment(resultSet.getInt("id"),
                resultSet.getString("message"),
                resultSet.getInt("post_id"),
                resultSet.getInt("author_id"),
                resultSet.getDate("created_at"),
                resultSet.getBoolean("approved"));
    }
}
