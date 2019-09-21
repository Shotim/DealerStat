package com.company.controller;

import com.company.entity.Comment;
import com.company.service.comment.CommentService;
import com.company.service.game.GameService;
import com.company.service.gameobject.GameObjectService;
import com.company.service.post.PostService;
import com.company.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;

@Component
@AllArgsConstructor
public class ControllerUtility {

    private UserService userService;

    private CommentService commentService;

    private PostService postService;

    private GameService gameService;

    private GameObjectService gameObjectService;

    public int sessionDealerId() {
        return userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
    }

    public void addDefaultComment(Comment comment,
                                         String postId,
                                         int authorId) {

        comment.setId(Comment.DEFAULT_ID);
        comment.setPostId(Integer.parseInt(postId));
        comment.setCreatedAt(new Date(new java.util.Date().getTime()));
        comment.setAuthorId(authorId);
        comment.setApproved(false);
        commentService.addComment(comment);
    }

    public ModelAndView startPage(String viewName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        return modelAndView;
    }

    public ModelAndView viewDealersPage(String viewName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        modelAndView.addObject("users", userService.findAllUsers());
        return modelAndView;
    }

    public ModelAndView viewDealerWithId(String viewName,
                                                String dealerId) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        modelAndView.addObject("dealer",
                userService.findUser(Integer.parseInt(dealerId)));
        modelAndView.addObject("posts",
                postService.findPostsOfDealer(Integer.parseInt(dealerId)));
        return modelAndView;
    }

    public ModelAndView viewGamesPage(String viewName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        modelAndView.addObject("games", gameService.findAllGames());
        return modelAndView;
    }

    public ModelAndView viewGameWithId(String viewName,
                                              String gameId) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        modelAndView.addObject("game",
                gameService.findGame(Integer.parseInt(gameId)));
        modelAndView.addObject("gameobjects",
                gameObjectService.findGameObjectsOfGame(Integer.parseInt(gameId)));
        return modelAndView;
    }

    public ModelAndView viewGameObjectsPage(String viewName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        modelAndView.addObject("gameobjects", gameObjectService.findAllGameObjects());
        return modelAndView;
    }

    public ModelAndView viewGameObjectWithId(String viewName,
                                                    String gameObjectId) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        modelAndView.addObject("gameobject",
                gameObjectService.findGameObject(Integer.parseInt(gameObjectId)));
        return modelAndView;
    }

    public ModelAndView viewPostsPage(String viewName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        modelAndView.addObject("posts",
                postService.findAllPosts());
        return modelAndView;
    }

    public ModelAndView viewPostWithId(String viewName,
                                              String postId) {

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
