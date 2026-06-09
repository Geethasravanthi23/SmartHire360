package com.smarthire.smarthire360.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smarthire.smarthire360.entity.Profile;
import com.smarthire.smarthire360.repository.ProfileRepository;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public Profile saveProfile(
            Profile profile) {

        return profileRepository.save(profile);
    }

    public Profile getProfile() {

        return profileRepository
                .findAll()
                .stream()
                .findFirst()
                .orElse(new Profile());
    }
}
