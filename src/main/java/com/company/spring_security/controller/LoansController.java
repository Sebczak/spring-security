package com.company.spring_security.controller;

import com.company.spring_security.model.Customer;
import com.company.spring_security.model.Loans;
import com.company.spring_security.repository.CustomerRepository;
import com.company.spring_security.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoansController {

    private final LoanRepository loanRepository;
    private final CustomerRepository customerRepository;

    @GetMapping("/myLoans")
    public List<Loans> getLoanDetails(@RequestParam String email) {
        Customer customer = customerRepository.findByEmail(email);
        return loanRepository.findByCustomerIdOrderByStartDtDesc(customer.getId());
    }
}
