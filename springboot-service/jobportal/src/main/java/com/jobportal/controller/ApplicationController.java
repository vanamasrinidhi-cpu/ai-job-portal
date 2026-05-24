package com.jobportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.entity.Application;
import com.jobportal.service.ApplicationService;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    // GET ALL APPLICATIONS
    @GetMapping
    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }

    // GET APPLICATION BY ID
    @GetMapping("/{id}")
    public Application getApplicationById(@PathVariable("id") Long id) {

        return applicationService.getApplicationById(id);
    }

    // CREATE APPLICATION
    @PostMapping
    public Application createApplication(@RequestBody Application application) {

        return applicationService.createApplication(application);
    }

    // UPDATE APPLICATION
    @PutMapping("/{id}")
    public Application updateApplication(@PathVariable("id") Long id,
                                         @RequestBody Application application) {

        return applicationService.updateApplication(id, application);
    }

    // DELETE APPLICATION
    @DeleteMapping("/{id}")
    public String deleteApplication(@PathVariable("id") Long id) {

        applicationService.deleteApplication(id);

        return "Application deleted successfully";
    }
}