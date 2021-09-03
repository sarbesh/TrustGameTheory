package com.hackerearth.aap.gametheory.controller;

import com.hackerearth.aap.gametheory.dto.GameRequest;
import com.hackerearth.aap.gametheory.dto.GameResponse;
import com.hackerearth.aap.gametheory.services.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class GameController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GameController.class);

    @Autowired
    private GameService doveService;

    @Autowired
    private GameService eagleService;

    @Autowired
    private GameService autoService;

    @PostMapping("/dove")
    public GameResponse doveController(@RequestBody GameRequest gameRequest){
        long start = System.currentTimeMillis();
        LOGGER.info("#doveController Received Request: {}",gameRequest);
        GameResponse gameResponse;
        if(gameRequest.getMove()==null && gameRequest.getIterations()!=0)
            gameResponse = doveService.startGame(gameRequest);
        else if (gameRequest.getMove()!=null && gameRequest.getIterations()==0)
            gameResponse = doveService.makeMove(gameRequest);
        else
            gameResponse= new GameResponse();
        LOGGER.info("#doveController METRICS: {}",System.currentTimeMillis()-start);
        return gameResponse;
    }

    @PostMapping("/eagle")
    public GameResponse eagleController(@RequestBody GameRequest gameRequest){
        long start = System.currentTimeMillis();
        LOGGER.info("#eagleController Received Request: {}",gameRequest);
        GameResponse gameResponse;
        if(gameRequest.getMove()==null && gameRequest.getIterations()!=0)
            gameResponse = eagleService.startGame(gameRequest);
        else if (gameRequest.getMove()!=null && gameRequest.getIterations()==0)
            gameResponse = eagleService.makeMove(gameRequest);
        else
            gameResponse= new GameResponse();
        LOGGER.info("#eagleController METRICS: {}",System.currentTimeMillis()-start);
        return gameResponse;
    }

    @PostMapping("/auto")
    public GameResponse autoController(@RequestBody GameRequest gameRequest){
        long start = System.currentTimeMillis();
        LOGGER.info("#autoController Received Request: {}",gameRequest);
        GameResponse gameResponse;
        if(gameRequest.getMove()==null && gameRequest.getIterations()!=0)
            gameResponse = autoService.startGame(gameRequest);
        else if (gameRequest.getMove()!=null && gameRequest.getIterations()==0)
            gameResponse = autoService.makeMove(gameRequest);
        else
            gameResponse= new GameResponse();
        LOGGER.info("#autoController METRICS: {}",System.currentTimeMillis()-start);
        return gameResponse;
    }

}
