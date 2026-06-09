package com.smarthire.smarthire360.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.smarthire.smarthire360.entity.Job;
import com.smarthire.smarthire360.service.JobService;

@RestController
@RequestMapping("/jobs")
@CrossOrigin(origins = "http://localhost:5173")
public class JobController {


@Autowired
private JobService jobService;

@PostMapping
public Job createJob(@RequestBody Job job) {
    return jobService.saveJob(job);
}

@GetMapping
public List<Job> getAllJobs() {
    return jobService.getAllJobs();
}


}
