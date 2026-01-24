package com.loanapp.loanManagementSystem.entities.educationLoan;

import com.loanapp.loanManagementSystem.enums.SchemeType;
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
public class GovernmentScheme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private SchemeType schemeType;

    private Double  subsidyAmount;

    @ManyToOne
    @JoinColumn(name = "education_loan_id")
    private EducationLoan educationLoan;
}
