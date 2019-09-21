package com.company.service.game;

import com.company.database.GameRepository;
import com.company.entity.Game;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GameServiceImpl implements GameService{
    
    public GameRepository gameRepository;

    @Override
    public List<Game> findAllGames() {
        return gameRepository.getAllGames();
    }

    @Override
    public Game findGame(int gameId) {
        return gameRepository.getGame(gameId);
    }

    @Override
    public void addGame(Game game) {
        gameRepository.addGame(game);
    }
}
