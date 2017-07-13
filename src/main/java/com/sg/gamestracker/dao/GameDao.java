/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.gamestracker.dao;

import com.sg.gamestracker.model.Game;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface GameDao {
    
    Game createGame (Game game);
    Game editGame(Game game);
    Game deleteGame(long id);
    List<Game> getAllGames();
    Game getGame(long id);
    
}
