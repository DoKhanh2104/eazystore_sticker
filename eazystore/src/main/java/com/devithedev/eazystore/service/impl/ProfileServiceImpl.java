package com.devithedev.eazystore.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.devithedev.eazystore.dto.ProfileRequestDto;
import com.devithedev.eazystore.dto.ProfileResponseDto;
import com.devithedev.eazystore.entity.Address;
import com.devithedev.eazystore.entity.Customer;
import com.devithedev.eazystore.repository.CustomerRepository;
import com.devithedev.eazystore.service.IProfileService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements IProfileService {

    private final CustomerRepository customerRepository;

    @Override
    public ProfileResponseDto getProfile() {
        Customer customer = getAuthenticatedCustomer();
        return mapCustomerToProfileResponseDto(customer);
    }

    private Customer getAuthenticatedCustomer() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        var customer = this.customerRepository.findByEmail(email);
        return customer.orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    private ProfileResponseDto mapCustomerToProfileResponseDto(Customer customer) {
        ProfileResponseDto profileResponseDto = new ProfileResponseDto();
        BeanUtils.copyProperties(customer, profileResponseDto);
        if (customer.getAddress() != null) {
            profileResponseDto.setStreet(customer.getAddress().getStreet());
            profileResponseDto.setCity(customer.getAddress().getCity());
            profileResponseDto.setState(customer.getAddress().getState());
            profileResponseDto.setPostalCode(customer.getAddress().getPostalCode());
            profileResponseDto.setCountry(customer.getAddress().getCountry());
        }
        return profileResponseDto;
    }

    @Override
    public ProfileResponseDto updateProfile(ProfileRequestDto profileRequestDto) {
        Customer customer = getAuthenticatedCustomer();
        boolean isEmailUpdated = !customer.getEmail().equals(profileRequestDto.getEmail().trim());
        BeanUtils.copyProperties(profileRequestDto, customer);
        Address address = customer.getAddress();
        if (address == null) {
            address = new Address();
            address.setCustomer(customer);
        }
        address.setCity(profileRequestDto.getCity());
        address.setStreet(profileRequestDto.getStreet());
        address.setCountry(profileRequestDto.getCountry());
        address.setPostalCode(profileRequestDto.getPostalCode());
        address.setState(profileRequestDto.getState());
        customer.setAddress(address);
        customerRepository.save(customer);
        ProfileResponseDto profileResponseDto = mapCustomerToProfileResponseDto(customer);
        profileResponseDto.setEmailUpdated(isEmailUpdated);
        return profileResponseDto;

    }

}
