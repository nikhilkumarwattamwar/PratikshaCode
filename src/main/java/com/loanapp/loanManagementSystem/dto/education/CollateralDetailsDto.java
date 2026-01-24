package com.loanapp.loanManagementSystem.dto.education;

import com.loanapp.loanManagementSystem.entities.educationLoan.EducationLoan;
import com.loanapp.loanManagementSystem.enums.CollateralType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CollateralDetailsDto {
    private Long collateralId;
    private CollateralType collateralType;
    private Double collateralValue;
    private String description;
    private LocalDateTime createdAt;
    private MortgageDetailsDto mortgageDetailsDto;
}
