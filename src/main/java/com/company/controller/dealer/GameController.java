package com.company.controller.dealer;

import com.company.controller.Controllers;
import com.company.service.game.GameService;
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
public class GameController {

    private UserService userService;

    private GameService gameService;

    private GameObjectService gameObjectService;

    @GetMapping("/games")
    public ModelAndView showGames() {

        int dealerId = Controllers.sessionDealerId(userService);
        ModelAndView modelAndView = Controllers.viewGamesPage(
                "dealer/showEntities/games", gameService);
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @GetMapping("/games/{id}")
    public ModelAndView showGameWithId(@PathVariable("id") String id) {

        int dealerId = Controllers.sessionDealerId(userService);
        ModelAndView modelAndView = Controllers.viewGameWithId(
                "dealer/entity/game", id, gameService, gameObjectService);
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }
}
