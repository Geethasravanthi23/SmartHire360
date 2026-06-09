package com.smarthire.smarthire360.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smarthire.smarthire360.entity.Application;
import com.smarthire.smarthire360.repository.ApplicationRepository;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public Application saveApplication(
            Application application) {

        return applicationRepository.save(
                application);
    }

    public List<Application> getAllApplications() {

        return applicationRepository.findAll();
    }

    public List<Application> getRecentApplications() {

        return applicationRepository
                .findTop5ByOrderByIdDesc();
    }
        public void deleteApplication(Long id) {

            applicationRepository.deleteById(id);

        }
    

    public Application updateStatus(
            Long id,
            String status) {

        Application app =
                applicationRepository
                        .findById(id)
                        .orElseThrow();

        app.setStatus(status);

        return applicationRepository.save(app);
    }
}