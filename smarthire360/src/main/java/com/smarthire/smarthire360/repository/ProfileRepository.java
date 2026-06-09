package com.smarthire.smarthire360.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smarthire.smarthire360.entity.Profile;

public interface ProfileRepository
        extends JpaRepository<Profile, Long> {
}
