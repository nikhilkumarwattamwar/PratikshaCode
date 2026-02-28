package com.loanapp.loanManagementSystem.repository.education;

import com.loanapp.loanManagementSystem.entities.educationLoan.EducationLoan;
import com.loanapp.loanManagementSystem.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EducationLoanRepository extends JpaRepository<EducationLoan, UUID> {


}
