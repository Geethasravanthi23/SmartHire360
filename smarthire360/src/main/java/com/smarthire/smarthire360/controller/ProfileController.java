package com.smarthire.smarthire360.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.smarthire.smarthire360.entity.Profile;
import com.smarthire.smarthire360.service.ProfileService;

@RestController
@RequestMapping("/profile")
@CrossOrigin(origins = "http://localhost:5173")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping
    public Profile getProfile() {

        return profileService.getProfile();
    }

    @PutMapping
    public Profile updateProfile(
            @RequestBody Profile profile) {

        return profileService.saveProfile(
                profile);
    }
}
