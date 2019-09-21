package com.company.controller.admin;

import com.company.controller.ControllerUtility;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/")
@AllArgsConstructor
public class AdminDealerController {

    private ControllerUtility controllerUtility;

    @GetMapping("/dealers")
    public ModelAndView showDealers() {

        return controllerUtility.viewDealersPage(
                "admin/showEntities/dealers");
    }

    @GetMapping("/dealers/{id}")
    public ModelAndView showDealerWithId(@PathVariable("id") String id) {

        return controllerUtility.viewDealerWithId(
                "admin/entity/dealer", id);
    }
}
