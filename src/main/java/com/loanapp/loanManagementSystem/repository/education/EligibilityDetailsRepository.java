package com.loanapp.loanManagementSystem.repository.education;

import com.loanapp.loanManagementSystem.entities.educationLoan.EligibilityDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EligibilityDetailsRepository extends JpaRepository<EligibilityDetails,Long> {

    Optional<EligibilityDetails> findByEducationLoanId(UUID educationLoanId);
}
