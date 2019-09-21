package com.company.controller.admin;

import com.company.controller.Controllers;
import com.company.service.post.PostService;
import com.company.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/")
@AllArgsConstructor
public class DealerController {

    private UserService userService;

    private PostService postService;

    @GetMapping("/dealers")
    public ModelAndView dealers() {

        return Controllers.viewDealersPage(
                "admin/showEntities/dealers", userService);
    }

    @GetMapping("/dealers/{id}")
    public ModelAndView dealer(@PathVariable("id") String id) {

        return Controllers.viewDealerWithId(
                "admin/entity/dealer", id, userService, postService);
    }
}
