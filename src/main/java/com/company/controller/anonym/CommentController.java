package com.company.controller.anonym;

import com.company.controller.Controllers;
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
public class CommentController {

    private CommentService commentService;

    @PostMapping("/posts/{id}/comment")
    public ModelAndView createComment(@PathVariable("id") String postId,
                                      @ModelAttribute("comment") Comment comment) {

        Controllers.addDefaultComment(comment, postId, Comment.DEFAULT_ID, commentService);
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
        modelAndView.setViewName("redirect:/posts/" + postId);
        return modelAndView;
    }
}
