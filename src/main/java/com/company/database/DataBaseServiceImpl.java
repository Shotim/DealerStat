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

    private static final String SELECT_COMMENTS_WITH_POST_ID = "SELECT * FROM comments WHERE post_id=?";

    private static final String SELECT_ALL_USERS = "SELECT * FROM users";
    private static final String SELECT_USER_WITH_ID = "SELECT * FROM users WHERE id=?";

    private static final String SELECT_ALL_GAMEOBJECTS = "SELECT * FROM gameobjects";
    private static final String SELECT_ALL_GAMEOBJECTS_FROM_POST_WITH_ID = "SELECT * FROM gameobjects NATURAL JOIN post_gameobjects as pg WHERE pg.post_id=?";
    private static final String SELECT_ALL_GAMEOBJECTS_WITH_GAME_ID = "SELECT * FROM gameobjects WHERE game_id=?";
    private static final String SELECT_GAMEOBJECT_WITH_ID = "SELECT * FROM gameobjects WHERE id=?";

    private static final String SELECT_GAME_WITH_ID = "SELECT * FROM games WHERE id=?";
    private static final String SELECT_ALL_GAMES = "SELECT * FROM games";

    private static final String SELECT_ALL_POSTS_WITH_DEALER_ID = "SELECT * FROM posts WHERE dealer_id=?";
    private static final String SELECT_POST_WITH_ID = "SELECT * FROM posts WHERE id=?";
    private static final String SELECT_ALL_POSTS = "SELECT * FROM posts";

    private static final String DELETE_GAMEOBJECT_FROM_POST_WITH_ID = "DELETE FROM post_gameobjects WHERE post_id=? AND gameobject_id=?";
    private static final String DELETE_POST_WITH_ID = "DELETE FROM posts WHERE id=?";
    private static final String DELETE_USER_WITH_ID = "DELETE FROM users WHERE id=?";
    private static final String DELETE_COMMENT_WITH_ID = "DELETE FROM comments WHERE id=?";

    private static final String EDIT_USER_WITH_ID = "UPDATE users SET first_name=?, last_name=?, password=?, email=? WHERE id=?";
    private static final String EDIT_COMMENT_WITH_ID = "UPDATE comments SET message=? WHERE id=?";

    public final JdbcTemplate jdbcTemplate;

    @Override
    public List<Comment> getCommentsFromPost(int postId) {
        return jdbcTemplate.query(SELECT_COMMENTS_WITH_POST_ID,
                new CommentMapper(), postId);
    }

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
    public List<Game> getAllGames() {
        return jdbcTemplate.query(SELECT_ALL_GAMES,
                new GameMapper());
    }

    @Override
    public Game getGame(int gameId) {
        return jdbcTemplate.queryForObject(SELECT_GAME_WITH_ID,
                new GameMapper(), gameId);
    }

    @Override
    public List<Post> getAllPosts() {
        return jdbcTemplate.query(SELECT_ALL_POSTS,
                new PostMapper());
    }

    @Override
    public List<Post> getPostsOfDealer(int dealerId) {
        return jdbcTemplate.query(SELECT_ALL_POSTS_WITH_DEALER_ID,
                new PostMapper(), dealerId);
    }

    @Override
    public Post getPost(int postId) {
        return jdbcTemplate.queryForObject(SELECT_POST_WITH_ID,
                new PostMapper(), postId);
    }

    @Override
    public void addComment(Comment comment) {
        jdbcTemplate.update(INSERT_NEW_COMMENT, comment.getAuthorId(),
                comment.getMessage(), comment.getPostId(),
                comment.getCreatedAt(), comment.getApproved());
    }

    @Override
    public void addUser(User user) {
        jdbcTemplate.update(INSERT_NEW_USER, user.getFirstName(),
                user.getLastName(), user.getPassword(),
                user.getEmail(), user.getCreatedAt(),
                user.getRole().toString());
    }

    @Override
    public void addGameObject(GameObject obj) {
        jdbcTemplate.update(INSERT_NEW_GAMEOBJECT, obj.getGameId(),
                obj.getTitle(), obj.getText(),
                obj.getStatus().toString(),
                obj.getCreatedAt(), obj.getUpdatedAt());
    }

    @Override
    public void addGame(Game game) {
        jdbcTemplate.update(INSERT_NEW_GAME,
                game.getName());
    }

    @Override
    public void addPost(Post post) {
        jdbcTemplate.update(INSERT_NEW_POST,
                post.getDealerId());
    }

    @Override
    public void addGameObjectToPost(int gameObjectId, int postId) {
        jdbcTemplate.update(INSERT_GAMEOBJECT_TO_POST, postId, gameObjectId);
    }

    @Override
    public void deleteGameObjectFromPost(int gameObjectId, int postId) {
        jdbcTemplate.update(DELETE_GAMEOBJECT_FROM_POST_WITH_ID, postId, gameObjectId);
    }

    @Override
    public void deletePost(int postId) {
        jdbcTemplate.update(DELETE_POST_WITH_ID,
                postId);
    }

    @Override
    public void deleteUser(int userId) {
        jdbcTemplate.update(DELETE_USER_WITH_ID,
                userId);
    }

    @Override
    public void deleteComment(int commentId) {
        jdbcTemplate.update(DELETE_COMMENT_WITH_ID,
                commentId);
    }

    @Override
    public void editUser(User user) {
        jdbcTemplate.update(EDIT_USER_WITH_ID, user.getFirstName(),
                user.getLastName(), user.getPassword(),
                user.getEmail(), user.getId());
    }

    @Override
    public void editComment(Comment comment) {
        jdbcTemplate.update(EDIT_COMMENT_WITH_ID, comment.getMessage(), comment.getId());
    }
}
