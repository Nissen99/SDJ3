package shared;

import com.google.gson.Gson;

import java.io.Serializable;

public class FootballScore implements Serializable {

    private String homeTeam;
    private String awayTeam;
    private int[] score = new int[2];

    public FootballScore(String homeTeam, String awayTeam, int[] score) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.score = score;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int[] getScore() {
        return score;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public void setScore(int[] score) {
        this.score = score;
    }

    public String toString(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}


