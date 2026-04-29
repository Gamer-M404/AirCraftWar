package edu.hitsz.dao;

public class LeaderBoradItem {
        private String username;
        private int score;
        private String time;

    public LeaderBoradItem(String username, int score, String time) {
        this.username = username;
        this.score = score;
        this.time = time;
    }

    public String showInfo(){
        return (this.username + "," + this.score + "," + this.time);
    }

    public int getScore(){
        return this.score;
    }
}
