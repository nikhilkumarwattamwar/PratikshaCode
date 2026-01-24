package com.loanapp.loanManagementSystem.repository.education;

import com.loanapp.loanManagementSystem.entities.educationLoan.Collateral;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollateralRepository extends JpaRepository<Collateral,Long> {
}
