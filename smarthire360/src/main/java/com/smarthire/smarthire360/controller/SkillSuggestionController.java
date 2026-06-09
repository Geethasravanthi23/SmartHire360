package com.smarthire.smarthire360.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.smarthire.smarthire360.dto.SkillSuggestion;

@RestController
@RequestMapping("/skills")
@CrossOrigin(origins = "http://localhost:5173")
public class SkillSuggestionController {

    @GetMapping
    public List<SkillSuggestion> getSkills() {

        List<SkillSuggestion> skills =
                new ArrayList<>();

        skills.add(
                new SkillSuggestion(
                        "Spring Boot",
                        "Build REST APIs"));

        skills.add(
                new SkillSuggestion(
                        "React",
                        "Frontend Development"));

        skills.add(
                new SkillSuggestion(
                        "AWS",
                        "Cloud Deployment"));

        skills.add(
                new SkillSuggestion(
                        "Docker",
                        "Containerization"));

        skills.add(
                new SkillSuggestion(
                        "Microservices",
                        "Enterprise Applications"));

        return skills;
    }
}