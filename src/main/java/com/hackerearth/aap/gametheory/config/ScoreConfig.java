package com.hackerearth.aap.gametheory.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties("scores")
public class ScoreConfig {
    //Score when both cooperate
    private int dd;
    //score when both cheat
    private int ee;
    //score when one cheat and one cooperate map of Move and score value
    private Map<String, Integer> de;

    @Override
    public String toString() {
        return "ScoreConfig{" +
                "dd=" + dd +
                ", dc=" + ee +
                ", de=" + de +
                '}';
    }

    public int getDd() {
        return dd;
    }

    public void setDd(int dd) {
        this.dd = dd;
    }

    public int getEe() {
        return ee;
    }

    public void setEe(int ee) {
        this.ee = ee;
    }

    public Map<String, Integer> getDe() {
        return de;
    }

    public void setDe(Map<String, Integer> de) {
        this.de = de;
    }
}
