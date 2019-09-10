package com.company.service;

import com.company.database.DataBaseService;
import com.company.entity.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    public DataBaseService dataBaseService;

    @Override
    public List<Comment> findComments(String SQLCommand) throws SQLException {
        return dataBaseService.getComments(SQLCommand);
    }

    @Override
    public List<GameObject> findGameObjects(String SQLCommand) throws SQLException {
        return dataBaseService.getGameObjects(SQLCommand);
    }

    @Override
    public List<Game> findGames(String SQLCommand) throws SQLException {
        return dataBaseService.getGames(SQLCommand);
    }

    @Override
    public List<Post> findPosts(String SQLCommand) throws SQLException {
        return dataBaseService.getPosts(SQLCommand);
    }

    @Override
    public List<User> findUsers(String SQLCommand) throws SQLException {
        return dataBaseService.getUsers(SQLCommand);
    }

    @Override
    public void addComment(Comment comment) throws SQLException {
        dataBaseService.addComment(comment);
    }

    @Override
    public void addGameObject(GameObject gameObject) throws SQLException {
        dataBaseService.addGameObject(gameObject);
    }

    @Override
    public void addGame(Game game) throws SQLException {
        dataBaseService.addGame(game);
    }

    @Override
    public void addPost(Post post) throws SQLException {
        dataBaseService.addPost(post);
    }

    @Override
    public void addUser(User user) throws SQLException {
        dataBaseService.addUser(user);
    }
}
