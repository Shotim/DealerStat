package com.company.database;

import com.company.entity.*;
import com.company.mapper.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Repository
public class DataBaseServiceImpl implements DataBaseService {

    private static final String INSERT_NEW_COMMENT = "INSERT INTO comments (author_id,message,post_id,created_at,approved) VALUES(?,?,?,?,?) ";
    private static final String INSERT_NEW_USER = "INSERT INTO users (first_name, last_name, password, email, created_at, role)VALUES (?,?,?,?,?,?)";
    private static final String INSERT_NEW_GAMEOBJECT = "INSERT INTO gameobjects (game_id, title, text, status, created_at, updated_at) VALUES (?,?,?,?,?,?)";
    private static final String INSERT_NEW_GAME = "INSERT INTO games (name)VALUES (?)";
    private static final String INSERT_NEW_POST = "INSERT INTO posts (dealer_id) VALUES(?)";

    public static final String SELECT_ALL_USERS = "SELECT * FROM users";
    public static final String SELECT_ALL_COMMENTS = "SELECT * FROM comments";
    public static final String SELECT_ALL_GAMEOBJECTS = "SELECT * FROM gameobjects";
    public static final String SELECT_ALL_GAMES = "SELECT * FROM games";
    public static final String SELECT_ALL_POSTS = "SELECT * FROM posts";

    private static final String DELETE_ALL = "";
    public static final String SELECT_ALL_COMMENTS_WITH_USER_ID = "SELECT * FROM comments WHERE author_id=";
    public static final String SELECT_COMMENT_WITH_ID = "SELECT * FROM comments WHERE id=";
    public static final String SELECT_USER_WITH_ID = "SELECT * FROM users WHERE id=";
    public static final String SELECT_ALL_GAMEOBJECTS_WITH_POST_ID = "SELECT * FROM users WHERE post_id=";
    public static final String SELECT_ALL_GAMES_WITH_ID = "SELECT * FROM users WHERE id=";
    public static final String SELECT_ALL_POSTS_WITH_DEALER_ID = "SELECT * FROM posts WHERE dealer_id=";


    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public DataBaseServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Comment> getComments(String SQLCommand) throws SQLException {
        return jdbcTemplate.query(SQLCommand, new CommentMapper());
    }
    @Override
    public List<User> getUsers(String SQLCommand) throws SQLException {
        return jdbcTemplate.query(SQLCommand, new UserMapper());
    }
    @Override
    public List<GameObject> getGameObjects(String SQLCommand) throws SQLException {
        return jdbcTemplate.query(SQLCommand, new GameObjectMapper());
    }
    @Override
    public List<Game> getGames(String SQLCommand) throws SQLException {
        return jdbcTemplate.query(SQLCommand, new GameMapper());
    }
    @Override
    public List<Post> getPosts(String SQLCommand) throws SQLException {
        return jdbcTemplate.query(SQLCommand, new PostMapper());
    }

    @Override
    public void addComment(Comment comment) throws SQLException {
       jdbcTemplate.update(INSERT_NEW_COMMENT,comment.getAuthorId(),comment.getMessage(),comment.getPostId(),comment.getCreatedAt(),comment.getApproved());
    }
    @Override
    public void addUser(User user) throws SQLException {
        jdbcTemplate.update(INSERT_NEW_USER,user.getFirstName(),user.getLastName(),user.getPassword(),user.getEmail(),user.getCreatedAt(),user.getRole());
    }
    @Override
    public void addGameObject(GameObject obj) throws SQLException {
        jdbcTemplate.update(INSERT_NEW_GAMEOBJECT,obj.getGameId(),obj.getTitle(),obj.getText(),obj.getStatus(),obj.getCreatedAt(),obj.getUpdatedAt());
    }
    @Override
    public void addGame(Game game) throws SQLException {
        jdbcTemplate.update(INSERT_NEW_GAME,game.getName());
    }
    @Override
    public void addPost(Post post) throws SQLException {
        jdbcTemplate.update(INSERT_NEW_POST,post.getDealer_id());
    }
}
