package com.jobportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jobportal.entity.Job;
import com.jobportal.service.JobService;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    // GET ALL JOBS
    @GetMapping
    public List<Job> getAllJobs() {

        return jobService.getAllJobs();
    }

    // GET JOB BY ID
    @GetMapping("/{id}")
    public Job getJobById(@PathVariable("id") Long id) {

        return jobService.getJobById(id);
    }

    // CREATE JOB
    @PostMapping
    public Job createJob(@RequestBody Job job) {

        return jobService.createJob(job);
    }

    // UPDATE JOB
    @PutMapping("/{id}")
    public Job updateJob(@PathVariable("id") Long id,
                         @RequestBody Job updatedJob) {

        return jobService.updateJob(id, updatedJob);
    }

    // DELETE JOB
    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable("id") Long id) {

        jobService.deleteJob(id);

        return "Job deleted successfully";
    }
}