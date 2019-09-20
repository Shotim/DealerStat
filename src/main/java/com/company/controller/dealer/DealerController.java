package com.company.controller.dealer;

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
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dealer/showEntities/dealers");
        modelAndView.addObject("users",
                userService.findAllUsers());
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @GetMapping("/dealers/{id}")
    public ModelAndView showDealerWithId(@PathVariable("id") String id) {

        int dealerId = sessionDealerId(userService);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dealer/entity/dealer");
        modelAndView.addObject("dealerId", dealerId);
        modelAndView.addObject("dealer", userService.findUser(Integer.parseInt(id)));
        modelAndView.addObject("posts", postService.findPostsOfDealer(Integer.parseInt(id)));
        return modelAndView;
    }
}
