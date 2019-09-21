package com.company.controller.anonym;

import com.company.controller.ControllerUtility;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/anonym/")
@AllArgsConstructor
public class AnonymPostController {

    private ControllerUtility controllerUtility;

    @GetMapping("/posts")
    public ModelAndView showPosts() {

        return controllerUtility.viewPostsPage(
                "anonym/showEntities/posts");
    }

    @GetMapping("/posts/{id}")
    public ModelAndView showPostWithId(@PathVariable("id") String id) {

        return controllerUtility.viewPostWithId(
                "anonym/entity/post", id);
    }
}
