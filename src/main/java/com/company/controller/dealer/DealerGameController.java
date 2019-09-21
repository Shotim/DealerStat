package com.company.controller.dealer;

import com.company.controller.ControllerUtility;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/id{dealerId}")
@AllArgsConstructor
public class DealerGameController {

    private ControllerUtility controllerUtility;

    @GetMapping("/games")
    public ModelAndView showGames() {

        int dealerId = controllerUtility.sessionDealerId();
        ModelAndView modelAndView = controllerUtility.viewGamesPage(
                "dealer/showEntities/games");
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @GetMapping("/games/{id}")
    public ModelAndView showGameWithId(@PathVariable("id") String id) {

        int dealerId = controllerUtility.sessionDealerId();
        ModelAndView modelAndView = controllerUtility.viewGameWithId(
                "dealer/entity/game", id);
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }
}
