package com.company.controller.anonym;

import com.company.controller.Controllers;
import com.company.service.gameobject.GameObjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/anonym/")
@AllArgsConstructor
public class GameObjectController {

    private GameObjectService gameObjectService;

    @GetMapping("/gameObjects")
    public ModelAndView showGameObjects() {

        return Controllers.viewGameObjectsPage("anonym/showEntities/gameObjects", gameObjectService);
    }

    @GetMapping("/gameObjects/{id}")
    public ModelAndView showGameObjectWithId(@PathVariable("id") String id) {

        return Controllers.viewGameObjectWithId("anonym/entity/gameObject", id, gameObjectService);
    }
}
