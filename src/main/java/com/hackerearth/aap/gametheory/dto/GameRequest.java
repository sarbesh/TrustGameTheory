package com.hackerearth.aap.gametheory.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GameRequest {

    @JsonProperty("Iterations")
    private int iterations;
    @JsonProperty("Move")
    private Moves move;

    public int getIterations() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

    public Moves getMove() {
        return move;
    }

    public void setMove(Moves move) {
        this.move = move;
    }
}
