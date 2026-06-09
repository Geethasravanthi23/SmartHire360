package com.smarthire.smarthire360.dto;

public class DashboardStats {

    private long availableJobs;
    private long applications;
    private int profileMatch;
    private int skills;

    public long getAvailableJobs() {
        return availableJobs;
    }

    public void setAvailableJobs(long availableJobs) {
        this.availableJobs = availableJobs;
    }

    public long getApplications() {
        return applications;
    }

    public void setApplications(long applications) {
        this.applications = applications;
    }

    public int getProfileMatch() {
        return profileMatch;
    }

    public void setProfileMatch(int profileMatch) {
        this.profileMatch = profileMatch;
    }

    public int getSkills() {
        return skills;
    }

    public void setSkills(int skills) {
        this.skills = skills;
    }
}
