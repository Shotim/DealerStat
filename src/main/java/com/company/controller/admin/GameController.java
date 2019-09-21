package com.company.controller.admin;

import com.company.controller.Controllers;
import com.company.service.game.GameService;
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
public class GameController {

    private GameService gameService;

    private GameObjectService gameObjectService;

    @GetMapping("/games")
    public ModelAndView games() {

        return Controllers.viewGamesPage("admin/showEntities/games", gameService);
    }

    @GetMapping("/games/{id}")
    public ModelAndView game(@PathVariable("id") String id) {

        return Controllers.viewGameWithId("admin/entity/game", id, gameService, gameObjectService);
    }
}
