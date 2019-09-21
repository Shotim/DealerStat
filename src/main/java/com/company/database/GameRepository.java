package com.company.database;

import com.company.entity.Game;

import java.util.List;

public interface GameRepository {

    List<Game> getAllGames();

    Game getGame(int gameId);

    void addGame(Game game);
}
