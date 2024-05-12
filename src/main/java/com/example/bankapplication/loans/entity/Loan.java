package com.example.bankapplication.loans.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
@Entity
public class Loan extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loadId;

    private String mobileNumber;
    @Column(updatable = false)
    private String loanNumber;
    private String loanType;
    private int totalLoan;
    private int amountPaid;
    private int outstandingAmount;
}
