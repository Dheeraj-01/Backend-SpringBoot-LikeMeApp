package com.backend.likeme.services;

import com.backend.likeme.payloads.ProfileDto;

public interface ProfileService {

    ProfileDto getProfileDetails(Integer userId);
}
