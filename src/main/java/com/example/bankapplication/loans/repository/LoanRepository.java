package com.example.bankapplication.loans.repository;

import com.example.bankapplication.loans.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loan, Integer> {

    Optional<Loan> findByMobileNumber(String mobileNumber);
}
