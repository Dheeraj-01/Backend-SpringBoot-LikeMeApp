package com.backend.likeme.controllers;

import com.backend.likeme.payloads.ProfileDto;
import com.backend.likeme.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/profile/{userId}")
    public ResponseEntity<ProfileDto> getSingleUser(@PathVariable Integer userId) {
        return ResponseEntity.ok(this.profileService.getProfileDetails(userId));
    }
}
