package com.company.controller.dealer;

import com.company.controller.ControllerUtility;
import com.company.entity.Comment;
import com.company.service.comment.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/id{dealerId}")
@AllArgsConstructor
public class DealerCommentController {

    private CommentService commentService;

    private ControllerUtility controllerUtility;

    @PutMapping("/posts/{postId}/comments/{commentId}")
    public ModelAndView editComment(
            @PathVariable("postId") String postId,
            @PathVariable("commentId") String commentId,
            @ModelAttribute("comment") Comment comment) {

        int dealerId = controllerUtility.sessionDealerId();
        comment.setId(Integer.parseInt(commentId));
        commentService.editComment(comment);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/id" + dealerId + "/post/" + postId);
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @PostMapping("/post/{id}/comment")
    public ModelAndView createComment(
            @PathVariable("id") String postId,
            @ModelAttribute("comment") Comment comment) {

        int dealerId = controllerUtility.sessionDealerId();
        controllerUtility.addDefaultComment(comment, postId, dealerId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect: /id" + dealerId + "/post/" + postId);
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public ModelAndView deleteCommentFromPost(
            @PathVariable("postId") String postId,
            @PathVariable("commentId") String commentId) {

        int dealerId = controllerUtility.sessionDealerId();
        commentService.removeComment(Integer.parseInt(commentId));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/id" + dealerId + "/post/" + postId);
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

}
