package com.loanapp.loanManagementSystem.dto.education;

import com.loanapp.loanManagementSystem.entities.educationLoan.EducationLoan;
import com.loanapp.loanManagementSystem.enums.IncomeType;
import com.loanapp.loanManagementSystem.enums.Relationship;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CoApplicantDetailsDto {

    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private Relationship relationship;
    private String aadharNumber;
    private String panNumber;
    private IncomeType incomeType;
    private Double annualIncome;
    private Integer creditScore;
    private EducationLoan educationLoan;

}
