package com.company.spring_security.model;


import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name="loan")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Loans {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "loan_number")
    private int loanNumber;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name="start_dt")
    private Date startDt;

    @Column(name = "loan_type")
    private String loanType;

    @Column(name = "total_loan")
    private int totalLoan;

    @Column(name = "amount_paid")
    private int amountPaid;

    @Column(name = "outstanding_amount")
    private int outstandingAmount;

    @Column(name = "create_dt")
    private String createDt;
}
