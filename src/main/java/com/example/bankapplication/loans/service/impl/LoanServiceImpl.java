package com.example.bankapplication.loans.service.impl;

import com.example.bankapplication.loans.dto.LoanDto;
import com.example.bankapplication.loans.entity.Loan;
import com.example.bankapplication.loans.exception.LoanAlreadyExistsException;
import com.example.bankapplication.loans.exception.ResourceNotFoundException;
import com.example.bankapplication.loans.mapper.LoanMapper;
import com.example.bankapplication.loans.repository.LoanRepository;
import com.example.bankapplication.loans.service.ILoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class LoanServiceImpl implements ILoanService {

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    LoanMapper loanMapper;

    @Override
    public void createLoan(String mobileNumber) {
        Optional<Loan> loan = loanRepository.findByMobileNumber(mobileNumber);
        if(loan.isPresent()){
            throw new LoanAlreadyExistsException(String.format("Loan with mobileNumber %s already exists", mobileNumber));
        }
        Loan newLoan = createDefaultLoan(mobileNumber);
        loanRepository.save(newLoan);
    }

    @Override
    public LoanDto fetchLoanDetails(String mobileNumber) {
        Loan loan = loanRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber)
        );
        return loanMapper.mapLoanToLoanDto(loan);
    }

    @Override
    public boolean updateLoanDetails(LoanDto loanDto) {
        String mobileNumber = loanDto.getMobileNumber();
        Loan loan = loanRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber)
        );
        loan = loanMapper.mapLoanDtoToLoan(loanDto, loan);
        loanRepository.save(loan);
        return true;
    }

    @Override
    public boolean deleteLoanDetails(String mobileNumber) {
        Loan loan = loanRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber)
        );
        loanRepository.deleteById(loan.getLoadId());
        return true;
    }

    private static Loan createDefaultLoan(String mobileNumber){
        Loan loan = new Loan();
        loan.setMobileNumber(mobileNumber);
        Long randomLoanNumber = 1000000000L + new Random().nextInt(1000000000);
        loan.setLoanNumber(randomLoanNumber.toString());
        loan.setLoanType("HOME_LOAN");
        loan.setTotalLoan(10000000);
        loan.setAmountPaid(0);
        loan.setOutstandingAmount(10000000);
        return loan;
    }
}
