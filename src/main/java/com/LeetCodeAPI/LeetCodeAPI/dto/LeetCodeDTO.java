package com.LeetCodeAPI.LeetCodeAPI.dto;

public class LeetCodeDTO {

    private String username;
    private int ranking;
    private int totalSolved;
    private int easySolved;
    private int mediumSolved;
    private int hardSolved;

    public LeetCodeDTO(){};
    public LeetCodeDTO(String username, int ranking, int totalSolved, int easySolved, int mediumSolved, int hardSolved) {
        this.username = username;
        this.ranking = ranking;
        this.totalSolved = totalSolved;
        this.easySolved = easySolved;
        this.mediumSolved = mediumSolved;
        this.hardSolved = hardSolved;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getTotalSolved() {
        return totalSolved;
    }

    public void setTotalSolved(int totalSolved) {
        this.totalSolved = totalSolved;
    }

    public int getEasySolved() {
        return easySolved;
    }

    public void setEasySolved(int easySolved) {
        this.easySolved = easySolved;
    }

    public int getMediumSolved() {
        return mediumSolved;
    }

    public void setMediumSolved(int mediumSolved) {
        this.mediumSolved = mediumSolved;
    }

    public int getHardSolved() {
        return hardSolved;
    }

    public void setHardSolved(int hardSolved) {
        this.hardSolved = hardSolved;
    }
}
