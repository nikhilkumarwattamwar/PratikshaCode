package com.loanapp.loanManagementSystem.entities.educationLoan;

import com.loanapp.loanManagementSystem.enums.EMIStatus;
import com.loanapp.loanManagementSystem.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EMISchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "education_loan_id")
    private EducationLoan educationLoan;

    private Double emiAmount;

    private LocalDate dueDate;

    private Double paidAmount;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private LocalDate paymentDate;

    private EMIStatus emiStatus;

    private Double lateFee;

    private Integer installmentNumber;
    private Double principalComponent;
    private Double interestComponent;
    private Double outstandingPrincipal;

}
