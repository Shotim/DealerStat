package com.company.database;

import com.company.entity.*;
import com.company.mapper.*;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class DataBaseServiceImpl implements DataBaseService {

    private static final String INSERT_NEW_COMMENT = "INSERT INTO comments (author_id,message,post_id,created_at,approved) VALUES(?,?,?,?,?) ";
    private static final String INSERT_NEW_USER = "INSERT INTO users (first_name, last_name, password, email, created_at, role)VALUES (?,?,?,?,?,?)";
    private static final String INSERT_NEW_GAMEOBJECT = "INSERT INTO gameobjects (game_id, title, text, status, created_at, updated_at) VALUES (?,?,?,?,?,?)";
    private static final String INSERT_NEW_GAME = "INSERT INTO games (name)VALUES (?)";
    private static final String INSERT_NEW_POST = "INSERT INTO posts (dealer_id) VALUES(?)";
    private static final String INSERT_GAMEOBJECT_TO_POST = "INSERT INTO post_gameobjects (post_id, gameobject_id) VALUES (?,?)";

    public static final String SELECT_ALL_USERS = "SELECT * FROM users";
    public static final String SELECT_ALL_GAMEOBJECTS = "SELECT * FROM gameobjects";
    public static final String SELECT_ALL_GAMES = "SELECT * FROM games";
    public static final String SELECT_ALL_POSTS = "SELECT * FROM posts";


    public static final String SELECT_COMMENTS_WITH_POST_ID = "SELECT * FROM comments WHERE post_id=";
    public static final String SELECT_COMMENT_WITH_ID = "SELECT * FROM comments WHERE id=";
    public static final String SELECT_ALL_GAMEOBJECTS_FROM_POST_WITH_ID = "SELECT * FROM gameobjects NATURAL JOIN post_gameobjects as pg WHERE pg.post_id=";
    public static final String SELECT_ALL_GAMEOBJECTS_WITH_GAME_ID = "SELECT * FROM gameobjects WHERE game_id=";
    public static final String SELECT_GAMEOBJECT_WITH_ID = "SELECT * FROM gameobjects WHERE id=";
    public static final String SELECT_USER_WITH_ID = "SELECT * FROM users WHERE id=";
    public static final String SELECT_GAME_WITH_ID = "SELECT * FROM games WHERE id=";
    public static final String SELECT_ALL_POSTS_WITH_DEALER_ID = "SELECT * FROM posts WHERE dealer_id=";
    public static final String SELECT_POST_WITH_ID = "SELECT * FROM posts WHERE id=";

    public final JdbcTemplate jdbcTemplate;

    @Override
    public List<Comment> getComments(String SQLCommand) {
        return jdbcTemplate.query(SQLCommand, new CommentMapper());
    }

    @Override
    public List<User> getUsers(String SQLCommand) {
        return jdbcTemplate.query(SQLCommand, new UserMapper());
    }

    @Override
    public List<GameObject> getGameObjects(String SQLCommand) {
        return jdbcTemplate.query(SQLCommand, new GameObjectMapper());
    }

    @Override
    public List<Game> getGames(String SQLCommand) {
        return jdbcTemplate.query(SQLCommand, new GameMapper());
    }

    @Override
    public List<Post> getPosts(String SQLCommand) {
        return jdbcTemplate.query(SQLCommand, new PostMapper());
    }

    @Override
    public void addComment(Comment comment) {
        jdbcTemplate.update(INSERT_NEW_COMMENT, comment.getAuthorId(), comment.getMessage(), comment.getPostId(), comment.getCreatedAt(), comment.getApproved());
    }

    @Override
    public void addUser(User user) {
        jdbcTemplate.update(INSERT_NEW_USER, user.getFirstName(), user.getLastName(), user.getPassword(), user.getEmail(), user.getCreatedAt(), user.getRole().toString());
    }

    @Override
    public void addGameObject(GameObject obj) {
        jdbcTemplate.update(INSERT_NEW_GAMEOBJECT, obj.getGameId(), obj.getTitle(), obj.getText(), obj.getStatus().toString(), obj.getCreatedAt(), obj.getUpdatedAt());
    }

    @Override
    public void addGame(Game game) {
        jdbcTemplate.update(INSERT_NEW_GAME, game.getName());
    }

    @Override
    public void addPost(Post post) {
        jdbcTemplate.update(INSERT_NEW_POST, post.getDealerId());
    }

    @Override
    public void addGameObjectToPost(int gameObjectId, int postId) {
        jdbcTemplate.update(INSERT_GAMEOBJECT_TO_POST, postId, gameObjectId);
    }
}
