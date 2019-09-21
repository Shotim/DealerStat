package com.company.controller.dealer;

import com.company.controller.Controllers;
import com.company.service.gameobject.GameObjectService;
import com.company.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/id{dealerId}")
@AllArgsConstructor
public class GameObjectController {

    private UserService userService;

    private GameObjectService gameObjectService;

    @GetMapping("/gameObjects")
    public ModelAndView showGameObjects() {

        int dealerId = Controllers.sessionDealerId(userService);
        ModelAndView modelAndView = Controllers.viewGameObjectsPage("dealer/showEntities/gameObjects",gameObjectService);
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @GetMapping("/gameObjects/{id}")
    public ModelAndView showGameObjectWithId(@PathVariable("id") String id) {

        int dealerId = Controllers.sessionDealerId(userService);
        ModelAndView modelAndView = Controllers.viewGameObjectWithId("dealer/entity/gameObject",id,gameObjectService);
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }
}
