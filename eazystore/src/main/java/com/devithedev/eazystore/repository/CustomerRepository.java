package com.devithedev.eazystore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devithedev.eazystore.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmailOrMobileNumber(String email, String mobileNumber);

    Optional<Customer> findByEmail(String email);
}
