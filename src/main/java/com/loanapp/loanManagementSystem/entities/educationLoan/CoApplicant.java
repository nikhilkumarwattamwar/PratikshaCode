package com.loanapp.loanManagementSystem.entities.educationLoan;

import com.loanapp.loanManagementSystem.enums.IncomeType;
import com.loanapp.loanManagementSystem.enums.Relationship;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CoApplicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Pattern(regexp = "\\d{10}", message = "phone number should contain 10 digits")
    private String phoneNumber;
    @Email
    private String email;

    @Size(min = 0, max = 200)
    private String address;

    @Enumerated(EnumType.STRING)
    private Relationship relationship;

    @Pattern(regexp = "\\d{12}")
    private String aadharNumber;

    @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}")
    private String panNumber;

    @Enumerated(EnumType.STRING)
    private IncomeType incomeType;

    private Double annualIncome;

    private Integer creditScore;

    @ManyToOne
    @JoinColumn(name = "education_loan_id")
    private EducationLoan educationLoan;

}
