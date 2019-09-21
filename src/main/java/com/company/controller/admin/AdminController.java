package com.company.controller.admin;

import com.company.controller.Controllers;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/")
@AllArgsConstructor
public class AdminController {

    @GetMapping("/")
    public ModelAndView index() {

        return Controllers.startPage("admin/start/index");
    }

}
