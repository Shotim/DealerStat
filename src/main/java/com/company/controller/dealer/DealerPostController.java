package com.company.controller.dealer;

import com.company.controller.ControllerUtility;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/id{dealerId}")
@AllArgsConstructor
public class DealerPostController {

    private ControllerUtility controllerUtility;

    @GetMapping("/posts")
    public ModelAndView showPosts() {

        int dealerId = controllerUtility.sessionDealerId();
        ModelAndView modelAndView = controllerUtility.viewPostsPage(
                "dealer/showEntities/posts");
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @GetMapping("/posts/{id}")
    public ModelAndView showPostWithId(@PathVariable("id") String id) {

        int dealerId = controllerUtility.sessionDealerId();
        ModelAndView modelAndView = controllerUtility.viewPostWithId(
                "dealer/entity/post", id);
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }
}
