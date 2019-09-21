package com.company.controller.admin;

import com.company.controller.ControllerUtility;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/")
@AllArgsConstructor
public class AdminController {

    private ControllerUtility controllerUtility;

    @GetMapping("/")
    public ModelAndView index() {

        return controllerUtility.startPage("admin/start/index");
    }

}
