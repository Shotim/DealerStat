package com.company.service;

import com.company.entity.*;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    public List<Comment> findComments(String SQLCommand);

    public List<GameObject> findGameObjects(String SQLCommand);

    public List<Game> findGames(String SQLCommand);

    public List<Post> findPosts(String SQLCommand);

    public List<User> findUsers(String SQLCommand);

    public void addComment(Comment comment);

    public void addGameObject(GameObject gameObject);

    public void addGame(Game game);

    public void addPost(Post post);

    public void addUser(User user);
}
