package com.company.spring_security.controller;

import com.company.spring_security.model.AccountTransactions;
import com.company.spring_security.model.Customer;
import com.company.spring_security.repository.AccountTransactionsRepository;
import com.company.spring_security.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BalanceController {

    private final AccountTransactionsRepository accountTransactionsRepository;
    private final CustomerRepository customerRepository;

    @GetMapping("/myBalance")
    public List<AccountTransactions> getBalanceDetails(@RequestParam String email) {
        Customer customer = customerRepository.findByEmail(email);
        return accountTransactionsRepository.
                findByCustomerIdOrderByTransactionDtDesc(customer.getId());
    }
}
