package com.hackerearth.aap.gametheory.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@ToString
public class GameResponse {
    @JsonProperty("Iteration")
    private int iterations;
    @JsonProperty("API score")
    private int apiScore;
    @JsonProperty("User score")
    private int userScore;

    public GameResponse(int iteration, Score score) {
        this.iterations=iteration;
        this.apiScore=score.getApiScore();
        this.userScore=score.getUserScore();
    }

    public int getIterations() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

    public int getApiScore() {
        return apiScore;
    }

    public void setApiScore(int apiScore) {
        this.apiScore = apiScore;
    }

    public int getUserScore() {
        return userScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    public GameResponse(int iterations, int apiScore, int userScore) {
        this.iterations = iterations;
        this.apiScore = apiScore;
        this.userScore = userScore;
    }
}
