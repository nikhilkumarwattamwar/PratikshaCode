package com.loanapp.loanManagementSystem.repository.education;

import com.loanapp.loanManagementSystem.entities.educationLoan.EMISchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EmiScheduleRepository extends JpaRepository<EMISchedule, Long> {
    List<EMISchedule> findByEducationLoanId(UUID loanId);
}
