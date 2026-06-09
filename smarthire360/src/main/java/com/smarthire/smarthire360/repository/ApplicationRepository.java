package com.smarthire.smarthire360.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smarthire.smarthire360.entity.Application;
import java.util.List;

public interface ApplicationRepository
        extends JpaRepository<Application, Long> {

    long countByStatus(String status);
    
    List<Application> findTop5ByOrderByIdDesc();
    

}