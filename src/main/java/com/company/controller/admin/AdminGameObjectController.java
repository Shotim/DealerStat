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
public class AdminGameObjectController {

    private ControllerUtility controllerUtility;

    @GetMapping("/gameObjects")
    public ModelAndView showGameObjects() {

        return controllerUtility.viewGameObjectsPage(
                "admin/showEntities/gameObjects");
    }

    @GetMapping("/gameObjects/{id}")
    public ModelAndView showGameObjectWithId(@PathVariable("id") String id) {

        return controllerUtility.viewGameObjectWithId(
                "admin/entity/gameObject", id);
    }
}
