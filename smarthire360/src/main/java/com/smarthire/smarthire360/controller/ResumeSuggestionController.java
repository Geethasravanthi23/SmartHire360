package com.smarthire.smarthire360.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.smarthire.smarthire360.dto.ResumeSuggestionResult;
import com.smarthire.smarthire360.service.ResumeSuggestionService;

@RestController
@RequestMapping("/resume-suggestions")
@CrossOrigin(origins = "http://localhost:5173")
public class ResumeSuggestionController {

    @Autowired
    private ResumeSuggestionService resumeSuggestionService;

    @PostMapping
    public ResumeSuggestionResult getSuggestions() {

        List<String> missingSkills = Arrays.asList(
                "Docker",
                "AWS",
                "Microservices"
        );

        List<String> suggestions =
                resumeSuggestionService
                        .getSuggestions(missingSkills);

        return new ResumeSuggestionResult(
                suggestions);
    }
}
