package com.company.controller;

import com.company.entity.user.Role;
import com.company.entity.user.User;
import com.company.service.user.UserService;
import com.company.validation.WebAppValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

@Controller
@RequestMapping("/")
public class WebAppController {

    @Autowired
    public UserService userService;

    @Autowired
    public WebAppValidator validator;

    @Autowired
    public UserDetailsService userDetailsService;

    @GetMapping("/login")
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {
        ModelAndView modelAndView = new ModelAndView();
        String errorMessage = null;
        if (error != null) {
            errorMessage = "Username or Password is incorrect";
        }
        if (logout != null) {
            errorMessage = "Logged out successfully";
        }
        modelAndView.setViewName("start/login");
        modelAndView.addObject("errorMessage", errorMessage);
        return modelAndView;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
        String view = null;
        if (user.getPassword().equals(userDetails.getPassword())) {
            User u = userService.findUser(user.getEmail());
            if ("DEALER".equals(u.getRole().name())) {
                view = "redirect:/my" + u.getId();
            } else {
                view = "redirect:/admin";
            }
        } else {
            view = "redirect:/login";
        }
        return view;
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/login?logout=true");
        return modelAndView;
    }

    @GetMapping("/signUp")
    public ModelAndView signUp() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("start/signUp");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/signUp")
    public ModelAndView signUp(@ModelAttribute("user") User user, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        validator.validate(user, result);
        if (result.hasErrors()) {
            modelAndView.setViewName("start/signUp");
            return modelAndView;
        }
        user.setId(User.DEFAULT_ID);
        user.setRole(Role.DEALER);
        user.setCreatedAt(new Date(new java.util.Date().getTime()));
        userService.addUser(user);
        modelAndView.setViewName("redirect:/my" + userService.findUser(user.getEmail()));
        return modelAndView;
    }
}
