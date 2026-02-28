package com.loanapp.loanManagementSystem.service.education;

import com.loanapp.loanManagementSystem.dto.education.InterestDetailsDto;

import java.util.UUID;

public interface InterestDetailsService {
    InterestDetailsDto calculateInterest(UUID loanId);
    InterestDetailsDto getInterestDetails(UUID loanId);
}
