package com.loanapp.loanManagementSystem.dto.education;

import com.loanapp.loanManagementSystem.entities.educationLoan.EducationLoan;
import com.loanapp.loanManagementSystem.enums.EMIStatus;
import com.loanapp.loanManagementSystem.enums.PaymentMethod;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmiScheduleDto {
    private Long id;

    private UUID educationLoanId;

    private Double emiAmount;

    private LocalDate dueDate;

    private Double paidAmount;

    private PaymentMethod paymentMethod;

    private LocalDate paymentDate;

    private EMIStatus emiStatus;

    private Double lateFee;
    private Integer installmentNumber;
    private Double principalComponent;
    private Double interestComponent;
    private Double outstandingPrincipal;
}
