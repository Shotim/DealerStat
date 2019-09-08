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
    private static final String INSERT_NEW_COMMENT = "INSERT INTO comments VALUES (?,?,?,?,?,?)";
    private static final String INSERT_NEW_USER = "INSERT INTO users VALUES (?,?,?,?,?,?,?)";
    private static final String INSERT_NEW_GAMEOBJECT = "INSERT INTO gameobjects VALUES (?,?,?,?,?,?,?)";
    private static final String INSERT_NEW_GAME = "INSERT INTO games VALUES (?,?)";
    private static final String SELECT_ALL_USERS = "SELECT * FROM users";
    private static final String SELECT_ALL_COMMENTS = "SELECT * FROM comments";
    private static final String SELECT_ALL_GAMEOBJECTS = "SELECT * FROM gameobjects";
    private static final String SELECT_ALL_GAMES = "SELECT * FROM games";
    //private static final String DELETE_ALL = "";
    private static final String SELECT_ALL_COMMENTS_WITH_USER_ID = "SELECT * FROM comments WHERE author_id=";
    private static final String SELECT_ALL_USERS_WITH_ID = "SELECT * FROM users WHERE id=";
    private static final String SELECT_ALL_GAMEOBJECTS_WITH_ID = "SELECT * FROM users WHERE id=";
    private static final String SELECT_ALL_GAMES_WITH_ID = "SELECT * FROM users WHERE id=";


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

    public void addComment(Comment comment) throws SQLException {
        preparedStatement = connection.prepareStatement(INSERT_NEW_COMMENT);
        preparedStatement.setInt(1, comment.getId());
        preparedStatement.setInt(2, comment.getAuthorId());
        preparedStatement.setString(3, comment.getMessage());
        preparedStatement.setInt(4, comment.getPostId());
        preparedStatement.setDate(5, comment.getCreatedAt());
        preparedStatement.setBoolean(6, comment.getApproved());
        preparedStatement.execute();
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

    public void addUser(User user) throws SQLException {
        preparedStatement = connection.prepareStatement(INSERT_NEW_USER);
        preparedStatement.setInt(1, user.getId());
        preparedStatement.setString(2, user.getFirstName());
        preparedStatement.setString(3, user.getLastName());
        preparedStatement.setString(4, user.getPassword());
        preparedStatement.setString(5, user.getEmail());
        preparedStatement.setDate(6, user.getCreatedAt());
        preparedStatement.setString(7, user.getRole().name());
        preparedStatement.execute();
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

    public void addGameObject(GameObject obj) throws SQLException {
        preparedStatement = connection.prepareStatement(INSERT_NEW_GAMEOBJECT);
        preparedStatement.setInt(1, obj.getId());
        preparedStatement.setInt(2, obj.getGameId());
        preparedStatement.setString(3, obj.getTitle());
        preparedStatement.setString(4, obj.getText());
        preparedStatement.setString(5, obj.getStatus().toString());
        preparedStatement.setDate(6, obj.getCreatedAt());
        preparedStatement.setDate(7, obj.getUpdatedAt());
        preparedStatement.execute();
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

    public void addGame(Game game) throws SQLException {
        preparedStatement = connection.prepareStatement(INSERT_NEW_GAME);
        preparedStatement.setInt(1, game.getId());
        preparedStatement.setString(2, game.getName());
        preparedStatement.execute();
    }
}
