package com.loanapp.loanManagementSystem.repository.education;

import com.loanapp.loanManagementSystem.entities.educationLoan.Collateral;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CollateralRepository extends JpaRepository<Collateral,Long> {
    Optional<Collateral> findByEducationLoanId(UUID educationLoanId);
}
