package com.hackerearth.aap.gametheory.services.impl;

import com.hackerearth.aap.gametheory.Utils.Game;
import com.hackerearth.aap.gametheory.Utils.GameUtil;
import com.hackerearth.aap.gametheory.dto.GameRequest;
import com.hackerearth.aap.gametheory.dto.GameResponse;
import com.hackerearth.aap.gametheory.dto.Moves;
import com.hackerearth.aap.gametheory.dto.Score;
import com.hackerearth.aap.gametheory.services.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoveService implements GameService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DoveService.class);

    @Autowired
    private Game game;

    @Autowired
    private GameUtil gameUtil;

    @Override
    public GameResponse makeMove(GameRequest gameRequest) {
        Moves move = gameRequest.getMove();
        LOGGER.info("#DoveService #makeMove Got move from user: {}",move);
        Score score = gameUtil.generateScore(Moves.D, move);
        LOGGER.info("#DoveService #makeMove generated score: {}",score);
        Score updatedScore = game.updateScore(score);
        LOGGER.info("#DoveService #makeMove updated score: {}",updatedScore);
        return game.getLatestScore();
    }

    @Override
    public GameResponse startGame(GameRequest gameRequest) {
        LOGGER.info("#DoveService #startGame Creating game for {} iterations",gameRequest.getIterations());
        game = new Game(gameRequest.getIterations());
        LOGGER.debug("#DoveService #startGame game:{} latest score: {}",game,game.getLatestScore());
        return game.getLatestScore();
    }
}
