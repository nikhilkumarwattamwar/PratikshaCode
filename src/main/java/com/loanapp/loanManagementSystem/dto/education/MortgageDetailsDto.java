package com.loanapp.loanManagementSystem.dto.education;

import com.loanapp.loanManagementSystem.entities.educationLoan.Collateral;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MortgageDetailsDto {
    private Long mortgageId;
    private String propertyAddress;
    private Double propertyValue;
    private Boolean mortgageReleased;
    LocalDateTime mortgageReleaseDate;
    private Collateral collateral;
}
