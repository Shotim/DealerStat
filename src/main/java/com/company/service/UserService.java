package com.company.service;

import com.company.entity.*;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    public List<Comment> findComments(String SQLCommand) throws SQLException;

    public List<GameObject> findGameObjects(String SQLCommand) throws SQLException;

    public List<Game> findGames(String SQLCommand) throws SQLException;

    public List<Post> findPosts(String SQLCommand) throws SQLException;

    public List<User> findUsers(String SQLCommand) throws SQLException;

    public void addComment(Comment comment) throws SQLException;

    public void addGameObject(GameObject gameObject) throws SQLException;

    public void addGame(Game game) throws SQLException;

    public void addPost(Post post) throws SQLException;

    public void addUser(User user) throws SQLException;
}
