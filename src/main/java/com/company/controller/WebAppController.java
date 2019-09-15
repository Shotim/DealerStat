package com.company.controller;

import com.company.entity.gameObject.GameObject;
import com.company.entity.gameObject.GameObjectStatus;
import com.company.entity.Post;
import com.company.entity.Comment;
import com.company.entity.Game;
import com.company.entity.user.Role;
import com.company.entity.user.User;
import com.company.service.comment.CommentService;
import com.company.service.game.GameService;
import com.company.service.gameobject.GameObjectService;
import com.company.service.post.PostService;
import com.company.service.user.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class WebAppController {

    public UserService userService;

    public CommentService commentService;

    public GameObjectService gameObjectService;

    public GameService gameService;

    public PostService postService;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("start/index");
        return modelAndView;
    }

    @GetMapping("/gameObjects")
    public ModelAndView gameObjects() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("showEntities/gameObjects");
        modelAndView.addObject("gameobjects",gameObjectService.findAllGameObjects());
        return modelAndView;
    }

    @GetMapping("/gameObject/{id}")
    public ModelAndView gameObject(@PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("entity/gameObject");
        modelAndView.addObject("gameobject",
                gameObjectService.findGameObject(Integer.parseInt(id)));
        return modelAndView;
    }

    @GetMapping("/games")
    public ModelAndView games() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("showEntities/games");
        modelAndView.addObject("games",
                gameService.findAllGames());
        return modelAndView;
    }

    @GetMapping("/game/{id}")
    public ModelAndView game(@PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("entity/game");
        modelAndView.addObject("game",
                gameService.findGame(Integer.parseInt(id)));
        modelAndView.addObject("gameobjects",
                gameObjectService.findGameObjectsOfGame(Integer.parseInt(id)));
        return modelAndView;
    }

    @GetMapping("/posts")
    public ModelAndView posts() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("showEntities/posts");
        modelAndView.addObject("posts",
                postService.findAllPosts());
        return modelAndView;
    }

    @GetMapping("/post/{id}")
    public ModelAndView post(@PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("entity/post");
        modelAndView.addObject("post",
                postService.findPost(Integer.parseInt(id)));
        modelAndView.addObject("gameobjects",
                gameObjectService.findGameObjectsFromPost(Integer.parseInt(id)));
        modelAndView.addObject("comments",
                commentService.findCommentsFromPost(Integer.parseInt(id)));
        return modelAndView;
    }

    @GetMapping("/post/{id}/newGameObjects")
    public ModelAndView gameObjectToPost(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addEntity/newGameObjects");
        modelAndView.addObject("games",
                gameService.findAllGames());
        modelAndView.addObject("id", id);
        return modelAndView;
    }

    @GetMapping("/dealers")
    public ModelAndView dealers() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("showEntities/dealers");
        modelAndView.addObject("users",
                userService.findAllUsers());
        return modelAndView;
    }

    @GetMapping("/dealer/{id}")
    public ModelAndView dealer(@PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("entity/dealer");
        modelAndView.addObject("dealer",
                userService.findUser(Integer.parseInt(id)));
        modelAndView.addObject("posts",
                postService.findPostsOfDealer(Integer.parseInt(id)));
        return modelAndView;
    }

    @GetMapping("/newDealer")
    public ModelAndView newDealerPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addEntity/newDealer");
        return modelAndView;
    }

    @PostMapping("/newDealer")
    public ModelAndView newDealer(@ModelAttribute("dealer") User dealer) {
        dealer.setRole(Role.DEALER);
        dealer.setCreatedAt(new Date(new java.util.Date().getTime()));
        dealer.setId(User.DEFAULT_ID);
        userService.addUser(dealer);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("redirect:/dealers");
        return modelAndView;
    }

    @GetMapping("/post/{postId}/newGameObjects/game/{gameId}")
    public ModelAndView gameForCreatePost(
            @PathVariable("gameId") String gameId,
            @PathVariable("postId") String postId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("entity/gameFromPost");
        modelAndView.addObject("game",
                gameService.findGame(Integer.parseInt(gameId)));
        modelAndView.addObject("gameobjects",
                gameObjectService.findGameObjectsOfGame(Integer.parseInt(gameId)));
        return modelAndView;
    }

    @GetMapping("/post/{id}/newGameObjects/newGame")
    public ModelAndView newGamePage(@PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addEntity/newGame");
        return modelAndView;
    }

    @PostMapping("/post/{id}/newGameObjects/newGame")
    public ModelAndView newGame(@PathVariable("id") String id,
                          @ModelAttribute("game") Game game) {
        game.setId(Game.DEFAULT_ID);
        gameService.addGame(game);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/post/" + id + "/newGameObjects");
        return modelAndView;
    }

    @GetMapping("/post/{postId}/newGameObjects/game/{gameId}/newGameObject")
    public ModelAndView newGameObjectPage(@PathVariable("postId") String postId,
                                    @PathVariable("gameId") String gameId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addEntity/newGameObject");
        return modelAndView;
    }

    @PostMapping("/post/{postId}/newGameObjects/game/{gameId}/newGameObject")
    public ModelAndView newGameObject(@PathVariable("postId") String postId,
                                @PathVariable("gameId") String gameId,
                                @ModelAttribute("gameobject") GameObject object) {
        object.setGameId(Integer.parseInt(gameId));
        object.setId(GameObject.DEFAULT_ID);
        object.setStatus(GameObjectStatus.IN_STOCK);
        object.setCreatedAt(new Date(new java.util.Date().getTime()));
        object.setUpdatedAt(object.getCreatedAt());
        gameObjectService.addGameObject(object);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("redirect:/post/" + postId + "/newGameObjects/game/" + gameId);
        return modelAndView;
    }

    @GetMapping("/post/{postId}/newGameObjects/game/{gameId}/newGameObject/{objectId}")
    public ModelAndView newGameObjectToPostPage(@PathVariable("postId") String postId,
                                          @PathVariable("objectId") String objectId,
                                          @PathVariable("gameId") String gameId) {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("addEntity/newGameObjectToPost");
        return modelAndView;
    }

    @PostMapping("/post/{postId}/newGameObjects/game/{gameId}/newGameObject/{objectId}")
    public ModelAndView gameObjectToPost(@PathVariable("postId") String postId,
                                   @PathVariable("objectId") String objectId) {
        gameObjectService.addGameObjectToPost(
                Integer.parseInt(objectId), Integer.parseInt(postId));
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("redirect:/post/"+postId);
        return modelAndView;
    }

    @GetMapping("/newDealer{id}post")
    public ModelAndView newPostPage(@PathVariable("id") String id) {
        postService.addPost(new Post(Post.DEFAULT_ID, Integer.parseInt(id)));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addEntity/newPost");
        return modelAndView;
    }

    @PostMapping("/newDealer{id}post")
    public ModelAndView newPost(@PathVariable("id")String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/dealer/"+id);
        return modelAndView;
    }

    @GetMapping("/post/{id}/newComment")
    public ModelAndView newCommentPage(@PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addEntity/newComment");
        return modelAndView;
    }

    @PostMapping("/post/{id}/newComment")
    public ModelAndView newComment(@PathVariable("id") String postId,
                             @ModelAttribute("comment") Comment comment) {
        comment.setId(Comment.DEFAULT_ID);
        comment.setPostId(Integer.parseInt(postId));
        comment.setCreatedAt(new Date(new java.util.Date().getTime()));
        comment.setApproved(false);
        commentService.addComment(comment);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect: /post/" + postId);
        return modelAndView;
    }

    @GetMapping("/post/{postId}/deleteGameObject/{gameObjectId}")
    public ModelAndView deleteGameObjectFromPostPage(
            @PathVariable("postId") String postId,
            @PathVariable("gameObjectId") String gameObjectId) {
        gameObjectService.removeGameObjectFromPost(
                Integer.parseInt(gameObjectId), Integer.parseInt(postId));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("deleteEntity/deleteGameObject");
        return modelAndView;
    }

    @PostMapping("/post/{postId}/deleteGameObject/{gameObjectId}")
    public ModelAndView deleteGameObjectFromPost(@PathVariable("postId") String postId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/post/" + postId);
        return modelAndView;
    }

    @GetMapping("/post/{postId}/deleteComment/{commentId}")
    public ModelAndView deleteCommentFromPostPage(
            @PathVariable("postId") String postId,
            @PathVariable("commentId") String commentId) {
        commentService.removeComment(Integer.parseInt(commentId));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("deleteEntity/deleteComment");
        return modelAndView;
    }

    @PostMapping("/post/{postId}/deleteComment/{commentId}")
    public ModelAndView deleteCommentFromPost(
            @PathVariable("postId") String postId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/post/" + postId);
        return modelAndView;
    }

    @GetMapping("/posts/deletePost/{postId}")
    public ModelAndView deletePostPage(@PathVariable("postId") String postId) {
        postService.removePost(Integer.parseInt(postId));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("deleteEntity/deletePost");
        return modelAndView;
    }

    @PostMapping("/posts/deletePost/{postId}")
    public ModelAndView deletePost(@PathVariable("postId") String postId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/posts");
        return modelAndView;
    }

    @GetMapping("/dealer/{dealerId}/deletePost/{postId}")
    public ModelAndView deletePostFromUserPage(
            @PathVariable("postId") String postId,
            @PathVariable("dealerId") String dealerId) {
        postService.removePost(Integer.parseInt(postId));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("deleteEntity/deletePostFromUser");
        return modelAndView;
    }

    @PostMapping("/dealer/{dealerId}/deletePost/{postId}")
    public ModelAndView deletePostFromUser(
            @PathVariable("postId") String postId,
            @PathVariable("dealerId") String dealerId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/dealer/" + dealerId);
        return modelAndView;
    }

    @GetMapping("dealer/{dealerId}/delete")
    public ModelAndView deleteUserPage(@PathVariable("dealerId") String dealerId) {
        userService.removeUser(Integer.parseInt(dealerId));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("deleteEntity/deleteUser");
        return modelAndView;
    }

    @PostMapping("dealer/{dealerId}/delete")
    public ModelAndView deleteUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @GetMapping("/dealer/{dealerId}/edit")
    public ModelAndView editDealerPage(@PathVariable("dealerId") String dealerId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editEntity/editUser");
        return modelAndView;
    }

    @PostMapping("/dealer/{dealerId}/edit")
    public ModelAndView editUser(@PathVariable("dealerId") String dealerId,
                           @ModelAttribute("dealer") User dealer) {
        dealer.setId(Integer.parseInt(dealerId));
        userService.editUser(dealer);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/dealer/" + dealerId);
        return modelAndView;
    }

    @GetMapping("/post/{postId}/editComment/{commentId}")
    public ModelAndView editCommentPage(@PathVariable("postId") String postId,
                                  @PathVariable("commentId") String commentId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editEntity/editComment");
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
