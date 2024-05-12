package com.example.bankapplication.loans.mapper;

import com.example.bankapplication.loans.dto.LoanDto;
import com.example.bankapplication.loans.entity.Loan;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {

    public LoanDto mapLoanToLoanDto(Loan loan){
        LoanDto loanDto = new LoanDto();
        loanDto.setLoanNumber(loan.getLoanNumber());
        loanDto.setLoanType(loan.getLoanType());
        loanDto.setTotalLoan(loan.getTotalLoan());
        loanDto.setOutstandingAmount(loan.getOutstandingAmount());
        loanDto.setMobileNumber(loan.getMobileNumber());
        loanDto.setAmountPaid(loan.getAmountPaid());
        return loanDto;
    }

    public Loan mapLoanDtoToLoan(LoanDto loanDto, Loan loan){
        loan.setLoanNumber(loanDto.getLoanNumber());
        loan.setLoanType(loanDto.getLoanType());
        loan.setMobileNumber(loanDto.getMobileNumber());
        loan.setAmountPaid(loanDto.getAmountPaid());
        loan.setOutstandingAmount(loanDto.getOutstandingAmount());
        loan.setTotalLoan(loanDto.getTotalLoan());
        return loan;
    }
}
