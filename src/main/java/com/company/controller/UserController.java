package com.company.controller;

import com.company.database.DataBaseServiceImpl;
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
                userService.findGameObjects(
                        DataBaseServiceImpl.SELECT_ALL_GAMEOBJECTS));
        return "gameObjects";
    }

    @GetMapping("/gameObject/{id}")
    public String gameObject(@PathVariable("id") String id, Model model) {
        model.addAttribute("gameobject",
                userService.findGameObjects(
                        DataBaseServiceImpl.SELECT_GAMEOBJECT_WITH_ID + id));
        return "gameObject";
    }

    @GetMapping("/games")
    public String games(Model model) {
        model.addAttribute("games",
                userService.findGames(DataBaseServiceImpl.SELECT_ALL_GAMES));
        return "games";
    }

    @GetMapping("/game/{id}")
    public String game(@PathVariable("id") String id, Model model) {
        model.addAttribute("game",
                userService.findGames(
                        DataBaseServiceImpl.SELECT_GAME_WITH_ID + id));
        model.addAttribute("gameobjects",
                userService.findGameObjects(
                        DataBaseServiceImpl.SELECT_ALL_GAMEOBJECTS_WITH_GAME_ID + id));
        return "game";
    }

    @GetMapping("/posts")
    public String posts(Model model) {
        model.addAttribute("posts",
                userService.findPosts(DataBaseServiceImpl.SELECT_ALL_POSTS));
        return "posts";
    }

    @GetMapping("/post/{id}")
    public String post(@PathVariable("id") String id, Model model) {
        model.addAttribute("post",
                userService.findPosts(
                        DataBaseServiceImpl.SELECT_POST_WITH_ID + id));
        model.addAttribute("gameobjects",
                userService.findGameObjects(
                        DataBaseServiceImpl.SELECT_ALL_GAMEOBJECTS_FROM_POST_WITH_ID + id));
        return "post";
    }

    @GetMapping("/post/{id}/newGameObjects")
    public String gameObjectToPost(@PathVariable("id") int id, Model model) {
        model.addAttribute("games",
                userService.findGames(
                        DataBaseServiceImpl.SELECT_ALL_GAMES));
        model.addAttribute("id", id);
        return "newGameObjects";
    }

    @GetMapping("/dealers")
    public String dealers(Model model) {
        model.addAttribute("users",
                userService.findUsers(DataBaseServiceImpl.SELECT_ALL_USERS));
        return "dealers";
    }

    @GetMapping("/dealer/{id}")
    public String dealer(@PathVariable("id") String id, Model model) {
        model.addAttribute("dealer",
                userService.findUsers(DataBaseServiceImpl.SELECT_USER_WITH_ID + id));
        model.addAttribute("posts",
                userService.findPosts(DataBaseServiceImpl.SELECT_ALL_POSTS_WITH_DEALER_ID + id));
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

    @GetMapping("/comment/{id}")
    public String comment(@PathVariable("id") String id, Model model) {
        model.addAttribute("comment",
                userService.findComments(
                        DataBaseServiceImpl.SELECT_COMMENT_WITH_ID + id));
        return "comment";
    }

    @GetMapping("/post/{postId}/newGameObjects/game/{gameId}")
    public String gameForCreatePost(
            @PathVariable("gameId") String gameId, Model model,
            @PathVariable("postId") String postId) {
        model.addAttribute("game",
                userService.findGames(
                        DataBaseServiceImpl.SELECT_GAME_WITH_ID + gameId));
        model.addAttribute("gameobjects",
                userService.findGameObjects(
                        DataBaseServiceImpl.SELECT_ALL_GAMEOBJECTS_WITH_GAME_ID + gameId));
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
        userService.addGameObjectToPost(Integer.parseInt(objectId), Integer.parseInt(postId));
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
}
