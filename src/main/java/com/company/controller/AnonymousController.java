package com.company.controller;

import com.company.entity.Comment;
import com.company.service.comment.CommentService;
import com.company.service.game.GameService;
import com.company.service.gameobject.GameObjectService;
import com.company.service.post.PostService;
import com.company.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;

@Controller
@RequestMapping("/anonym/")
@AllArgsConstructor
public class AnonymousController {

    public UserService userService;

    public CommentService commentService;

    public GameObjectService gameObjectService;

    public GameService gameService;

    public PostService postService;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("anonym/start/index");
        return modelAndView;
    }

    @GetMapping("/gameObjects")
    public ModelAndView gameObjects() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("anonym/showEntities/gameObjects");
        modelAndView.addObject("gameobjects", gameObjectService.findAllGameObjects());
        return modelAndView;
    }

    @GetMapping("/gameObject/{id}")
    public ModelAndView gameObject(@PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("anonym/entity/gameObject");
        modelAndView.addObject("gameobject",
                gameObjectService.findGameObject(Integer.parseInt(id)));
        return modelAndView;
    }

    @GetMapping("/games")
    public ModelAndView games() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("anonym/showEntities/games");
        modelAndView.addObject("games",
                gameService.findAllGames());
        return modelAndView;
    }

    @GetMapping("/game/{id}")
    public ModelAndView game(@PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("anonym/entity/game");
        modelAndView.addObject("game",
                gameService.findGame(Integer.parseInt(id)));
        modelAndView.addObject("gameobjects",
                gameObjectService.findGameObjectsOfGame(Integer.parseInt(id)));
        return modelAndView;
    }

    @GetMapping("/posts")
    public ModelAndView posts() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("anonym/showEntities/posts");
        modelAndView.addObject("posts",
                postService.findAllPosts());
        return modelAndView;
    }

    @GetMapping("/post/{id}")
    public ModelAndView post(@PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("anonym/entity/post");
        modelAndView.addObject("post",
                postService.findPost(Integer.parseInt(id)));
        modelAndView.addObject("gameobjects",
                gameObjectService.findGameObjectsFromPost(Integer.parseInt(id)));
        modelAndView.addObject("comments",
                commentService.findCommentsFromPost(Integer.parseInt(id)));
        return modelAndView;
    }

    @GetMapping("/dealers")
    public ModelAndView dealers() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("anonym/showEntities/dealers");
        modelAndView.addObject("users",
                userService.findAllUsers());
        return modelAndView;
    }

    @GetMapping("/dealer/{id}")
    public ModelAndView dealer(@PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("anonym/entity/dealer");
        modelAndView.addObject("dealer",
                userService.findUser(Integer.parseInt(id)));
        modelAndView.addObject("posts",
                postService.findPostsOfDealer(Integer.parseInt(id)));
        return modelAndView;
    }

    @GetMapping("/post/{id}/newComment")
    public ModelAndView newComment(@PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("anonym/addEntity/newComment");
        return modelAndView;
    }

    @PostMapping("/post/{id}/newComment")
    public ModelAndView newComment(@PathVariable("id") String postId,
                                   @ModelAttribute("comment") Comment comment) {
        comment.setId(Comment.DEFAULT_ID);
        comment.setPostId(Integer.parseInt(postId));
        comment.setCreatedAt(new Date(new java.util.Date().getTime()));
        comment.setAuthorId(Comment.DEFAULT_ID);
        comment.setApproved(false);
        commentService.addComment(comment);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect: /anonym/post/" + postId);
        return modelAndView;
    }

    @GetMapping("/post/{postId}/editComment/{commentId}")
    public ModelAndView editComment(@PathVariable("postId") String postId,
                                    @PathVariable("commentId") String commentId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("anonym/editEntity/editComment");
        return modelAndView;
    }

    @PostMapping("/post/{postId}/editComment/{commentId}")
    public ModelAndView editComment(@PathVariable("postId") String postId,
                                    @PathVariable("commentId") String commentId,
                                    @ModelAttribute("comment") Comment comment) {
        comment.setId(Integer.parseInt(commentId));
        commentService.editComment(comment);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/post/" + postId);
        return modelAndView;
    }
}
