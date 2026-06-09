package com.smarthire.smarthire360.dto;

public class SkillSuggestion {

    private String skill;
    private String learningPath;

    public SkillSuggestion() {
    }

    public SkillSuggestion(
            String skill,
            String learningPath) {

        this.skill = skill;
        this.learningPath = learningPath;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getLearningPath() {
        return learningPath;
    }

    public void setLearningPath(
            String learningPath) {
        this.learningPath = learningPath;
    }
}