/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.gamestracker.dao;

import com.sg.gamestracker.model.Game;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public class GameDaoMemImpl implements GameDao{

    Map<Long, Game> games = new HashMap<>();
    
    public GameDaoMemImpl() {
        Game game= new Game("Sonic", "Sega", "Platformer", 1998);
        game.setId(1);
        games.put(game.getId(), game);
    }
    
    @Override
    public Game createGame(Game game) {
        long id = 1;
        for(long l: games.keySet()){
            if(l > id) {
                id = l;
            }
        }
        id++;
        game.setId(id);
        games.put(id, game);
        return game;
    }

    @Override
    public Game editGame(Game game) {
        games.put(game.getId(), game);
        return game;
    }

    @Override
    public Game deleteGame(long id) {
        return games.remove(id);
    }

    @Override
    public List<Game> getAllGames() {
        return new ArrayList<>(games.values());
    }

    @Override
    public Game getGame(long id) {
        return games.get(id);
    }
    
}
