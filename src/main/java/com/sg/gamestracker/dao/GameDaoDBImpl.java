/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.gamestracker.dao;

import com.sg.gamestracker.model.Game;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class GameDaoDBImpl implements GameDao{
    
    private static final String SELECT_ALL_GAMES = "SELECT * FROM game";
    private static final String SELECT_GAME_BY_ID = "SELECT * FROM game WHERE ID = ?";
    private static final String DELETE_GAME = "DELETE FROM game WHERE ID = ?";
    private final String INSERT_GAME = "INSERT INTO game (name, publisher, genre, release_year) "
            +"VALUES (?,?,?,?)";
    private static final String UPDATE_GAME = "UPDATE game SET name = ?, publisher = ?, genre = ?, release_year = ? "
            +"WHERE id = ?";
    
    JdbcTemplate jdbcT;
    
    @Inject
    public GameDaoDBImpl (JdbcTemplate jdbcT) {
        this.jdbcT = jdbcT;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Game createGame(Game game) {
        jdbcT.update(INSERT_GAME, game.getName(), game.getPublisher(), game.getGenre(), game.getReleaseYear());
        int gameId = jdbcT.queryForObject("SELECT lAST_INSERT_ID()", Integer.class);
        return getGame(gameId);
    }

    @Override
    public Game editGame(Game game) {
        jdbcT.update(UPDATE_GAME, game.getName(), game.getPublisher(), game.getGenre(), game.getReleaseYear(), game.getId());
        return getGame(game.getId());
    }

    @Override
    public Game deleteGame(long id) {
        Game game = getGame(id);
        jdbcT.update(DELETE_GAME, id);
        return game;
    }

    @Override
    public List<Game> getAllGames() {
        return jdbcT.query(SELECT_ALL_GAMES, new GameMapper());
    }

    @Override
    public Game getGame(long id) {
        return jdbcT.queryForObject(SELECT_GAME_BY_ID, new GameMapper(), id);
    }
    
    private static final class GameMapper implements RowMapper<Game>{

        @Override
        public Game mapRow(ResultSet rs, int i) throws SQLException {
            Game game = new Game();
            game.setId(rs.getLong("id"));
            game.setName(rs.getString("name"));
            game.setPublisher(rs.getString("publisher"));
            game.setGenre(rs.getString("genre"));
            game.setReleaseYear(rs.getInt("release_year"));
            
            return game;
        }
        
    }
    
}
