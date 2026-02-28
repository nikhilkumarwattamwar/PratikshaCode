package com.loanapp.loanManagementSystem.dto.education;

import com.loanapp.loanManagementSystem.enums.InterestType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InterestDetailsDto {

    private InterestType interestType;

    private Boolean isStudentFemale;
    private Double femaleStudentDiscount;

    private Double baseInterest;

    private Double interestDuringStudy;
    private Double accumulatedInterest;

    private Boolean isSubsidized;
    private Double subsidyPercentage;
    private String subsidyScheme;

    private Double principalAmount;
    private Integer studyPeriodYears;
    private Double calculatedInterestDuringStudy;
    private Double totalAmountToRepay;


    private UUID educationLoanId;
}
