package com.loanapp.loanManagementSystem.repository.education;

import com.loanapp.loanManagementSystem.entities.educationLoan.Mortgage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MortgageRepository extends JpaRepository<Mortgage,Long> {


    Optional<Mortgage> findByCollateralId(Long collateralId);

    boolean existsByCollateralId(Long collateralId);
}
