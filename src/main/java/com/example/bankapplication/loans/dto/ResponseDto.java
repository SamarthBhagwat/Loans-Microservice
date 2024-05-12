package com.example.bankapplication.loans.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ResponseDto {

    private String statusCode;
    private String statusMsg;
}
