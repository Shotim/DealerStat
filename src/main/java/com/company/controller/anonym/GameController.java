package com.company.controller.anonym;

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
@RequestMapping("/anonym/")
@AllArgsConstructor
public class GameController {

    private GameService gameService;

    private GameObjectService gameObjectService;

    @GetMapping("/games")
    public ModelAndView showGames() {

        return Controllers.viewGamesPage("anonym/showEntities/games", gameService);
    }

    @GetMapping("/games/{id}")
    public ModelAndView showGameWithId(@PathVariable("id") String id) {

        return Controllers.viewGameWithId("anonym/entity/game", id, gameService, gameObjectService);
    }
}
