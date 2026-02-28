package com.loanapp.loanManagementSystem.entities.educationLoan;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EligibilityDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(18)
    @Max(35)
    private Integer studentAge;

    @NotBlank
    private String nationality;

    @DecimalMin("50.0")
    @DecimalMax("100.0")
    private Double academicPercentage;

    private Boolean admissionSecured;

    @Positive
    private Integer creditScore;
    private Boolean eligible;
    private String reason;

    private Boolean isStudentFemale;

    @OneToOne
    @JoinColumn(name = "education_loan_id")
    private EducationLoan educationLoan;
}
