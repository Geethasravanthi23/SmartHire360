package com.smarthire.smarthire360.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.smarthire.smarthire360.dto.JobMatchResult;
import com.smarthire.smarthire360.service.JobMatchService;

@RestController
@RequestMapping("/jobmatch")
@CrossOrigin(origins = "http://localhost:5173")
public class JobMatchController {

    @Autowired
    private JobMatchService jobMatchService;

    @PostMapping("/analyze")
    public JobMatchResult analyzeMatch(
            @RequestBody String jobDescription) {

    	List<String> resumeSkills =
    	        Arrays.asList(
    	                "Java",
    	                "Spring Boot",
    	                "Hibernate",
    	                "JPA",
    	                "MySQL",
    	                "SQL",
    	                "REST API",
    	                "Microservices",
    	                "JDBC",
    	                "Servlets",
    	                "JSP",
    	                "HTML",
    	                "CSS",
    	                "JavaScript",
    	                "React",
    	                "Bootstrap",
    	                "Git",
    	                "GitHub",
    	                "Maven",
    	                "Postman",
    	                "JUnit",
    	                "OOP",
    	                "MVC",
    	                "Agile",
    	                "SDLC",
    	                "Collections",
    	                "Exception Handling",
    	                "Multithreading",
    	                "Spring Security",
    	                "JSON",
    	                "API Testing",
    	                "Debugging",
    	                "Linux",
    	                "Windows"
    	        );

    	List<String> jobSkills = new ArrayList<>();

    	for (String skill : jobDescription.split(",")) {
    	    jobSkills.add(skill.trim());
    	}

        List<String> matchedSkills =
                new ArrayList<>();

        List<String> missingSkills =
                new ArrayList<>();

        int score =
                jobMatchService.calculateMatch(
                        resumeSkills,
                        jobSkills,
                        matchedSkills,
                        missingSkills);

        return new JobMatchResult(
                score,
                matchedSkills,
                missingSkills);
    }
}