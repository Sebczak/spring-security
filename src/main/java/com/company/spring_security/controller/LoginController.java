package com.company.spring_security.controller;

import com.company.spring_security.model.Customer;
import com.company.spring_security.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final CustomerRepository customerRepository;

    @RequestMapping("/user")
    public Customer getUserDetailsAfterLogin(Authentication authentication) {
        return customerRepository.findByEmail(authentication.getName());
    }
}
