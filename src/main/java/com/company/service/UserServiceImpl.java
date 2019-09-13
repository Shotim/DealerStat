package com.company.service;

import com.company.database.DataBaseService;
import com.company.entity.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    public DataBaseService dataBaseService;

    @Override
    public List<Comment> findComments(String SQLCommand) {
        return dataBaseService.getComments(SQLCommand);
    }

    @Override
    public List<GameObject> findGameObjects(String SQLCommand) {
        return dataBaseService.getGameObjects(SQLCommand);
    }

    @Override
    public List<Game> findGames(String SQLCommand) {
        return dataBaseService.getGames(SQLCommand);
    }

    @Override
    public List<Post> findPosts(String SQLCommand) {
        return dataBaseService.getPosts(SQLCommand);
    }

    @Override
    public List<User> findUsers(String SQLCommand) {
        return dataBaseService.getUsers(SQLCommand);
    }

    @Override
    public void addComment(Comment comment) {
        dataBaseService.addComment(comment);
    }

    @Override
    public void addGameObject(GameObject gameObject) {
        dataBaseService.addGameObject(gameObject);
    }

    @Override
    public void addGame(Game game) {
        dataBaseService.addGame(game);
    }

    @Override
    public void addPost(Post post) {
        dataBaseService.addPost(post);
    }

    @Override
    public void addUser(User user) {
        dataBaseService.addUser(user);
    }

    @Override
    public void addGameObjectToPost(int gameObjectId, int postId) {
        dataBaseService.addGameObjectToPost(gameObjectId, postId);
    }
}
