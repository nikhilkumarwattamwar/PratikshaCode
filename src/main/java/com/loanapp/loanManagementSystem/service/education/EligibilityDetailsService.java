package com.loanapp.loanManagementSystem.service.education;

import com.loanapp.loanManagementSystem.dto.education.EligibilityDetailsDto;

import java.util.UUID;

public interface EligibilityDetailsService {
    EligibilityDetailsDto saveEligibilityDetails(UUID educationLoanID, EligibilityDetailsDto eligibilityDetailsDto);

    EligibilityDetailsDto evaluateEligibility(UUID educationLoanID);

}
