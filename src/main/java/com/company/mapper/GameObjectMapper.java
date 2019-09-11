package com.company.mapper;

import com.company.entity.GameObject;
import com.company.entity.GameObjectStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GameObjectMapper implements RowMapper<GameObject> {

    @Override
    public GameObject mapRow(ResultSet resultSet, int i) throws SQLException {
        return new GameObject(resultSet.getInt("id"),
                resultSet.getString("title"),
                resultSet.getString("text"),
                GameObjectStatus.valueOf(resultSet.getString("status")),
                resultSet.getDate("created_at"),
                resultSet.getDate("updated_at"),
                resultSet.getInt("game_id"));
    }
}
