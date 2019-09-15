package com.company.service.game;

import com.company.database.DataBaseService;
import com.company.entity.Game;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GameServiceImpl implements GameService{

    public DataBaseService dataBaseService;

    @Override
    public List<Game> findAllGames() {
        return dataBaseService.getAllGames();
    }

    @Override
    public Game findGame(int gameId) {
        return dataBaseService.getGame(gameId);
    }

    @Override
    public void addGame(Game game) {
        dataBaseService.addGame(game);
    }
}
