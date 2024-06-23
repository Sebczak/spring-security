package com.company.spring_security.controller;

import com.company.spring_security.model.Cards;
import com.company.spring_security.model.Customer;
import com.company.spring_security.repository.CardsRepository;
import com.company.spring_security.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CardsController {

    private final CardsRepository cardsRepository;
    private final CustomerRepository customerRepository;

    @GetMapping("/myCards")
    public List<Cards> getCardDetails(@RequestParam String email) {
        Customer customer = customerRepository.findByEmail(email);
        return cardsRepository.findByCustomerId(customer.getId());
    }
}
