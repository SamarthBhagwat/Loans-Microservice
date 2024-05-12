package com.example.bankapplication.loans.controller;

import com.example.bankapplication.loans.dto.LoanDto;
import com.example.bankapplication.loans.dto.ResponseDto;
import com.example.bankapplication.loans.service.ILoanService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Validated
public class LoanController {

    @Autowired
    ILoanService loanService;

    @GetMapping("/")
    public String sayHello(){
        return "Hello world";
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createLoan(@RequestParam
                                                      @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digit")
                                                  String mobileNumber){
        loanService.createLoan(mobileNumber);
        ResponseDto successResponse = new ResponseDto(HttpStatus.CREATED.toString(), "Loan created successfully");
        return new ResponseEntity<>(successResponse, HttpStatus.CREATED);
    }

    @GetMapping("/fetch")
    public ResponseEntity<LoanDto> fetchLoanDetails(@RequestParam
                                                        @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digit")
                                                        String mobileNumber){
        LoanDto loanDto = loanService.fetchLoanDetails(mobileNumber);
        return new ResponseEntity<>(loanDto, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateLoanDetails(@RequestBody @Valid LoanDto loanDto){
        boolean isUpdated = loanService.updateLoanDetails(loanDto);
        if(isUpdated){
            ResponseDto successResponse = new ResponseDto(HttpStatus.OK.toString(), "Loan updated successfully");
            return new ResponseEntity<>(successResponse, HttpStatus.OK);
        }
        else{
            ResponseDto errorResponse = new ResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Something went wrong. Failed to update loan details");
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteLoanDetails(@RequestParam
                                                             @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digit")
                                                             String mobileNumber){
        boolean isDeleted = loanService.deleteLoanDetails(mobileNumber);
        if(isDeleted){
            ResponseDto successResponse = new ResponseDto(HttpStatus.OK.toString(), "Successfully deleted loan details");
            return new ResponseEntity<>(successResponse, HttpStatus.OK);
        }
        else{
            ResponseDto errorResponse = new ResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Something went wrong while deleting loan details");
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
