package com.loanapp.loanManagementSystem.entities.educationLoan;

import com.loanapp.loanManagementSystem.enums.CollateralType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Collateral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CollateralType collateralType;

    @Positive
    private Double collateralValue;

    @NotBlank
    private String description;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "education_loan_id")
    private EducationLoan educationLoan;

    @OneToOne(mappedBy = "collateral")
    Mortgage mortgage;
}
