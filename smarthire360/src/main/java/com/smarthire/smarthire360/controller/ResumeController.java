package com.smarthire.smarthire360.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.smarthire.smarthire360.dto.ResumeAnalysisResult;
import com.smarthire.smarthire360.entity.Resume;
import com.smarthire.smarthire360.service.ResumeService;
import com.smarthire.smarthire360.service.ATSService;
import com.smarthire.smarthire360.service.ResumeParserService;
import com.smarthire.smarthire360.service.SkillExtractionService;

@RestController
@RequestMapping("/resumes")
@CrossOrigin(origins = "http://localhost:5173")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private ATSService atsService;

    @Autowired
    private ResumeParserService resumeParserService;

    @Autowired
    private SkillExtractionService skillExtractionService;

    @PostMapping
    public Resume uploadResume(@RequestBody Resume resume) {
        return resumeService.saveResume(resume);
    }

    @GetMapping
    public List<Resume> getAllResumes() {
        return resumeService.getAllResumes();
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<byte[]> downloadResume(
            @PathVariable String fileName) throws IOException {

        File file = new File("C:/uploads/" + fileName);

        byte[] data = Files.readAllBytes(file.toPath());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=" + file.getName())
                .body(data);
    }

    @PostMapping("/analyze")
    public ResumeAnalysisResult analyzeResume(
            @RequestParam String filePath)
            throws Exception {

        String resumeText =
                resumeParserService.extractText(filePath);

        int score =
                atsService.calculateATSScore(resumeText);

        List<String> skills =
                skillExtractionService.extractSkills(
                        resumeText);

        List<String> missingSkills =
                new java.util.ArrayList<>();

        String[] recommendedSkills = {
                "Docker",
                "AWS",
                "Kubernetes",
                "Microservices",
                "Spring Security",
                "JUnit",
                "MongoDB",
                "CI/CD"
        };

        for (String skill : recommendedSkills) {

            if (!resumeText.toLowerCase()
                    .contains(skill.toLowerCase())) {

                missingSkills.add(skill);
            }
        }

        return new ResumeAnalysisResult(
                score,
                skills,
                missingSkills);
    }
}