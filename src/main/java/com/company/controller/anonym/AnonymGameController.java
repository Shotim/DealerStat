package com.company.controller.anonym;

import com.company.controller.ControllerUtility;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/anonym/")
@AllArgsConstructor
public class AnonymGameController {

    private ControllerUtility controllerUtility;

    @GetMapping("/games")
    public ModelAndView showGames() {

        return controllerUtility.viewGamesPage(
                "anonym/showEntities/games");
    }

    @GetMapping("/games/{id}")
    public ModelAndView showGameWithId(@PathVariable("id") String id) {

        return controllerUtility.viewGameWithId(
                "anonym/entity/game", id);
    }
}
