package com.loanapp.loanManagementSystem.repository.education;

import com.loanapp.loanManagementSystem.dto.education.InstitutionDetailsDto;
import com.loanapp.loanManagementSystem.entities.educationLoan.Institution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface InstitutionDetailsRepository extends JpaRepository<Institution,Long> {

    Optional<Institution>  findByEducationLoanId(UUID educationID);
}
