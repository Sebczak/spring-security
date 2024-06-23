package com.company.spring_security.repository;

import com.company.spring_security.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByEmail(String email);
    Optional<Customer> findByName(String name);
}
