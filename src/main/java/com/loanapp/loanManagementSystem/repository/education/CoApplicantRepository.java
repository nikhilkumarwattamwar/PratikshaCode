package com.loanapp.loanManagementSystem.repository.education;

import com.loanapp.loanManagementSystem.entities.educationLoan.CoApplicant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CoApplicantRepository extends JpaRepository<CoApplicant,Long> {

    Optional<List<CoApplicant>> findByLoanId(UUID loanId);
}
