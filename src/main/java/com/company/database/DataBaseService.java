package com.company.database;

import com.company.entity.*;

import java.util.List;

public interface DataBaseService {
    public List<Comment> getComments(String SQLCommand);

    public List<GameObject> getGameObjects(String SQLCommand);

    public List<Game> getGames(String SQLCommand);

    public List<Post> getPosts(String SQLCommand);

    public List<User> getUsers(String SQLCommand);

    public void addComment(Comment comment);

    public void addGameObject(GameObject gameObject);

    public void addGame(Game game);

    public void addPost(Post post);

    public void addUser(User user);

    public void addGameObjectToPost(int gameObjectId, int postId);
}
