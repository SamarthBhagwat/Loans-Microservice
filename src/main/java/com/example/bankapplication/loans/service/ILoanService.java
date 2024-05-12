package com.example.bankapplication.loans.service;


import com.example.bankapplication.loans.dto.LoanDto;

public interface ILoanService {

    void createLoan(String mobileNumber);

    LoanDto fetchLoanDetails(String mobileNumber);

    boolean updateLoanDetails(LoanDto loanDto);

    boolean deleteLoanDetails(String mobileNumber);
}
