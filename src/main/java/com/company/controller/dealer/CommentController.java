package com.company.controller.dealer;

import com.company.controller.Controllers;
import com.company.entity.Comment;
import com.company.service.comment.CommentService;
import com.company.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/id{dealerId}")
@AllArgsConstructor
public class CommentController {

    private UserService userService;

    private CommentService commentService;

    @PutMapping("/posts/{postId}/comments/{commentId}")
    public ModelAndView editComment(@PathVariable("postId") String postId,
                                    @PathVariable("commentId") String commentId,
                                    @ModelAttribute("comment") Comment comment) {

        int dealerId = Controllers.sessionDealerId(userService);
        comment.setId(Integer.parseInt(commentId));
        commentService.editComment(comment);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/id" + dealerId + "/post/" + postId);
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @PostMapping("/post/{id}/comment")
    public ModelAndView createComment(@PathVariable("id") String postId,
                                      @ModelAttribute("comment") Comment comment) {

        int dealerId = Controllers.sessionDealerId(userService);
        Controllers.addDefaultComment(comment, postId, dealerId, commentService);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect: /id" + dealerId + "/post/" + postId);
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public ModelAndView deleteCommentFromPost(
            @PathVariable("postId") String postId,
            @PathVariable("commentId") String commentId) {

        int dealerId = Controllers.sessionDealerId(userService);
        commentService.removeComment(Integer.parseInt(commentId));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/id" + dealerId + "/post/" + postId);
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

}
