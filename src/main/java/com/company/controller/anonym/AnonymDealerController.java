package com.company.controller.anonym;

import com.company.controller.ControllerUtility;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/anonym/")
@AllArgsConstructor
public class AnonymDealerController {

    private ControllerUtility controllerUtility;

    @GetMapping("/dealers")
    public ModelAndView showDealers() {

        return controllerUtility.viewDealersPage(
                "anonym/showEntities/dealers");
    }

    @GetMapping("/dealers/{id}")
    public ModelAndView showDealerWithId(@PathVariable("id") String id) {

        return controllerUtility.viewDealerWithId(
                "anonym/entity/dealer", id);
    }
}
