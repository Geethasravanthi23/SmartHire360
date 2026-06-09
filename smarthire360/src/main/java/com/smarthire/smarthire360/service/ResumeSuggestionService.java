package com.smarthire.smarthire360.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ResumeSuggestionService {

    public List<String> getSuggestions(
            List<String> missingSkills) {

        List<String> suggestions =
                new ArrayList<>();

        for(String skill : missingSkills) {

            suggestions.add(
                "Add " + skill +
                " skill to improve your resume."
            );
        }

        return suggestions;
    }
}
