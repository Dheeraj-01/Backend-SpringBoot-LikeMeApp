package com.backend.likeme.services.impl;

import com.backend.likeme.entities.User;
import com.backend.likeme.exceptions.ResourceNotFoundException;
import com.backend.likeme.payloads.ProfileDto;
import com.backend.likeme.repositories.UserRepo;
import com.backend.likeme.services.ProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProfileDto getProfileDetails(Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));
        return this.modelMapper.map(user, ProfileDto.class);
    }
}
