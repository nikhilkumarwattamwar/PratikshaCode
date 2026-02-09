package com.loanapp.loanManagementSystem.repository.education;

import com.loanapp.loanManagementSystem.dto.education.InterestDetailsDto;
import com.loanapp.loanManagementSystem.entities.educationLoan.InterestDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface InterestDetailsRepository extends JpaRepository<InterestDetails,Long> {
    Optional<InterestDetails> findByEducationLoanId(UUID loanId);
}
