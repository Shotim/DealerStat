package com.company.controller;

import com.company.entity.Comment;
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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;

@Controller
@RequestMapping("/my")
@AllArgsConstructor
public class DealerController {

    private UserService userService;

    private CommentService commentService;

    private GameObjectService gameObjectService;

    private GameService gameService;

    private PostService postService;

    private PasswordEncoder encoder;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dealer/start/index");
        return modelAndView;
    }

    @GetMapping("/profile")
    public ModelAndView dealer() {

        int dealerId = userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dealer/entity/profile");
        modelAndView.addObject("dealer",
                userService.findUser(dealerId));
        modelAndView.addObject("posts",
                postService.findPostsOfDealer(dealerId));
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }


    @GetMapping("/gameObjects")
    public ModelAndView gameObjects() {

        int dealerId = userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dealer/showEntities/gameObjects");
        modelAndView.addObject("gameobjects", gameObjectService.findAllGameObjects());
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @GetMapping("/gameObject/{id}")
    public ModelAndView gameObject(@PathVariable("id") String id) {

        int dealerId = userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dealer/entity/gameObject");
        modelAndView.addObject("gameobject",
                gameObjectService.findGameObject(Integer.parseInt(id)));
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @GetMapping("/games")
    public ModelAndView games() {

        int dealerId = userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dealer/showEntities/games");
        modelAndView.addObject("games",
                gameService.findAllGames());
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @GetMapping("/game/{id}")
    public ModelAndView game(@PathVariable("id") String id) {

        int dealerId = userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dealer/entity/game");
        modelAndView.addObject("game",
                gameService.findGame(Integer.parseInt(id)));
        modelAndView.addObject("gameobjects",
                gameObjectService.findGameObjectsOfGame(Integer.parseInt(id)));
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @GetMapping("/posts")
    public ModelAndView posts() {

        int dealerId = userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dealer/showEntities/posts");
        modelAndView.addObject("posts",
                postService.findAllPosts());
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @GetMapping("/post/{id}")
    public ModelAndView Post(@PathVariable("id") String id) {

        int dealerId = userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        return post(dealerId, id, "post");
    }

    @GetMapping("/profile/post/{id}")
    public ModelAndView myPost(@PathVariable("id") String id) {

        int dealerId = userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        return post(dealerId, id, "myPost");
    }

    public ModelAndView post(int dealerId, String postId, String file) {
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

    @GetMapping("/profile/post/{id}/newGameObjects")
    public ModelAndView gameObjectToPost(@PathVariable("id") int id) {

        int dealerId = userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dealer/addEntity/newGameObjects");
        modelAndView.addObject("games",
                gameService.findAllGames());
        modelAndView.addObject("id", id);
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @GetMapping("/dealers")
    public ModelAndView dealers() {

        int dealerId = userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dealer/showEntities/dealers");
        modelAndView.addObject("users",
                userService.findAllUsers());
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @GetMapping("/dealer/{id}")
    public ModelAndView dealer(@PathVariable("id") String id) {

        int dealerId = userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dealer/entity/dealer");
        modelAndView.addObject("dealerId", dealerId);
        modelAndView.addObject("dealer", userService.findUser(Integer.parseInt(id)));
        modelAndView.addObject(("posts"), postService.findPostsOfDealer(Integer.parseInt(id)));
        return modelAndView;
    }

    @GetMapping("/profile/post/{postId}/newGameObjects/game/{gameId}")
    public ModelAndView gameForCreatePost(
            @PathVariable("gameId") String gameId,
            @PathVariable("postId") String postId) {
        ModelAndView modelAndView = new ModelAndView();
        int dealerId = userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        modelAndView.setViewName("dealer/entity/gameFromPost");
        modelAndView.addObject("game",
                gameService.findGame(Integer.parseInt(gameId)));
        modelAndView.addObject("gameobjects",
                gameObjectService.findGameObjectsOfGame(Integer.parseInt(gameId)));
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @GetMapping("/profile/post/{id}/newGameObjects/newGame")
    public ModelAndView newGame(@PathVariable("id") String id) {

        int dealerId = userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dealer/addEntity/newGame");
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @PostMapping("/profile/post/{id}/newGameObjects/newGame")
    public ModelAndView newGame(@PathVariable("id") String id,
                                @ModelAttribute("game") Game game) {

        int dealerId = userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        game.setId(Game.DEFAULT_ID);
        gameService.addGame(game);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/my/profile/post/" + id + "/newGameObjects");
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @GetMapping("/profile/post/{postId}/newGameObjects/game/{gameId}/newGameObject")
    public ModelAndView newGameObject(@PathVariable("postId") String postId,
                                      @PathVariable("gameId") String gameId) {

        int dealerId = userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dealer/addEntity/newGameObject");
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @PostMapping("/profile/post/{postId}/newGameObjects/game/{gameId}/newGameObject")
    public ModelAndView newGameObject(@PathVariable("postId") String postId,
                                      @PathVariable("gameId") String gameId,
                                      @ModelAttribute("gameobject") GameObject object) {

        int dealerId = userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        object.setGameId(Integer.parseInt(gameId));
        object.setId(GameObject.DEFAULT_ID);
        object.setStatus(GameObjectStatus.IN_STOCK);
        object.setCreatedAt(new Date(new java.util.Date().getTime()));
        object.setUpdatedAt(object.getCreatedAt());
        gameObjectService.addGameObject(object);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/my/profile/post/" + postId + "/newGameObjects/game/" + gameId);
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @GetMapping("/profile/post/{postId}/newGameObjects/game/{gameId}/newGameObject/{objectId}")
    public ModelAndView newGameObjectToPost(@PathVariable("postId") String postId,
                                            @PathVariable("objectId") String objectId,
                                            @PathVariable("gameId") String gameId) {

        int dealerId = userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dealer/addEntity/newGameObjectToPost");
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @PostMapping("/profile/post/{postId}/newGameObjects/game/{gameId}/newGameObject/{objectId}")
    public ModelAndView gameObjectToPost(@PathVariable("postId") String postId,
                                         @PathVariable("objectId") String objectId) {

        int dealerId = userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        gameObjectService.addGameObjectToPost(
                Integer.parseInt(objectId), Integer.parseInt(postId));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/my/profile/post/" + postId);
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @GetMapping("/profile/newPost")
    public ModelAndView newPost() {

        int dealerId = userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        postService.addPost(new Post(Post.DEFAULT_ID, dealerId));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dealer/addEntity/newPost");
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @PostMapping("/profile/newPost")
    public ModelAndView newPost(Model model) {

        int dealerId = userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/my/profile");
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @GetMapping("/post/{id}/newComment")
    public ModelAndView newComment(@PathVariable("id") String id) {

        int dealerId = userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dealer/addEntity/newComment");
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @PostMapping("/post/{id}/newComment")
    public ModelAndView newComment(@PathVariable("id") String postId,
                                   @ModelAttribute("comment") Comment comment) {

        int dealerId = userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        comment.setAuthorId(dealerId);
        comment.setId(Comment.DEFAULT_ID);
        comment.setPostId(Integer.parseInt(postId));
        comment.setCreatedAt(new Date(new java.util.Date().getTime()));
        comment.setApproved(false);
        commentService.addComment(comment);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect: /my/post/" + postId);
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @GetMapping("profile/post/{postId}/deleteGameObject/{gameObjectId}")
    public ModelAndView deleteGameObjectFromPost(
            @PathVariable("postId") String postId,
            @PathVariable("gameObjectId") String gameObjectId) {

        int dealerId = userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        gameObjectService.removeGameObjectFromPost(
                Integer.parseInt(gameObjectId), Integer.parseInt(postId));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dealer/deleteEntity/deleteGameObject");
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @PostMapping("profile/post/{postId}/deleteGameObject/{gameObjectId}")
    public ModelAndView deleteGameObjectFromPost(@PathVariable("postId") String postId) {

        int dealerId = userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/my/profile/post/" + postId);
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @GetMapping("/post/{postId}/deleteComment/{commentId}")
    public ModelAndView deleteCommentFromPost(
            @PathVariable("postId") String postId,
            @PathVariable("commentId") String commentId) {

        int dealerId = userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        commentService.removeComment(Integer.parseInt(commentId));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dealer/deleteEntity/deleteComment");
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @PostMapping("/post/{postId}/deleteComment/{commentId}")
    public ModelAndView deleteCommentFromPost(
            @PathVariable("postId") String postId) {

        int dealerId = userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/my/post/" + postId);
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @GetMapping("/profile/deletePost/{postId}")
    public ModelAndView deletePostFromUser(
            @PathVariable("postId") String postId) {

        int dealerId = userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        postService.removePost(Integer.parseInt(postId));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dealer/deleteEntity/deletePostFromUser");
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @PostMapping("/profile/deletePost/{postId}")
    public ModelAndView deletePostFromUser(
            @PathVariable("postId") String postId,
            Model model) {

        int dealerId = userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/my/profile");
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @GetMapping("/profile/edit")
    public ModelAndView editDealer() {

        int dealerId = userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dealer/editEntity/editUser");
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @PostMapping("/profile/edit")
    public ModelAndView editUser(@ModelAttribute("dealer") User dealer) {

        int dealerId = userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        dealer.setId(dealerId);
        dealer.setPassword(encoder.encode(dealer.getPassword()));
        userService.editUser(dealer);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/my/profile");
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @GetMapping("/post/{postId}/editComment/{commentId}")
    public ModelAndView editComment(@PathVariable("postId") String postId,
                                    @PathVariable("commentId") String commentId) {

        int dealerId = userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dealer/editEntity/editComment");
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @PostMapping("/post/{postId}/editComment/{commentId}")
    public ModelAndView editComment(@PathVariable("postId") String postId,
                                    @PathVariable("commentId") String commentId,
                                    @ModelAttribute("comment") Comment comment) {

        int dealerId = userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        comment.setId(Integer.parseInt(commentId));
        commentService.editComment(comment);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/my/post/" + postId);
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }
}
