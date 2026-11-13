package com.webdev2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_profiles")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bio;
    private String website;

    @OneToOne(mappedBy = "profile")
    private User user;

    public UserProfile() {}

    public UserProfile(String bio, String website) {
        this.bio = bio;
        this.website = website;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }

    public String getWebsite() { return website; }
    public void setWebsite(String website) { this.website = website; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}