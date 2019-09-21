package com.company.controller.admin;

import com.company.controller.Controllers;
import com.company.service.gameobject.GameObjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/")
@AllArgsConstructor
public class GameObjectController {

    private GameObjectService gameObjectService;

    @GetMapping("/gameObjects")
    public ModelAndView gameObjects() {

        return Controllers.viewGameObjectsPage("admin/showEntities/gameObjects", gameObjectService);
    }

    @GetMapping("/gameObjects/{id}")
    public ModelAndView gameObject(@PathVariable("id") String id) {

        return Controllers.viewGameObjectWithId("admin/entity/gameObject",id,gameObjectService);
    }
}
