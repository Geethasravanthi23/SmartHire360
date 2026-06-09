package com.smarthire.smarthire360.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smarthire.smarthire360.entity.Resume;

public interface ResumeRepository extends JpaRepository<Resume, Long> {

}
