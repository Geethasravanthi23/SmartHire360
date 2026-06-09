package com.smarthire.smarthire360.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SkillExtractionService {

    public List<String> extractSkills(String text) {

        List<String> skills =
                new ArrayList<>();

        text = text.toLowerCase();

        if(text.contains("java"))
            skills.add("Java");

        if(text.contains("spring"))
            skills.add("Spring");

        if(text.contains("spring boot"))
            skills.add("Spring Boot");

        if(text.contains("hibernate"))
            skills.add("Hibernate");

        if(text.contains("jdbc"))
            skills.add("JDBC");

        if(text.contains("mysql"))
            skills.add("MySQL");

        if(text.contains("sql"))
            skills.add("SQL");

        if(text.contains("rest"))
            skills.add("REST API");

        if(text.contains("api"))
            skills.add("API Development");

        if(text.contains("html"))
            skills.add("HTML");

        if(text.contains("css"))
            skills.add("CSS");

        if(text.contains("javascript"))
            skills.add("JavaScript");

        if(text.contains("react"))
            skills.add("React");

        if(text.contains("git"))
            skills.add("Git");

        if(text.contains("github"))
            skills.add("GitHub");

        if(text.contains("maven"))
            skills.add("Maven");

        if(text.contains("postman"))
            skills.add("Postman");

        if(text.contains("junit"))
            skills.add("JUnit");

        if(text.contains("agile"))
            skills.add("Agile");

        if(text.contains("microservices"))
            skills.add("Microservices");

        if(text.contains("docker"))
            skills.add("Docker");

        if(text.contains("aws"))
            skills.add("AWS");

        if(text.contains("azure"))
            skills.add("Azure");

        if(text.contains("python"))
            skills.add("Python");

        if(text.contains("node"))
            skills.add("Node.js");

        return skills;
    }
}