package com.company.controller.dealer;

import com.company.service.gameobject.GameObjectService;
import com.company.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
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

        int dealerId = userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dealer/showEntities/gameObjects");
        modelAndView.addObject("gameobjects", gameObjectService.findAllGameObjects());
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @GetMapping("/gameObjects/{id}")
    public ModelAndView showGameObjectWithId(@PathVariable("id") String id) {

        int dealerId = userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dealer/entity/gameObject");
        modelAndView.addObject("gameobject",
                gameObjectService.findGameObject(Integer.parseInt(id)));
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }
}
