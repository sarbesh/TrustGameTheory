package com.hackerearth.aap.gametheory.services;

import com.hackerearth.aap.gametheory.dto.GameRequest;
import com.hackerearth.aap.gametheory.dto.GameResponse;
import org.springframework.stereotype.Service;

@Service
public interface GameService {
    GameResponse makeMove(GameRequest gameRequest);
    GameResponse startGame(GameRequest gameRequest);
}
