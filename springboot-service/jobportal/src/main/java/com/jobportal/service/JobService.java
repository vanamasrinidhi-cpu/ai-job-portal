package com.jobportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.entity.Job;
import com.jobportal.repository.JobRepository;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    // GET ALL JOBS
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    // GET JOB BY ID
    public Job getJobById(Long id) {

        return jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found"));
    }

    // CREATE JOB
    public Job createJob(Job job) {

        return jobRepository.save(job);
    }

    // UPDATE JOB
    public Job updateJob(Long id, Job updatedJob) {

        return jobRepository.findById(id)
                .map(job -> {

                    job.setTitle(updatedJob.getTitle());
                    job.setCompany(updatedJob.getCompany());
                    job.setLocation(updatedJob.getLocation());
                    job.setSalary(updatedJob.getSalary());

                    return jobRepository.save(job);
                })
                .orElseThrow(() -> new RuntimeException("Job not found"));
    }

    // DELETE JOB
    public void deleteJob(Long id) {

        jobRepository.deleteById(id);
    }
}