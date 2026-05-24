package com.jobportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.entity.Application;
import com.jobportal.repository.ApplicationRepository;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    // GET ALL APPLICATIONS
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    // GET APPLICATION BY ID
    public Application getApplicationById(Long id) {
        return applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found"));
    }

    // CREATE APPLICATION
    public Application createApplication(Application application) {
        return applicationRepository.save(application);
    }

    // UPDATE APPLICATION
    public Application updateApplication(Long id, Application updatedApplication) {

        return applicationRepository.findById(id)
                .map(application -> {

                    application.setApplicantName(updatedApplication.getApplicantName());
                    application.setApplicantEmail(updatedApplication.getApplicantEmail());
                    application.setResumeLink(updatedApplication.getResumeLink());
                    application.setStatus(updatedApplication.getStatus());
                    application.setJob(updatedApplication.getJob());

                    return applicationRepository.save(application);
                })
                .orElseThrow(() -> new RuntimeException("Application not found"));
    }

    // DELETE APPLICATION
    public void deleteApplication(Long id) {
        applicationRepository.deleteById(id);
    }
}