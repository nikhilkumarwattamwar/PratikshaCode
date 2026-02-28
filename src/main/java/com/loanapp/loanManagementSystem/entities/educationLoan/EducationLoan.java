package com.loanapp.loanManagementSystem.entities.educationLoan;

import com.loanapp.loanManagementSystem.entities.user.User;
import com.loanapp.loanManagementSystem.enums.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EducationLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "education_id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "loan_category")
    private CourseCategory courseCategory;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StudyLocation studyLocation;


    @Positive
    @Column(name = "loan_amount")
    private Double loanAmount;

    @Positive
    @Column(name = "interest_rate")
    private Double interestRate;

    @Enumerated(EnumType.STRING)
    @Column(name = "interest_type")
    private InterestType interestType;

    @Column(name = "moratorium_period_months")
    private Integer moratoriumPeriodMonths;

    @Min(1)
    @Column(name = "repayment_tenure_months")
    private Integer repaymentTenureMonths;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private LoanStatus status;

    private Double requestedAmount;
    private Double approvedAmount;
    private Double disbursedAmount;

    private LocalDate disbursementDate;


    @Column(name = "collateral_required")
    private Boolean collateralRequired;

    @OneToOne(mappedBy = "educationLoan")
    private GovernmentScheme governmentSchemes;

    @OneToMany(mappedBy = "educationLoan", cascade = CascadeType.ALL)
    private List<Collateral> collaterals;

    @OneToMany(mappedBy = "educationLoan", cascade = CascadeType.ALL)
    private List<EducationLoanDocuments> documents;

    @OneToMany(mappedBy = "educationLoan", cascade = CascadeType.ALL)
    private List<EMISchedule> emiSchedules;

    @OneToMany(mappedBy = "educationLoan", cascade = CascadeType.ALL)
    private List<CoApplicant> coApplicants;

    @OneToMany(mappedBy = "educationLoan", cascade = CascadeType.ALL)
    private List<LoanCoverage> loanCoverages;

    @OneToOne(mappedBy = "educationLoan", cascade = CascadeType.ALL)
    private InterestDetails interestDetails;

    @OneToOne(mappedBy = "educationLoan", cascade = CascadeType.ALL)
    private NPATracking npaTracking;

    @OneToOne(mappedBy = "educationLoan", cascade = CascadeType.ALL)
    private Institution institution;

    @OneToOne(mappedBy = "educationLoan", cascade = CascadeType.ALL)
    private EligibilityDetails eligibilityDetails;

}
