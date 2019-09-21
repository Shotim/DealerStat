package com.company.database;

import com.company.entity.Game;
import com.company.mapper.GameMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class GameRepositoryImpl implements GameRepository {

    private static final String INSERT_NEW_GAME = "INSERT INTO games (name)VALUES (?)";
    private static final String SELECT_GAME_WITH_ID = "SELECT * FROM games WHERE id=?";
    private static final String SELECT_ALL_GAMES = "SELECT * FROM games";
    


    public final JdbcTemplate jdbcTemplate;

    @Override
    public List<Game> getAllGames() {
        return jdbcTemplate.query(SELECT_ALL_GAMES,
                new GameMapper());
    }

    @Override
    public Game getGame(int gameId) {
        return jdbcTemplate.queryForObject(SELECT_GAME_WITH_ID,
                new GameMapper(), gameId);
    }

    @Override
    public void addGame(Game game) {
        jdbcTemplate.update(INSERT_NEW_GAME,
                game.getName());
    }
}
