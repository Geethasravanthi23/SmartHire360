package com.smarthire.smarthire360.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.smarthire.smarthire360.dto.ATSResult;
import com.smarthire.smarthire360.service.ATSService;
import com.smarthire.smarthire360.service.SkillExtractionService;

@RestController
@RequestMapping("/ats")
@CrossOrigin(origins = "http://localhost:5173")
public class ATSController {

    @Autowired
    private ATSService atsService;

    @Autowired
    private SkillExtractionService skillExtractionService;

    @PostMapping("/score")
    public ATSResult calculateScore(
            @RequestBody String resumeText) {

        int score =
                atsService.calculateATSScore(resumeText);

        List<String> skills =
                skillExtractionService.extractSkills(
                        resumeText);

        return new ATSResult(score, skills);
    }
}