package com.loanapp.loanManagementSystem.repository.education;

import com.loanapp.loanManagementSystem.entities.educationLoan.EducationLoanDocuments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EducationLoanDocumentRepository extends JpaRepository<EducationLoanDocuments,Long> {
    Optional<List<EducationLoanDocuments>> findByEducationLoanId(UUID loanId);
}
