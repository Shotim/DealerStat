package com.company.controller.dealer;

import com.company.service.game.GameService;
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
public class GameController {

    private UserService userService;

    private GameService gameService;

    private GameObjectService gameObjectService;

    @GetMapping("/games")
    public ModelAndView showGames() {

        int dealerId = userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dealer/showEntities/games");
        modelAndView.addObject("games",
                gameService.findAllGames());
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @GetMapping("/games/{id}")
    public ModelAndView showGameWithId(@PathVariable("id") String id) {

        int dealerId = userService.findUser(
                SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dealer/entity/game");
        modelAndView.addObject("game",
                gameService.findGame(Integer.parseInt(id)));
        modelAndView.addObject("gameobjects",
                gameObjectService.findGameObjectsOfGame(Integer.parseInt(id)));
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }
}
