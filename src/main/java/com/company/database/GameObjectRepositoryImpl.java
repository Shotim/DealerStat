package com.company.database;

import com.company.entity.gameObject.GameObject;
import com.company.mapper.GameObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class GameObjectRepositoryImpl implements GameObjectRepository {

    private static final String INSERT_NEW_GAMEOBJECT = "INSERT INTO gameobjects (game_id, title, text, status, created_at, updated_at) VALUES (?,?,?,?,?,?)";
    private static final String INSERT_GAMEOBJECT_TO_POST = "INSERT INTO post_gameobjects (post_id, gameobject_id) VALUES (?,?)";

    private static final String SELECT_ALL_GAMEOBJECTS = "SELECT * FROM gameobjects";
    private static final String SELECT_ALL_GAMEOBJECTS_FROM_POST_WITH_ID = "SELECT * FROM gameobjects WHERE id IN (SELECT gameobject_id FROM post_gameobjects WHERE post_id=?)";
    private static final String SELECT_ALL_GAMEOBJECTS_WITH_GAME_ID = "SELECT * FROM gameobjects WHERE game_id=?";
    private static final String SELECT_GAMEOBJECT_WITH_ID = "SELECT * FROM gameobjects WHERE id=?";

    private static final String DELETE_GAMEOBJECT_FROM_POST_WITH_ID = "DELETE FROM post_gameobjects WHERE post_id=? AND gameobject_id=?";
    

    public final JdbcTemplate jdbcTemplate;

    @Override
    public List<GameObject> getAllGameObjects() {
        return jdbcTemplate.query(SELECT_ALL_GAMEOBJECTS,
                new GameObjectMapper());
    }

    @Override
    public List<GameObject> getGameObjectsFromPost(int postId) {
        return jdbcTemplate.query(SELECT_ALL_GAMEOBJECTS_FROM_POST_WITH_ID,
                new GameObjectMapper(), postId);
    }

    @Override
    public List<GameObject> getGameObjectsOfGame(int gameId) {
        return jdbcTemplate.query(SELECT_ALL_GAMEOBJECTS_WITH_GAME_ID,
                new GameObjectMapper(), gameId);
    }

    @Override
    public GameObject getGameObject(int objectId) {
        return jdbcTemplate.queryForObject(SELECT_GAMEOBJECT_WITH_ID,
                new GameObjectMapper(), objectId);
    }

    @Override
    public void addGameObject(GameObject obj) {
        jdbcTemplate.update(INSERT_NEW_GAMEOBJECT, obj.getGameId(),
                obj.getTitle(), obj.getText(),
                obj.getStatus().toString(),
                obj.getCreatedAt(), obj.getUpdatedAt());
    }

    @Override
    public void addGameObjectToPost(int gameObjectId, int postId) {
        jdbcTemplate.update(INSERT_GAMEOBJECT_TO_POST, postId, gameObjectId);
    }

    @Override
    public void deleteGameObjectFromPost(int gameObjectId, int postId) {
        jdbcTemplate.update(DELETE_GAMEOBJECT_FROM_POST_WITH_ID, postId, gameObjectId);
    }
}
