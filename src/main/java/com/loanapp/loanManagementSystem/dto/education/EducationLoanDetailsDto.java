package com.loanapp.loanManagementSystem.dto.education;

import com.loanapp.loanManagementSystem.enums.CourseCategory;
import com.loanapp.loanManagementSystem.enums.InterestType;
import com.loanapp.loanManagementSystem.enums.LoanStatus;
import com.loanapp.loanManagementSystem.enums.StudyLocation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EducationLoanDetailsDto {

    private UUID userId;
    private CourseCategory courseCategory;
    private StudyLocation studyLocation;
    private Double loanAmount;
    private InterestType interestType;
    private Integer moratoriumPeriodMonths;
    private LoanStatus status;

    private InstitutionDetailsDto institutionDetailsDto;

    private EligibilityDetailsDto eligibilityDetailsDto;

}
