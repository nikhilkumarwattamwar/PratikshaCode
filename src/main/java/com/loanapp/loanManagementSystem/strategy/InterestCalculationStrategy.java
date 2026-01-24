package com.loanapp.loanManagementSystem.strategy;

import com.loanapp.loanManagementSystem.dto.user.InterestDetailsDto;
import com.loanapp.loanManagementSystem.entities.educationLoan.EducationLoan;
import com.loanapp.loanManagementSystem.enums.StudyLocation;

public interface InterestCalculationStrategy {

        boolean hasLocation(StudyLocation studyLocation);

        InterestDetailsDto calculate(EducationLoan loan);

}
