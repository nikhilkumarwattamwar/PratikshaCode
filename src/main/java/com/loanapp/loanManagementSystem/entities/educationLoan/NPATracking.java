package com.loanapp.loanManagementSystem.entities.educationLoan;

import com.loanapp.loanManagementSystem.enums.NPAStatus;
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
public class NPATracking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NPA_id")
    private Long id;

    private Integer overdueDays;

    @Enumerated(EnumType.STRING)
    private NPAStatus npaStatus;

    private Boolean writtenOff;

    @OneToOne
    @JoinColumn(name = "education_loan_id")
    private EducationLoan educationLoan;
}
