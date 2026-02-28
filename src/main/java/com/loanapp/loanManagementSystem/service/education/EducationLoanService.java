package com.loanapp.loanManagementSystem.service.education;

import com.loanapp.loanManagementSystem.dto.education.EducationLoanDetailsDto;

import java.util.UUID;

public interface EducationLoanService {


    EducationLoanDetailsDto applyLoan(UUID userId, EducationLoanDetailsDto educationLoanDto);

    void approveLoan(UUID loanId);
    void disburseLoan(UUID loanId);
}
