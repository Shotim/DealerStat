package com.company.controller.dealer;

import com.company.controller.ControllerUtility;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/id{dealerId}")
@AllArgsConstructor
public class DealerGameObjectController {

    private ControllerUtility controllerUtility;

    @GetMapping("/gameObjects")
    public ModelAndView showGameObjects() {

        int dealerId = controllerUtility.sessionDealerId();
        ModelAndView modelAndView = controllerUtility.viewGameObjectsPage(
                "dealer/showEntities/gameObjects");
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @GetMapping("/gameObjects/{id}")
    public ModelAndView showGameObjectWithId(@PathVariable("id") String id) {

        int dealerId = controllerUtility.sessionDealerId();
        ModelAndView modelAndView = controllerUtility.viewGameObjectWithId(
                "dealer/entity/gameObject", id);
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }
}
