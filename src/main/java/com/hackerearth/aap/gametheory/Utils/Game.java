package com.hackerearth.aap.gametheory.Utils;

import com.hackerearth.aap.gametheory.dto.GameResponse;
import com.hackerearth.aap.gametheory.dto.Score;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@ToString
@Component
@SessionScope
public class Game {

    private static final Logger LOGGER = LoggerFactory.getLogger(Game.class);

    private int iteration;
    private Score[] scores;

    public Score updateScore(Score score){
        LOGGER.debug("#Game #updateScore previous iteration: {}",iteration);
        Score pvS = scores[iteration];
        LOGGER.info("#Game #updateScore previous iteration: {}, score: {}",iteration,pvS);
        try{
            //increment iteration and add previous score to current score to save the total score in the scores array
            iteration++;
            scores[iteration]=new Score(pvS.getApiScore()+score.getApiScore(),
                    pvS.getUserScore()+score.getUserScore());
        } catch (ArrayIndexOutOfBoundsException ex){
            //catch when trying to apply a move grater than requested
            iteration--;
            int availableMoves = iteration;
            Score finalScore = scores[availableMoves];
            LOGGER.error("#Game #updateScore No moved left, Number of valid moves: {}",availableMoves);
            LOGGER.info("#Game #updateScore Returning final result: {}, score: {}",availableMoves, finalScore);
            return finalScore;
        } catch (NullPointerException ex){
            //catch when request for move was called ahead of defining number of moves
            iteration--;
            Score nullScore = new Score(0, 0);
            LOGGER.error("#Game #updateScore Iterations not present so No moves available returning {}",nullScore);
            return nullScore;
        }
        LOGGER.info("#Game #updateScore current iteration: {}, score: {}",iteration,scores[iteration]);
        return scores[iteration];
    }

    public Game() {
        this.iteration=0;
        this.scores = new Score[255];
        LOGGER.debug("#Game Default constructor");
    }

    public Game(int iteration) {
        LOGGER.debug("#Game Args constructor for {} iterations",iteration);
        this.iteration = 0; //set iteration to 0
        this.scores = new Score[iteration+1];   //create scores array with size of iteration requested.
        this.scores[this.iteration]=new Score(0,0); //0th score will be (0,0)
    }

    public GameResponse getLatestScore() {
        Score latestScore = scores[iteration]; //get last score based on iteration value
        if (latestScore==null){
            //when called ahead of defining number of moves
            latestScore = new Score(0, 0);
            LOGGER.error("#Game #getLatestScore latest score unavailable returning default: {}",latestScore);
        }
        LOGGER.debug("#Game #getLatestScore Get latest score {}, iteration : {}",latestScore,iteration);
        return new GameResponse(iteration, latestScore);
    }
}
