package com.company.database;

import com.company.entity.gameObject.GameObject;
import com.company.entity.Post;
import com.company.entity.Comment;
import com.company.entity.Game;
import com.company.entity.user.User;

import java.util.List;

public interface DataBaseService {
    List<Comment> getCommentsFromPost(int postId);

    List<Comment> getUnapprovedComments();

    List<User> getAllUsers();

    User getUser(int userId);

    User getUser(String email);

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

    void deleteGameObjectFromPost(int gameObjectId, int postId);

    void deletePost(int postId);

    void deleteUser(int userId);

    void deleteComment(int commentId);

    void editUser(User user);

    void editComment(Comment comment);

    void makeCommentApproved(int commentId);
}
