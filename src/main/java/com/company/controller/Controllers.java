package com.company.controller;

import com.company.entity.Comment;
import com.company.service.comment.CommentService;
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

    public static ModelAndView addPostToModel(int dealerId, String postId, String file, PostService postService, GameObjectService gameObjectService, CommentService commentService) {
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

    public static void addDefaultComment(Comment comment, String postId, int authorId, CommentService commentService){
        comment.setId(Comment.DEFAULT_ID);
        comment.setPostId(Integer.parseInt(postId));
        comment.setCreatedAt(new Date(new java.util.Date().getTime()));
        comment.setAuthorId(authorId);
        comment.setApproved(false);
        commentService.addComment(comment);
    }

}
