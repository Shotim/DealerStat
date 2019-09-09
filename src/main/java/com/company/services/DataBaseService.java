package com.company.services;

import com.company.modules.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class DataBaseService {
    private static final @Getter
    String DB_URL = "jdbc:mysql://localhost:3306/dealer_stat?useUnicode=true&serverTimezone=UTC";
    private static final @Getter
    String PASSWORD = "root";
    private static final @Getter
    String USER = "root";
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


    PreparedStatement preparedStatement = null;

    Connection connection;

    {
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    Statement statement;

    {
        try {
            if (this.connection != null) {
                statement = this.connection.createStatement();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    ResultSet result = null;

    public List<Comment> getComments(String command) throws SQLException {
        List<Comment> comments = new ArrayList<>();
        result = statement.executeQuery(command);
        while (result.next()) {
            comments.add(new Comment(result.getInt("id"),
                    result.getString("message"),
                    result.getInt("post_id"),
                    result.getInt("author_id"),
                    result.getDate("created_at"),
                    result.getBoolean("approved")));
        }
        return comments;
    }

    public List<User> getUsers(String command) throws SQLException {
        List<User> users = new ArrayList<>();
        result = statement.executeQuery(command);
        while (result.next()) {
            users.add(new User(result.getInt("id"),
                    result.getString("first_name"),
                    result.getString("last_name"),
                    result.getString("password"),
                    result.getString("email"),
                    result.getDate("created_at"),
                    Role.valueOf(result.getString("role"))));
        }
        return users;
    }

    public List<GameObject> getGameObjects(String command) throws SQLException {
        List<GameObject> gameObjects = new ArrayList<>();
        result = statement.executeQuery(command);
        while (result.next()) {
            gameObjects.add(
                    new GameObject(result.getInt("id"),
                            result.getString("title"),
                            result.getString("text"),
                            GameObjectStatus.valueOf(result.getString("status")),
                            result.getDate("created_at"),
                            result.getDate("updated_at"),
                            result.getInt("game_id")));
        }
        return gameObjects;
    }

    public List<Game> getGames(String command) throws SQLException {
        List<Game> games = new ArrayList<>();
        result = statement.executeQuery(command);
        while (result.next()) {
            games.add(
                    new Game(result.getInt("id"),
                            result.getString("name")));
        }
        return games;
    }

    public List<Post> getPosts(String command) throws SQLException {
        List<Post> posts = new ArrayList<>();
        result = statement.executeQuery(command);
        while (result.next()) {
            posts.add(
                    new Post(result.getInt("id"),
                            result.getInt("dealer_id")));
        }
        return posts;
    }


    public void addComment(Comment comment) throws SQLException {
        preparedStatement = connection.prepareStatement(INSERT_NEW_COMMENT);
        preparedStatement.setInt(1, comment.getAuthorId());
        preparedStatement.setString(2, comment.getMessage());
        preparedStatement.setInt(3, comment.getPostId());
        preparedStatement.setDate(4, comment.getCreatedAt());
        preparedStatement.setBoolean(5, comment.getApproved());
        preparedStatement.execute();
    }

    public void addUser(User user) throws SQLException {
        preparedStatement = connection.prepareStatement(INSERT_NEW_USER);
        preparedStatement.setString(1, user.getFirstName());
        preparedStatement.setString(2, user.getLastName());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.setString(4, user.getEmail());
        preparedStatement.setDate(5, user.getCreatedAt());
        preparedStatement.setString(6, user.getRole().name());
        preparedStatement.execute();
    }

    public void addGameObject(GameObject obj) throws SQLException {
        preparedStatement = connection.prepareStatement(INSERT_NEW_GAMEOBJECT);
        preparedStatement.setInt(1, obj.getGameId());
        preparedStatement.setString(2, obj.getTitle());
        preparedStatement.setString(3, obj.getText());
        preparedStatement.setString(4, obj.getStatus().toString());
        preparedStatement.setDate(5, obj.getCreatedAt());
        preparedStatement.setDate(6, obj.getUpdatedAt());
        preparedStatement.execute();
    }

    public void addGame(Game game) throws SQLException {
        preparedStatement = connection.prepareStatement(INSERT_NEW_GAME);
        preparedStatement.setString(1, game.getName());
        preparedStatement.execute();
    }

    public void addPost(Post post) throws SQLException {
        preparedStatement = connection.prepareStatement(INSERT_NEW_POST);
        preparedStatement.setInt(1, post.getDealer_id());
        preparedStatement.execute();
    }
}
