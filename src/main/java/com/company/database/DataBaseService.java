package com.company.database;

import com.company.entity.*;

import java.sql.SQLException;
import java.util.List;

public interface DataBaseService {
    public List<Comment> getComments(String SQLCommand) throws SQLException;

    public List<GameObject> getGameObjects(String SQLCommand) throws SQLException;

    public List<Game> getGames(String SQLCommand) throws SQLException;

    public List<Post> getPosts(String SQLCommand) throws SQLException;

    public List<User> getUsers(String SQLCommand) throws SQLException;

    public void addComment(Comment comment) throws SQLException;

    public void addGameObject(GameObject gameObject) throws SQLException;

    public void addGame(Game game) throws SQLException;

    public void addPost(Post post) throws SQLException;

    public void addUser(User user) throws SQLException;
}
