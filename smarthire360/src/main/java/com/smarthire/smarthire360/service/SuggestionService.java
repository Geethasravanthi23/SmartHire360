package com.smarthire.smarthire360.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SuggestionService {

    public List<String> generateSuggestions(
            List<String> missingSkills) {

        List<String> suggestions =
                new ArrayList<>();

        for(String skill : missingSkills) {

            suggestions.add(
                    "Add " + skill +
                    " to your resume and projects");
        }

        return suggestions;
    }
}