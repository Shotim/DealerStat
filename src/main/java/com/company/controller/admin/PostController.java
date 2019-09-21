package com.company.controller.admin;

import com.company.controller.Controllers;
import com.company.service.comment.CommentService;
import com.company.service.gameobject.GameObjectService;
import com.company.service.post.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/")
@AllArgsConstructor
public class PostController {

    private PostService postService;

    private GameObjectService gameObjectService;

    private CommentService commentService;

    @GetMapping("/posts")
    public ModelAndView showPosts() {

        return Controllers.viewPostsPage("admin/showEntities/posts",postService);
    }

    @GetMapping("/posts/{id}")
    public ModelAndView showPostWithId(@PathVariable("id") String id) {

        return Controllers.viewPostWithId("admin/entity/post",id,postService,gameObjectService,commentService);
    }
}