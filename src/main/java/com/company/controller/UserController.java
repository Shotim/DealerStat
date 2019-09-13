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

    @GetMapping("/showgameobjects")
    public String showGameObjects(Model model) {
        model.addAttribute("gameobjects",
                userService.findGameObjects(
                        DataBaseServiceImpl.SELECT_ALL_GAMEOBJECTS));
        return "showgameobjects";
    }

    @GetMapping("/gameobject/{id}")
    public String showGameObject(@PathVariable("id") String id, Model model) {
        model.addAttribute("gameobject",
                userService.findGameObjects(
                        DataBaseServiceImpl.SELECT_GAMEOBJECT_WITH_ID + id));
        return "gameobject";
    }

    @PostMapping("/addgameobject")
    public String addGameObject(@ModelAttribute("gameobject") GameObject gameObject) {
        userService.addGameObject(gameObject);
        return "redirect:../";
    }

    @GetMapping("/showgames")
    public String showGames(Model model) {
        model.addAttribute("games",
                userService.findGames(DataBaseServiceImpl.SELECT_ALL_GAMES));
        return "showgames";
    }

    @GetMapping("/game/{id}")
    public String showGame(@PathVariable("id") String id, Model model) {
        model.addAttribute("game",
                userService.findGames(
                        DataBaseServiceImpl.SELECT_GAME_WITH_ID + id));
        model.addAttribute("gameobjects",
                userService.findGameObjects(
                        DataBaseServiceImpl.SELECT_ALL_GAMEOBJECTS_WITH_GAME_ID + id));
        return "game";
    }

    @PostMapping("/addgame")
    public String addGame(@ModelAttribute("game") Game game) {
        userService.addGame(game);
        return "redirect:../";
    }

    @GetMapping("/showposts")
    public String showPosts(Model model) {
        model.addAttribute("posts",
                userService.findPosts(DataBaseServiceImpl.SELECT_ALL_POSTS));
        return "showposts";
    }

    @GetMapping("/post/{id}")
    public String showPost(@PathVariable("id") String id, Model model) {
        model.addAttribute("post",
                userService.findPosts(
                        DataBaseServiceImpl.SELECT_POST_WITH_ID + id));
        model.addAttribute("gameobjects",
                userService.findGameObjects(
                        DataBaseServiceImpl.SELECT_ALL_GAMEOBJECTS_FROM_POST_WITH_ID + id));
        return "post";
    }

    @GetMapping("/post/{id}/addgameobjects")
    public String addGameObjectToPost(@PathVariable("id") int id, Model model) {
        model.addAttribute("games",
                userService.findGames(
                        DataBaseServiceImpl.SELECT_ALL_GAMES));
        model.addAttribute("id", id);
        return "addgameobjects";
    }

    @GetMapping("/showdealers")
    public String showDealers(Model model) {
        model.addAttribute("users",
                userService.findUsers(DataBaseServiceImpl.SELECT_ALL_USERS));
        return "showdealers";
    }

    @GetMapping("/dealer/{id}")
    public String showDealer(@PathVariable("id") String id, Model model) {
        model.addAttribute("dealer",
                userService.findUsers(DataBaseServiceImpl.SELECT_USER_WITH_ID + id));
        model.addAttribute("posts",
                userService.findPosts(DataBaseServiceImpl.SELECT_ALL_POSTS_WITH_DEALER_ID + id));
        return "dealer";
    }

    @GetMapping("/adddealer")
    public String addDealerPage() {
        return "adddealer";
    }

    @PostMapping("/adddealer")
    public String addDealer(@ModelAttribute("dealer") User dealer) {
        dealer.setRole(Role.DEALER);
        dealer.setCreatedAt(new Date(new java.util.Date().getTime()));
        dealer.setId(User.DEFAULT_ID);
        userService.addUser(dealer);
        return "redirect:/showdealers";
    }

    @GetMapping("/comment/{id}")
    public String showComment(@PathVariable("id") String id, Model model) {
        model.addAttribute("comment",
                userService.findComments(
                        DataBaseServiceImpl.SELECT_COMMENT_WITH_ID + id));
        return "comment";
    }

    @PostMapping("/addcomment")
    public String addComment(@ModelAttribute("comment") Comment comment) {
        userService.addComment(comment);
        return "redirect:../";
    }

    @GetMapping("/post/{postId}/addgameobjects/showgame/{gameId}")
    public String showGameForCreatePost(
            @PathVariable("gameId") String gameId, Model model,
            @PathVariable("postId") String postId) {
        model.addAttribute("game",
                userService.findGames(
                        DataBaseServiceImpl.SELECT_GAME_WITH_ID + gameId));
        model.addAttribute("gameobjects",
                userService.findGameObjects(
                        DataBaseServiceImpl.SELECT_ALL_GAMEOBJECTS_WITH_GAME_ID + gameId));
        return "gamefrompost";
    }

    @GetMapping("/post/{id}/addgameobjects/addnewgame")
    public String addNewGamePage() {
        return "addnewgame";
    }

    @PostMapping("/post/{id}/addgameobjects/addnewgame")
    public String addNewGame(@PathVariable("id") String id,
                             @ModelAttribute("game") Game game) {
        game.setId(Game.DEFAULT_ID);
        userService.addGame(game);
        return "redirect:/post/" + id + "/addgameobjects";
    }

    @GetMapping("/post/{postId}/addgameobjects/showgame/{gameId}/addnewgameobject")
    public String addNewGameObjectPage() {
        return "addnewgameobject";
    }

    @PostMapping("/post/{postId}/addgameobjects/showgame/{gameId}/addnewgameobject")
    public String addNewGameObject(@PathVariable("postId") String postId,
                                   @PathVariable("gameId") String gameId,
                                   @ModelAttribute("gameobject") GameObject object) {
        object.setGameId(Integer.parseInt(gameId));
        object.setId(GameObject.DEFAULT_ID);
        object.setStatus(GameObjectStatus.IN_STOCK);
        object.setCreatedAt(new Date(new java.util.Date().getTime()));
        object.setUpdatedAt(object.getCreatedAt());
        userService.addGameObject(object);
        return "redirect:/post/" + postId + "/addgameobjects/showgame/" + gameId;
    }

    @GetMapping("/post/{postId}/addgameobjects/showgame/{gameId}/addgameobject/{objectId}")
    public String addGameObjectToPostPage(@PathVariable("postId") String postId,
                                          @PathVariable("objectId") String objectId,
                                          @PathVariable("gameId") String gameId) {
        userService.addGameObjectToPost(Integer.parseInt(objectId), Integer.parseInt(postId));
        return "addgameobjecttopost";
    }

    @PostMapping("/post/{postId}/addgameobjects/showgame/{gameId}/addgameobject/{objectId}")
    public String addGameObjectToPost(@PathVariable("postId") String postId,
                                      @PathVariable("objectId") String objectId) {
        return "redirect:/post/{postId}";
    }

    @GetMapping("/adddealer{id}post")
    public String addPostPage(@PathVariable("id") String id) {
        userService.addPost(new Post(Post.DEFAULT_ID, Integer.parseInt(id)));
        return "addpost";
    }

    @PostMapping("/adddealer{id}post")
    public String addPost() {
        return "redirect:/dealer/{id}";
    }
}
