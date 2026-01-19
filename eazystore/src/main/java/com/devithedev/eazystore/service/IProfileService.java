package com.devithedev.eazystore.service;

import com.devithedev.eazystore.dto.ProfileRequestDto;
import com.devithedev.eazystore.dto.ProfileResponseDto;

public interface IProfileService {
    ProfileResponseDto getProfile();

    ProfileResponseDto updateProfile(ProfileRequestDto profileRequestDto);
}
