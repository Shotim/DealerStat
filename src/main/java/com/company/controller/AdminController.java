package com.company.controller;

import com.company.service.comment.CommentService;
import com.company.service.game.GameService;
import com.company.service.gameobject.GameObjectService;
import com.company.service.post.PostService;
import com.company.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/")
@AllArgsConstructor
public class AdminController {

    public UserService userService;

    public CommentService commentService;

    public GameObjectService gameObjectService;

    public GameService gameService;

    public PostService postService;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/start/index");
        return modelAndView;
    }

    @GetMapping("/gameObjects")
    public ModelAndView gameObjects() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/showEntities/gameObjects");
        modelAndView.addObject("gameobjects", gameObjectService.findAllGameObjects());
        return modelAndView;
    }

    @GetMapping("/gameObject/{id}")
    public ModelAndView gameObject(@PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/entity/gameObject");
        modelAndView.addObject("gameobject",
                gameObjectService.findGameObject(Integer.parseInt(id)));
        return modelAndView;
    }

    @GetMapping("/games")
    public ModelAndView games() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/showEntities/games");
        modelAndView.addObject("games",
                gameService.findAllGames());
        return modelAndView;
    }

    @GetMapping("/game/{id}")
    public ModelAndView game(@PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/entity/game");
        modelAndView.addObject("game",
                gameService.findGame(Integer.parseInt(id)));
        modelAndView.addObject("gameobjects",
                gameObjectService.findGameObjectsOfGame(Integer.parseInt(id)));
        return modelAndView;
    }

    @GetMapping("/posts")
    public ModelAndView posts() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/showEntities/posts");
        modelAndView.addObject("posts",
                postService.findAllPosts());
        return modelAndView;
    }

    @GetMapping("/post/{id}")
    public ModelAndView post(@PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/entity/post");
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
        modelAndView.setViewName("admin/showEntities/dealers");
        modelAndView.addObject("users",
                userService.findAllUsers());
        return modelAndView;
    }

    @GetMapping("/dealer/{id}")
    public ModelAndView dealer(@PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/entity/dealer");
        modelAndView.addObject("dealer",
                userService.findUser(Integer.parseInt(id)));
        modelAndView.addObject("posts",
                postService.findPostsOfDealer(Integer.parseInt(id)));
        return modelAndView;
    }

    @GetMapping("/unapprovedComments")
    public ModelAndView unapprovedComments(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/showEntities/unapprovedComments");
        modelAndView.addObject("comments",commentService.findUnapprovedComments());
        return modelAndView;
    }

    @GetMapping("/unapprovedComments/approve{id}")
    public ModelAndView approveComment(@PathVariable("id")String id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/editEntity/approveComment");
        return modelAndView;
    }

    @PostMapping("/unapprovedComments/approve{id}")
    public ModelAndView approveComment(@PathVariable("id")String id, Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin/unapprovedComments");
        commentService.approveComment(Integer.parseInt(id));
        return modelAndView;
    }
}
