package com.loanapp.loanManagementSystem.entities.educationLoan;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoanCoverage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_coverage_id")
    private Long id;

    private Double courseFee;
    private Double livingExpenses;
    private Double travelExpenses;
    private Double booksAndEquipment;
    private Double laptopAllowance;
    private Double insuranceAmount;

    private Double totalCalculatedFeeAndCharges;

    @ManyToOne
    @JoinColumn(name = "education_loan_id")
    EducationLoan educationLoan;

}
