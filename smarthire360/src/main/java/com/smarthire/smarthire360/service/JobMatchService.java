package com.smarthire.smarthire360.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class JobMatchService {

    public int calculateMatch(
            List<String> resumeSkills,
            List<String> jobSkills,
            List<String> matchedSkills,
            List<String> missingSkills) {

        for (String skill : jobSkills) {

            boolean found = resumeSkills.stream()
                    .anyMatch(s ->
                            s.trim().equalsIgnoreCase(
                                    skill.trim()));

            if (found) {

                matchedSkills.add(skill.trim());

            } else {

                missingSkills.add(skill.trim());

            }
        }

        return (matchedSkills.size() * 100)
                / jobSkills.size();
    }
}