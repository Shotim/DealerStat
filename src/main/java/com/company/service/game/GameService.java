package com.company.service.game;

import com.company.entity.Game;

import java.util.List;

public interface GameService {

    List<Game> findAllGames();

    Game findGame(int gameId);

    void addGame(Game game);
}
