package com.company.controller.admin;

import com.company.controller.ControllerUtility;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/")
@AllArgsConstructor
public class AdminPostController {

    private ControllerUtility controllerUtility;

    @GetMapping("/posts")
    public ModelAndView showPosts() {

        return controllerUtility.viewPostsPage(
                "admin/showEntities/posts");
    }

    @GetMapping("/posts/{id}")
    public ModelAndView showPostWithId(@PathVariable("id") String id) {

        return controllerUtility.viewPostWithId(
                "admin/entity/post", id);
    }
}
