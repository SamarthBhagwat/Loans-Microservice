package com.example.bankapplication.loans.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class LoanDto {
    @NotBlank(message = "Mobile number cannot be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digit")
    private String mobileNumber;

    @NotBlank
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Loan number must be 10 digit")
    private String loanNumber;

    @NotBlank
    @Size(min = 3)
    private String loanType;

    @Positive
    private int totalLoan;

    @PositiveOrZero
    private int amountPaid;

    @PositiveOrZero
    private int outstandingAmount;
}
