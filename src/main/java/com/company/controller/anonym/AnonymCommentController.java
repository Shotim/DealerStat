package com.company.controller.anonym;

import com.company.controller.ControllerUtility;
import com.company.entity.Comment;
import com.company.service.comment.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/anonym/")
@AllArgsConstructor
public class AnonymCommentController {

    private CommentService commentService;

    private ControllerUtility controllerUtility;

    @PostMapping("/posts/{id}/comment")
    public ModelAndView createComment(@PathVariable("id") String postId,
                                      @ModelAttribute("comment") Comment comment) {

        controllerUtility.addDefaultComment(comment, postId, Comment.DEFAULT_ID);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect: /anonym/posts/" + postId);
        return modelAndView;
    }

    @PostMapping("/posts/{postId}/comments/{commentId}")
    public ModelAndView editComment(@PathVariable("postId") String postId,
                                    @PathVariable("commentId") String commentId,
                                    @ModelAttribute("comment") Comment comment) {
        comment.setId(Integer.parseInt(commentId));
        commentService.editComment(comment);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/anonym/posts/" + postId);
        return modelAndView;
    }
}
