package com.smarthire.smarthire360.dto;

import java.util.List;

public class ResumeSuggestionResult {

    private List<String> suggestions;

    public ResumeSuggestionResult() {
    }

    public ResumeSuggestionResult(
            List<String> suggestions) {
        this.suggestions = suggestions;
    }

    public List<String> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(
            List<String> suggestions) {
        this.suggestions = suggestions;
    }
}