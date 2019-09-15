package com.company.controller;

import com.company.entity.*;
import com.company.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class UserController {

    public UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/gameObjects")
    public String gameObjects(Model model) {
        model.addAttribute("gameobjects",
                userService.findAllGameObjects());
        return "gameObjects";
    }

    @GetMapping("/gameObject/{id}")
    public String gameObject(@PathVariable("id") String id, Model model) {
        model.addAttribute("gameobject",
                userService.findGameObject(Integer.parseInt(id)));
        return "gameObject";
    }

    @GetMapping("/games")
    public String games(Model model) {
        model.addAttribute("games",
                userService.findAllGames());
        return "games";
    }

    @GetMapping("/game/{id}")
    public String game(@PathVariable("id") String id, Model model) {
        model.addAttribute("game",
                userService.findGame(Integer.parseInt(id)));
        model.addAttribute("gameobjects",
                userService.findGameObjectsOfGame(Integer.parseInt(id)));
        return "game";
    }

    @GetMapping("/posts")
    public String posts(Model model) {
        model.addAttribute("posts",
                userService.findAllPosts());
        return "posts";
    }

    @GetMapping("/post/{id}")
    public String post(@PathVariable("id") String id, Model model) {
        model.addAttribute("post",
                userService.findPost(Integer.parseInt(id)));
        model.addAttribute("gameobjects",
                userService.findGameObjectsFromPost(Integer.parseInt(id)));
        model.addAttribute("comments",
                userService.findCommentsFromPost(Integer.parseInt(id)));
        return "post";
    }

    @GetMapping("/post/{id}/newGameObjects")
    public String gameObjectToPost(@PathVariable("id") int id, Model model) {
        model.addAttribute("games",
                userService.findAllGames());
        model.addAttribute("id", id);
        return "newGameObjects";
    }

    @GetMapping("/dealers")
    public String dealers(Model model) {
        model.addAttribute("users",
                userService.findAllUsers());
        return "dealers";
    }

    @GetMapping("/dealer/{id}")
    public String dealer(@PathVariable("id") String id, Model model) {
        model.addAttribute("dealer",
                userService.findUser(Integer.parseInt(id)));
        model.addAttribute("posts",
                userService.findPostsOfDealer(Integer.parseInt(id)));
        return "dealer";
    }

    @GetMapping("/newDealer")
    public String newDealerPage() {
        return "newDealer";
    }

    @PostMapping("/newDealer")
    public String newDealer(@ModelAttribute("dealer") User dealer) {
        dealer.setRole(Role.DEALER);
        dealer.setCreatedAt(new Date(new java.util.Date().getTime()));
        dealer.setId(User.DEFAULT_ID);
        userService.addUser(dealer);
        return "redirect:/dealers";
    }

    @GetMapping("/post/{postId}/newGameObjects/game/{gameId}")
    public String gameForCreatePost(
            @PathVariable("gameId") String gameId, Model model,
            @PathVariable("postId") String postId) {
        model.addAttribute("game",
                userService.findGame(Integer.parseInt(gameId)));
        model.addAttribute("gameobjects",
                userService.findGameObjectsOfGame(Integer.parseInt(gameId)));
        return "gameFromPost";
    }

    @GetMapping("/post/{id}/newGameObjects/newGame")
    public String newGamePage(@PathVariable("id") String id) {
        return "newGame";
    }

    @PostMapping("/post/{id}/newGameObjects/newGame")
    public String newGame(@PathVariable("id") String id,
                          @ModelAttribute("game") Game game) {
        game.setId(Game.DEFAULT_ID);
        userService.addGame(game);
        return "redirect:/post/" + id + "/newGameObjects";
    }

    @GetMapping("/post/{postId}/newGameObjects/game/{gameId}/newGameObject")
    public String newGameObjectPage(@PathVariable("postId") String postId,
                                    @PathVariable("gameId") String gameId) {
        return "newGameObject";
    }

    @PostMapping("/post/{postId}/newGameObjects/game/{gameId}/newGameObject")
    public String newGameObject(@PathVariable("postId") String postId,
                                @PathVariable("gameId") String gameId,
                                @ModelAttribute("gameobject") GameObject object) {
        object.setGameId(Integer.parseInt(gameId));
        object.setId(GameObject.DEFAULT_ID);
        object.setStatus(GameObjectStatus.IN_STOCK);
        object.setCreatedAt(new Date(new java.util.Date().getTime()));
        object.setUpdatedAt(object.getCreatedAt());
        userService.addGameObject(object);
        return "redirect:/post/" + postId + "/newGameObjects/game/" + gameId;
    }

    @GetMapping("/post/{postId}/newGameObjects/game/{gameId}/newGameObject/{objectId}")
    public String newGameObjectToPostPage(@PathVariable("postId") String postId,
                                          @PathVariable("objectId") String objectId,
                                          @PathVariable("gameId") String gameId) {
        userService.addGameObjectToPost(
                Integer.parseInt(objectId), Integer.parseInt(postId));
        return "newGameObjectInpost";
    }

    @PostMapping("/post/{postId}/newGameObjects/game/{gameId}/newGameObject/{objectId}")
    public String gameObjectToPost(@PathVariable("postId") String postId,
                                   @PathVariable("objectId") String objectId) {
        return "redirect:/post/{postId}";
    }

    @GetMapping("/newDealer{id}post")
    public String newPostPage(@PathVariable("id") String id) {
        userService.addPost(new Post(Post.DEFAULT_ID, Integer.parseInt(id)));
        return "newPost";
    }

    @PostMapping("/newDealer{id}post")
    public String newPost() {
        return "redirect:/dealer/{id}";
    }

    @GetMapping("/post/{id}/newComment")
    public String newCommentPage(@PathVariable("id") String id) {
        return "newComment";
    }

    @PostMapping("/post/{id}/newComment")
    public String newComment(@PathVariable("id") String postId,
                             @ModelAttribute("comment") Comment comment) {
        comment.setId(Comment.DEFAULT_ID);
        comment.setPostId(Integer.parseInt(postId));
        comment.setCreatedAt(new Date(new java.util.Date().getTime()));
        comment.setApproved(false);
        userService.addComment(comment);
        return "redirect: /post/" + postId;
    }

    @GetMapping("/post/{postId}/deleteGameObject/{gameObjectId}")
    public String deleteGameObjectFromPostPage(
            @PathVariable("postId") String postId,
            @PathVariable("gameObjectId") String gameObjectId) {
        userService.removeGameObjectFromPost(
                Integer.parseInt(gameObjectId), Integer.parseInt(postId));
        return "deleteGameObject";
    }

    @PostMapping("/post/{postId}/deleteGameObject/{gameObjectId}")
    public String deleteGameObjectFromPost(@PathVariable("postId") String postId) {
        return "redirect:/post/" + postId;
    }

    @GetMapping("/post/{postId}/deleteComment/{commentId}")
    public String deleteCommentFromPostPage(
            @PathVariable("postId") String postId,
            @PathVariable("commentId") String commentId) {
        userService.removeComment(Integer.parseInt(commentId));
        return "deleteComment";
    }

    @PostMapping("/post/{postId}/deleteComment/{commentId}")
    public String deleteCommentFromPost(
            @PathVariable("postId") String postId) {
        return "redirect:/post/" + postId;
    }

    @GetMapping("/posts/deletePost/{postId}")
    public String deletePostPage(@PathVariable("postId") String postId) {
        userService.removePost(Integer.parseInt(postId));
        return "deletePost";
    }

    @PostMapping("/posts/deletePost/{postId}")
    public String deletePost(@PathVariable("postId") String postId) {
        return "redirect:/posts";
    }

    @GetMapping("/dealer/{dealerId}/deletePost/{postId}")
    public String deletePostFromUserPage(
            @PathVariable("postId") String postId,
            @PathVariable("dealerId") String dealerId) {
        userService.removePost(Integer.parseInt(postId));
        return "deletePostFromUser";
    }

    @PostMapping("/dealer/{dealerId}/deletePost/{postId}")
    public String deletePostFromUser(
            @PathVariable("postId") String postId,
            @PathVariable("dealerId") String dealerId) {
        return "redirect:/dealer/" + dealerId;
    }

    @GetMapping("dealer/{dealerId}/delete")
    public String deleteUserPage(@PathVariable("dealerId") String dealerId) {
        userService.removeUser(Integer.parseInt(dealerId));
        return "deleteUser";
    }

    @PostMapping("dealer/{dealerId}/delete")
    public String deleteUser() {
        return "redirect:/";
    }

    @GetMapping("/dealer/{dealerId}/edit")
    public String editDealerPage(@PathVariable("dealerId") String dealerId) {
        return "editUser";
    }

    @PostMapping("/dealer/{dealerId}/edit")
    public String editUser(@PathVariable("dealerId") String dealerId,
                           @ModelAttribute("dealer") User dealer) {
        dealer.setId(Integer.parseInt(dealerId));
        userService.editUser(dealer);
        return "redirect:/dealer/" + dealerId;
    }

    @GetMapping("/post/{postId}/editComment/{commentId}")
    public String editCommentPage(@PathVariable("postId") String postId,
                                  @PathVariable("commentId") String commentId) {
        return "editComment";
    }

    @PostMapping("/post/{postId}/editComment/{commentId}")
    public String editComment(@PathVariable("postId") String postId,
                              @PathVariable("commentId") String commentId,
                              @ModelAttribute("comment") Comment comment) {
        comment.setId(Integer.parseInt(commentId));
        userService.editComment(comment);
        return "redirect:/post/" + postId;
    }
}
