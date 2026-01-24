package com.loanapp.loanManagementSystem.entities.educationLoan;

import com.loanapp.loanManagementSystem.enums.InterestType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CollectionId;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InterestDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "interest_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    InterestType interestType;

    private Boolean isStudentFemale;
    private Double femaleStudentDiscount;

    private Double baseInterest;

    private Double interestDuringStudy;
    private Double accumulatedInterest;

    private Boolean isSubsidized;
    private Double subsidyPercentage;
    private String subsidyScheme;

    private Double principalAmount;
    private Integer studyPeriodYears;
    private Double calculatedInterestDuringStudy;
    private Double totalAmountToRepay;

    @OneToOne
    @JoinColumn(name = "education_loan_id")
    EducationLoan educationLoan;

}
