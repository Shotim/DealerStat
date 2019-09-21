package com.company.controller.dealer;

import com.company.controller.Controllers;
import com.company.entity.Game;
import com.company.entity.Post;
import com.company.entity.gameObject.GameObject;
import com.company.entity.gameObject.GameObjectStatus;
import com.company.entity.user.User;
import com.company.service.comment.CommentService;
import com.company.service.game.GameService;
import com.company.service.gameobject.GameObjectService;
import com.company.service.post.PostService;
import com.company.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;

@Controller
@RequestMapping("/id{dealerId}")
@AllArgsConstructor
public class ProfileController {

    private UserService userService;

    private CommentService commentService;

    private GameObjectService gameObjectService;

    private GameService gameService;

    private PostService postService;

    private PasswordEncoder encoder;

    @GetMapping("/")
    public ModelAndView index() {

        return Controllers.startPage("dealer/start/index");
    }

    @GetMapping("/profile")
    public ModelAndView showDealersProfile() {

        Integer dealerId = Controllers.sessionDealerId(userService);
        ModelAndView modelAndView = Controllers.viewDealerWithId(
                "dealer/entity/profile", dealerId.toString(), userService, postService);
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @PutMapping("/profile")
    public ModelAndView editUser(@ModelAttribute("dealer") User dealer) {

        int dealerId = Controllers.sessionDealerId(userService);
        dealer.setId(dealerId);
        dealer.setPassword(encoder.encode(dealer.getPassword()));
        userService.editUser(dealer);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/id" + dealerId + "/profile");
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @PostMapping("/profile/post")
    public ModelAndView createPost(Model model) {

        int dealerId = Controllers.sessionDealerId(userService);
        postService.addPost(new Post(Post.DEFAULT_ID, dealerId));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/id" + dealerId + "/profile");
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @GetMapping("/profile/posts/{postId}")
    public ModelAndView showDealersPost(@PathVariable("postId") String postId) {

        int dealerId = Controllers.sessionDealerId(userService);
        ModelAndView modelAndView = Controllers.viewPostWithId(
                "dealer/entity/post", postId, postService, gameObjectService, commentService);
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @DeleteMapping("/profile/posts/{postId}")
    public ModelAndView deletePostFromUser(
            @PathVariable("postId") String postId,
            Model model) {

        int dealerId = Controllers.sessionDealerId(userService);
        postService.removePost(Integer.parseInt(postId));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/id" + dealerId + "/profile");
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @GetMapping("/profile/posts/{postId}/gameObjects")
    public ModelAndView addGameObjectToPost(@PathVariable("postId") int id) {

        int dealerId = Controllers.sessionDealerId(userService);
        ModelAndView modelAndView = Controllers.viewGamesPage(
                "dealer/addEntity/newGameObjects", gameService);
        modelAndView.addObject("id", id);
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @GetMapping("/profile/post/{postId}/gameObjects/games/{gameId}")
    public ModelAndView addGameWhileCreatingPost(
            @PathVariable("gameId") String gameId,
            @PathVariable("postId") String postId) {
        int dealerId = Controllers.sessionDealerId(userService);
        ModelAndView modelAndView = Controllers.viewGameWithId(
                "dealer/entity/gameFromPost", gameId, gameService, gameObjectService);
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @GetMapping("/profile/posts/{postId}/gameObjects/game")
    public ModelAndView createGame(@PathVariable("postId") String id) {

        int dealerId = Controllers.sessionDealerId(userService);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dealer/addEntity/newGame");
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @PostMapping("/profile/posts/{postId}/gameObjects/game")
    public ModelAndView createGame(@PathVariable("postId") String postId,
                                   @ModelAttribute("game") Game game) {

        int dealerId = Controllers.sessionDealerId(userService);
        game.setId(Game.DEFAULT_ID);
        gameService.addGame(game);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/id" + dealerId +
                "/profile/post/" + postId + "/newGameObjects");
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @GetMapping("/profile/posts/{postId}/gameObjects/game/{gameId}/gameObject")
    public ModelAndView createGameObject(@PathVariable("postId") String postId,
                                         @PathVariable("gameId") String gameId) {

        int dealerId = Controllers.sessionDealerId(userService);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dealer/addEntity/newGameObject");
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @PostMapping("/profile/posts/{postId}/gameObjects/game/{gameId}/gameObject")
    public ModelAndView createGameObject(@PathVariable("postId") String postId,
                                         @PathVariable("gameId") String gameId,
                                         @ModelAttribute("gameobject") GameObject object) {

        int dealerId = Controllers.sessionDealerId(userService);
        object.setGameId(Integer.parseInt(gameId));
        object.setId(GameObject.DEFAULT_ID);
        object.setStatus(GameObjectStatus.IN_STOCK);
        object.setCreatedAt(new Date(new java.util.Date().getTime()));
        object.setUpdatedAt(object.getCreatedAt());
        gameObjectService.addGameObject(object);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/id" + dealerId +
                "/profile/post/" + postId + "/newGameObjects/game/" + gameId);
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @GetMapping("/profile/posts/{postId}/gameObjects/game/{gameId}/gameObjects/{objectId}")
    public ModelAndView createGameObjectToPost(@PathVariable("postId") String postId,
                                               @PathVariable("objectId") String objectId,
                                               @PathVariable("gameId") String gameId) {

        int dealerId = Controllers.sessionDealerId(userService);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dealer/addEntity/newGameObjectToPost");
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @PostMapping("/profile/posts/{postId}/gameObjects/game/{gameId}/gameObjects/{objectId}")
    public ModelAndView createGameObjectToPost(@PathVariable("postId") String postId,
                                               @PathVariable("objectId") String objectId) {

        int dealerId = Controllers.sessionDealerId(userService);
        gameObjectService.addGameObjectToPost(
                Integer.parseInt(objectId), Integer.parseInt(postId));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/id" + dealerId + "/profile/post/" + postId);
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @GetMapping("profile/posts/{postId}/gameObjects/{gameObjectId}")
    public ModelAndView deleteGameObjectFromPost(
            @PathVariable("postId") String postId) {

        int dealerId = Controllers.sessionDealerId(userService);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dealer/deleteEntity/deleteGameObject");
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @DeleteMapping("profile/posts/{postId}/gameObjects/{gameObjectId}")
    public ModelAndView deleteGameObjectFromPost(@PathVariable("postId") String postId,
                                                 @PathVariable("gameObjectId") String gameObjectId) {

        int dealerId = Controllers.sessionDealerId(userService);
        gameObjectService.removeGameObjectFromPost(
                Integer.parseInt(gameObjectId), Integer.parseInt(postId));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/id" + dealerId + "/profile/post/" + postId);
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }
}
