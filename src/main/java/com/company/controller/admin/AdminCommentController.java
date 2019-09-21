package com.company.controller.admin;

import com.company.service.comment.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/")
@AllArgsConstructor
public class AdminCommentController {

    private CommentService commentService;

    @GetMapping("/unapprovedComments")
    public ModelAndView showUnapprovedComments() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/showEntities/unapprovedComments");
        modelAndView.addObject("comments",
                commentService.findUnapprovedComments());
        return modelAndView;
    }

    @PutMapping("/unapprovedComments/{id}")
    public ModelAndView approveComment(@PathVariable("id") String id, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin/unapprovedComments");
        commentService.approveComment(Integer.parseInt(id));
        return modelAndView;
    }
}
