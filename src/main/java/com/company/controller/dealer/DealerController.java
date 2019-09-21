package com.company.controller.dealer;

import com.company.controller.Controllers;
import com.company.service.post.PostService;
import com.company.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static com.company.controller.Controllers.sessionDealerId;

@Controller
@RequestMapping("/id{dealerId}")
@AllArgsConstructor
public class DealerController {

    private UserService userService;

    private PostService postService;

    @GetMapping("/dealers")
    public ModelAndView showDealers() {

        int dealerId = sessionDealerId(userService);
        ModelAndView modelAndView = Controllers.viewDealersPage(
                "dealer/showEntities/dealers", userService);
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @GetMapping("/dealers/{id}")
    public ModelAndView showDealerWithId(@PathVariable("id") String id) {

        int dealerId = sessionDealerId(userService);
        ModelAndView modelAndView = Controllers.viewDealerWithId(
                "dealer/entity/dealer", id, userService, postService);
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }
}
