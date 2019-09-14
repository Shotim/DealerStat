package com.company.database;

import com.company.entity.*;

import java.util.List;

public interface DataBaseService {
    List<Comment> getCommentsFromPost(int postId);

    List<User> getAllUsers();

    User getUser(int userId);

    List<GameObject> getAllGameObjects();

    List<GameObject> getGameObjectsFromPost(int postId);

    List<GameObject> getGameObjectsOfGame(int gameId);

    GameObject getGameObject(int objectId);

    List<Game> getAllGames();

    Game getGame(int gameId);

    List<Post> getAllPosts();

    List<Post> getPostsOfDealer(int dealerId);

    Post getPost(int postId);


    void addComment(Comment comment);

    void addGameObject(GameObject gameObject);

    void addGame(Game game);

    void addPost(Post post);

    void addUser(User user);

    void addGameObjectToPost(int gameObjectId, int postId);
}
