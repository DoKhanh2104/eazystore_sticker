package com.devithedev.eazystore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devithedev.eazystore.dto.ProfileRequestDto;
import com.devithedev.eazystore.dto.ProfileResponseDto;
import com.devithedev.eazystore.service.IProfileService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final IProfileService iProfileService;

    @GetMapping
    public ResponseEntity<ProfileResponseDto> getProfile() {
        ProfileResponseDto profileResponseDto = this.iProfileService.getProfile();
        return ResponseEntity.status(HttpStatus.OK).body(profileResponseDto);
    }

    @PutMapping
    public ResponseEntity<ProfileResponseDto> updateProflie(@Valid @RequestBody ProfileRequestDto profileRequestDto) {
        ProfileResponseDto profileResponseDto = this.iProfileService.updateProfile(profileRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(profileResponseDto);
    }
}
