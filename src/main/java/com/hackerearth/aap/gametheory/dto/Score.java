package com.hackerearth.aap.gametheory.dto;

public class Score {
    private int apiScore=0;
    private int UserScore=0;

    @Override
    public String toString() {
        return "Score{" +
                "apiScore=" + apiScore +
                ", UserScore=" + UserScore +
                '}';
    }

    public Score() {
    }

    public int getApiScore() {
        return apiScore;
    }

    public void setApiScore(int apiScore) {
        this.apiScore = apiScore;
    }

    public int getUserScore() {
        return UserScore;
    }

    public void setUserScore(int userScore) {
        UserScore = userScore;
    }

    public Score(int apiScore, int userScore) {
        this.apiScore = apiScore;
        UserScore = userScore;
    }
}
