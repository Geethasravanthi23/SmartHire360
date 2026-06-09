package com.smarthire.smarthire360.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.smarthire.smarthire360.entity.Application;
import com.smarthire.smarthire360.service.ApplicationService;

@RestController
@RequestMapping("/applications")
@CrossOrigin(origins = "http://localhost:5173")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping
    public Application saveApplication(
            @RequestBody Application application) {

        return applicationService.saveApplication(
                application);
    }

    @GetMapping
    public List<Application> getAllApplications() {

        return applicationService.getAllApplications();
    
    }
    @GetMapping("/recent")
    public List<Application> getRecentApplications() {

        return applicationService
                .getRecentApplications();
    }
        @PutMapping("/{id}/status")
        public Application updateStatus(
                @PathVariable Long id,
                @RequestParam String status) {

            return applicationService
                    .updateStatus(id, status);
        }
            @DeleteMapping("/{id}")
            public void deleteApplication(
                    @PathVariable Long id) {

                applicationService.deleteApplication(id);

            }
        }

    


