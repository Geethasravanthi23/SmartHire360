package com.smarthire.smarthire360.dto;

import java.util.List;

public class ATSResult {

    private int score;
    private List<String> skills;

    public ATSResult() {
    }

    public ATSResult(int score, List<String> skills) {
        this.score = score;
        this.skills = skills;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
}