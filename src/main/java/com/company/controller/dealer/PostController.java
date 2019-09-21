package com.company.controller.dealer;

import com.company.controller.Controllers;
import com.company.service.comment.CommentService;
import com.company.service.gameobject.GameObjectService;
import com.company.service.post.PostService;
import com.company.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/id{dealerId}")
@AllArgsConstructor
public class PostController {

    private UserService userService;

    private PostService postService;

    private GameObjectService gameObjectService;

    private CommentService commentService;


    @GetMapping("/posts")
    public ModelAndView showPosts() {

        int dealerId = Controllers.sessionDealerId(userService);
        ModelAndView modelAndView = Controllers.viewPostsPage(
                "dealer/showEntities/posts", postService);
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @GetMapping("/posts/{id}")
    public ModelAndView showPostWithId(@PathVariable("id") String id) {

        int dealerId = Controllers.sessionDealerId(userService);
        ModelAndView modelAndView = Controllers.viewPostWithId(
                "dealer/entity/post", id, postService, gameObjectService, commentService);
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }
}
