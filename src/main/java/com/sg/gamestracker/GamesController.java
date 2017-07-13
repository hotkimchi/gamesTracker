/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.gamestracker;

import com.sg.gamestracker.dao.GameDao;
import com.sg.gamestracker.model.Game;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class GamesController {
    
    GameDao games;
    
    @Inject
    public GamesController(GameDao gamesDao) {
        games = gamesDao;
    }
    
    @RequestMapping(value = "/addGame", method = RequestMethod.POST)
    public String addGame(String name, String publisher, String genre, Integer releaseYear) {
        Game game = new Game(name, publisher, genre, releaseYear);
        games.createGame(game);
        return "redirect:/";
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        
        model.addAttribute("games", games.getAllGames());
        return "index";
    }
    
    @RequestMapping(value = "/deleteGame", method=RequestMethod.POST)
    public String deleteGame(Long gameId){
        games.deleteGame(gameId);
        return "redirect:/";
    }
    
    @RequestMapping(value = "/editGame", method = RequestMethod.GET)
    public String editGame(Long id, Model model){
        Game game = games.getGame(id);
        model.addAttribute("game", game);
        return "editGame";
    }
    
    @RequestMapping(value = "/editGame", method = RequestMethod.POST)
    public String editGamePage(@ModelAttribute Game game){
        games.editGame(game);
        return "redirect:/";
    }
}
