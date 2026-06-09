package com.smarthire.smarthire360.controller;

import java.util.HashMap;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.smarthire.smarthire360.dto.DashboardStats;
import com.smarthire.smarthire360.repository.ApplicationRepository;
import com.smarthire.smarthire360.repository.JobRepository;
@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins = "http://localhost:5173")
public class DashboardController {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    @GetMapping("/stats")
    public DashboardStats getStats() {

        DashboardStats stats = new DashboardStats();

        stats.setAvailableJobs(
                jobRepository.count());

        stats.setApplications(
                applicationRepository.count());

        stats.setProfileMatch(75);

        stats.setSkills(12);

        return stats;
    }

    @GetMapping("/application-summary")
    public Map<String, Long> getApplicationSummary() {

        Map<String, Long> summary =
                new HashMap<>();

        summary.put(
                "Applied",
                applicationRepository.countByStatus("Applied"));

        summary.put(
                "Interview Scheduled",
                applicationRepository.countByStatus("Interview Scheduled"));

        summary.put(
                "Selected",
                applicationRepository.countByStatus("Selected"));

        summary.put(
                "Rejected",
                applicationRepository.countByStatus("Rejected"));

        return summary;
    }
    @GetMapping("/status-percentage")
    public Map<String, Double> getStatusPercentage() {

        long total =
                applicationRepository.count();

        Map<String, Double> data =
                new HashMap<>();

        if (total == 0) {
            return data;
        }

        data.put(
                "Applied",
                applicationRepository.countByStatus("Applied")
                        * 100.0 / total);

        data.put(
                "Interview Scheduled",
                applicationRepository.countByStatus("Interview Scheduled")
                        * 100.0 / total);

        data.put(
                "Selected",
                applicationRepository.countByStatus("Selected")
                        * 100.0 / total);

        data.put(
                "Rejected",
                applicationRepository.countByStatus("Rejected")
                        * 100.0 / total);

        return data;
    }
    }
