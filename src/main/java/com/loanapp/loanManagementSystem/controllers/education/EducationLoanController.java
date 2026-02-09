package com.loanapp.loanManagementSystem.controllers.education;

import com.loanapp.loanManagementSystem.dto.education.EducationLoanDetailsDto;
import com.loanapp.loanManagementSystem.service.education.EducationLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/education")
public class EducationLoanController {

    @Autowired
    private EducationLoanService educationLoanService;

    @PostMapping("/apply/{userId}")
    public EducationLoanDetailsDto applyLoan(@PathVariable UUID userId, @RequestBody EducationLoanDetailsDto dto) {
        return educationLoanService.applyLoan(userId, dto);
    }

    @PostMapping("/approve/{loanId}")
    public ResponseEntity<String> approveLoan(@PathVariable UUID loanId) {

        educationLoanService.approveLoan(loanId);

        return ResponseEntity.ok("Loan approved successfully");
    }

    @PostMapping("/disburse/{loanId}")
    public ResponseEntity<String> disburseLoan(@PathVariable UUID loanId) {

        educationLoanService.disburseLoan(loanId);

        return ResponseEntity.ok("Loan disbursed successfully");

    }


}
