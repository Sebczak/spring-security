package com.company.spring_security.controller;

import com.company.spring_security.model.Accounts;
import com.company.spring_security.model.Customer;
import com.company.spring_security.repository.AccountsRepository;
import com.company.spring_security.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountsRepository accountsRepository;
    private final CustomerRepository customerRepository;

    @GetMapping("/myAccount")
    public Accounts getAccountDetails(@RequestParam String email) {
        Customer customer = customerRepository.findByEmail(email);
        return accountsRepository.findByCustomerId(customer.getId());
    }
}