package com.company.controller.admin;

import com.company.controller.ControllerUtility;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/")
@AllArgsConstructor
public class AdminGameController {

    private ControllerUtility controllerUtility;

    @GetMapping("/games")
    public ModelAndView showGames() {

        return controllerUtility.viewGamesPage(
                "admin/showEntities/games");
    }

    @GetMapping("/games/{id}")
    public ModelAndView showGameWithId(@PathVariable("id") String id) {

        return controllerUtility.viewGameWithId(
                "admin/entity/game", id);
    }
}
