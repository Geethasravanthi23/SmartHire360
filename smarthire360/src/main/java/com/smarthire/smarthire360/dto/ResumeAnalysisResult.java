package com.smarthire.smarthire360.dto;

import java.util.List;

public class ResumeAnalysisResult {

    private int score;

    private List<String> skills;

    private List<String> missingSkills;

    public ResumeAnalysisResult() {
    }

    public ResumeAnalysisResult(
            int score,
            List<String> skills,
            List<String> missingSkills) {

        this.score = score;
        this.skills = skills;
        this.missingSkills = missingSkills;
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

    public List<String> getMissingSkills() {
        return missingSkills;
    }

    public void setMissingSkills(
            List<String> missingSkills) {

        this.missingSkills = missingSkills;
    }
}