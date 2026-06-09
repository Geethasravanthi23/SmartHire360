package com.smarthire.smarthire360.service;

import org.springframework.stereotype.Service;

@Service
public class ATSService {

    public int calculateATSScore(String resumeText) {

        int score = 0;

        String text = resumeText.toLowerCase();

        if(text.contains("java")) score += 5;
        if(text.contains("spring")) score += 5;
        if(text.contains("spring boot")) score += 5;
        if(text.contains("hibernate")) score += 5;
        if(text.contains("jdbc")) score += 5;
        if(text.contains("mysql")) score += 5;
        if(text.contains("sql")) score += 5;
        if(text.contains("rest")) score += 5;
        if(text.contains("api")) score += 5;
        if(text.contains("react")) score += 5;
        if(text.contains("javascript")) score += 5;
        if(text.contains("html")) score += 5;
        if(text.contains("css")) score += 5;
        if(text.contains("git")) score += 5;
        if(text.contains("github")) score += 5;
        if(text.contains("maven")) score += 5;
        if(text.contains("postman")) score += 5;
        if(text.contains("junit")) score += 5;
        if(text.contains("agile")) score += 5;
        if(text.contains("microservices")) score += 5;

        return Math.min(score, 100);
    }
}