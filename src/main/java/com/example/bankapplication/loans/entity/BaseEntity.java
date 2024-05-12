package com.example.bankapplication.loans.entity;

import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class BaseEntity {
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @Column(updatable = false)
    private String createdBy;
    @Column(insertable = false)
    private LocalDateTime updatedAt;
    @Column(insertable = false)
    private String updatedBy;
}
