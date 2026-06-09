package com.smarthire.smarthire360.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.smarthire.smarthire360.dto.SuggestionResult;
import com.smarthire.smarthire360.service.SuggestionService;

@RestController
@RequestMapping("/suggestions")
@CrossOrigin(origins = "http://localhost:5173")
public class SuggestionController {

    @Autowired
    private SuggestionService suggestionService;

    @PostMapping
    public SuggestionResult getSuggestions(
            @RequestBody List<String> missingSkills) {

        return new SuggestionResult(
                suggestionService.generateSuggestions(
                        missingSkills));
    }
}