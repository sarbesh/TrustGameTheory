package com.hackerearth.aap.gametheory.Utils;

import com.hackerearth.aap.gametheory.config.ScoreConfig;
import com.hackerearth.aap.gametheory.dto.Moves;
import com.hackerearth.aap.gametheory.dto.Score;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameUtil {

    @Autowired
    private ScoreConfig scoreConfig;

    private static final Logger LOGGER = LoggerFactory.getLogger(GameUtil.class);

    public Score generateScore(Moves apiMove, Moves userMove){
        LOGGER.info("#GameUtil scoreConfig: {}",scoreConfig);
        Score sc = new Score();
        LOGGER.info("#GameUtil ApiMove: {}, UserMove: {}",apiMove,userMove);
        if(apiMove==Moves.D && userMove==Moves.D){
            sc.setApiScore(scoreConfig.getDd());
            sc.setUserScore(scoreConfig.getDd());
        } else if(apiMove!=userMove){
            sc.setApiScore(scoreConfig.getDe().get(apiMove.toString()));
            sc.setUserScore(scoreConfig.getDe().get(userMove.toString()));
        } else{
            sc.setApiScore(scoreConfig.getEe());
            sc.setUserScore(scoreConfig.getEe());
        }
        LOGGER.info("#GameUtil Score: {}",sc);
        return sc;
    }
}
