package com.company.controller;

import com.company.entity.Comment;
import com.company.service.comment.CommentService;
import com.company.service.game.GameService;
import com.company.service.gameobject.GameObjectService;
import com.company.service.post.PostService;
import com.company.service.user.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;

public class Controllers {

    public static int sessionDealerId(UserService userService) {
        return userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
    }

    public static ModelAndView viewDealersPost(int dealerId, String postId, String file, PostService postService, GameObjectService gameObjectService, CommentService commentService) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dealer/entity/" + file);
        modelAndView.addObject("post",
                postService.findPost(Integer.parseInt(postId)));
        modelAndView.addObject("gameobjects",
                gameObjectService.findGameObjectsFromPost(Integer.parseInt(postId)));
        modelAndView.addObject("comments",
                commentService.findCommentsFromPost(Integer.parseInt(postId)));
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    public static void addDefaultComment(Comment comment, String postId, int authorId, CommentService commentService) {
        comment.setId(Comment.DEFAULT_ID);
        comment.setPostId(Integer.parseInt(postId));
        comment.setCreatedAt(new Date(new java.util.Date().getTime()));
        comment.setAuthorId(authorId);
        comment.setApproved(false);
        commentService.addComment(comment);
    }

    public static ModelAndView startPage(String viewName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        return modelAndView;
    }

    public static ModelAndView viewDealersPage(String viewName, UserService userService) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        modelAndView.addObject("users", userService.findAllUsers());
        return modelAndView;
    }

    public static ModelAndView viewDealerWithId(String viewName, String dealerId, UserService userService, PostService postService) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        modelAndView.addObject("dealer",
                userService.findUser(Integer.parseInt(dealerId)));
        modelAndView.addObject("posts",
                postService.findPostsOfDealer(Integer.parseInt(dealerId)));
        return modelAndView;
    }

    public static ModelAndView viewGamesPage(String viewName, GameService gameService) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        modelAndView.addObject("games", gameService.findAllGames());
        return modelAndView;
    }

    public static ModelAndView viewGameWithId(String viewName, String gameId, GameService gameService, GameObjectService gameObjectService) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        modelAndView.addObject("game",
                gameService.findGame(Integer.parseInt(gameId)));
        modelAndView.addObject("gameobjects",
                gameObjectService.findGameObjectsOfGame(Integer.parseInt(gameId)));
        return modelAndView;
    }

    public static ModelAndView viewGameObjectsPage(String viewName, GameObjectService gameObjectService) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        modelAndView.addObject("gameobjects", gameObjectService.findAllGameObjects());
        return modelAndView;
    }

    public static ModelAndView viewGameObjectWithId(String viewName, String gameObjectId, GameObjectService gameObjectService) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        modelAndView.addObject("gameobject",
                gameObjectService.findGameObject(Integer.parseInt(gameObjectId)));
        return modelAndView;
    }

    public static ModelAndView viewPostsPage(String viewName, PostService postService) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        modelAndView.addObject("posts",
                postService.findAllPosts());
        return modelAndView;
    }

    public static ModelAndView viewPostWithId(String viewName, String postId, PostService postService, GameObjectService gameObjectService, CommentService commentService) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        modelAndView.addObject("post",
                postService.findPost(Integer.parseInt(postId)));
        modelAndView.addObject("gameobjects",
                gameObjectService.findGameObjectsFromPost(Integer.parseInt(postId)));
        modelAndView.addObject("comments",
                commentService.findCommentsFromPost(Integer.parseInt(postId)));
        return modelAndView;
    }
}
