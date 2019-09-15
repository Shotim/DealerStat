package com.company.service;

import com.company.entity.*;

import java.util.List;

public interface UserService {

    List<Comment> findCommentsFromPost(int postId);

    List<User> findAllUsers();

    User findUser(int userId);

    User findUser(String email);

    List<GameObject> findAllGameObjects();

    List<GameObject> findGameObjectsFromPost(int postId);

    List<GameObject> findGameObjectsOfGame(int gameId);

    GameObject findGameObject(int objectId);

    List<Game> findAllGames();

    Game findGame(int gameId);

    List<Post> findAllPosts();

    List<Post> findPostsOfDealer(int dealerId);

    Post findPost(int postId);

    void addComment(Comment comment);

    void addGameObject(GameObject gameObject);

    void addGame(Game game);

    void addPost(Post post);

    void addUser(User user);

    void addGameObjectToPost(int gameObjectId, int postId);

    void removeGameObjectFromPost(int gameObjectId, int postId);

    void removePost(int postId);

    void removeUser(int userId);

    void removeComment(int commentId);

    void editUser(User user);

    void editComment(Comment comment);
}
