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
    public List<Comment> findCommentsFromPost(int postId) {
        return dataBaseService.getCommentsFromPost(postId);
    }

    @Override
    public List<User> findAllUsers() {
        return dataBaseService.getAllUsers();
    }

    @Override
    public User findUser(int userId) {
        return dataBaseService.getUser(userId);
    }

    @Override
    public User findUser(String email) {
        return dataBaseService.getUser(email);
    }

    @Override
    public List<GameObject> findAllGameObjects() {
        return dataBaseService.getAllGameObjects();
    }

    @Override
    public List<GameObject> findGameObjectsFromPost(int postId) {
        return dataBaseService.getGameObjectsFromPost(postId);
    }

    @Override
    public List<GameObject> findGameObjectsOfGame(int gameId) {
        return dataBaseService.getGameObjectsOfGame(gameId);
    }

    @Override
    public GameObject findGameObject(int objectId) {
        return dataBaseService.getGameObject(objectId);
    }

    @Override
    public List<Game> findAllGames() {
        return dataBaseService.getAllGames();
    }

    @Override
    public Game findGame(int gameId) {
        return dataBaseService.getGame(gameId);
    }

    @Override
    public List<Post> findAllPosts() {
        return dataBaseService.getAllPosts();
    }

    @Override
    public List<Post> findPostsOfDealer(int dealerId) {
        return dataBaseService.getPostsOfDealer(dealerId);
    }

    @Override
    public Post findPost(int postId) {
        return dataBaseService.getPost(postId);
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

    @Override
    public void removeGameObjectFromPost(int gameObjectId, int postId) {
        dataBaseService.deleteGameObjectFromPost(gameObjectId, postId);
    }

    @Override
    public void removePost(int postId) {
        dataBaseService.deletePost(postId);
    }

    @Override
    public void removeUser(int userId) {
        dataBaseService.deleteUser(userId);
    }

    @Override
    public void removeComment(int commentId) {
        dataBaseService.deleteComment(commentId);
    }

    @Override
    public void editUser(User user) {
        dataBaseService.editUser(user);
    }

    @Override
    public void editComment(Comment comment) {
        dataBaseService.editComment(comment);
    }
}
