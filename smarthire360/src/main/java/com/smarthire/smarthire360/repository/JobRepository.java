package com.smarthire.smarthire360.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smarthire.smarthire360.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

}