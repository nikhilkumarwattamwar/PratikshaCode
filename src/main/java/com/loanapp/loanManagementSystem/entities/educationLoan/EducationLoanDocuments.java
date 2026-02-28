package com.loanapp.loanManagementSystem.entities.educationLoan;

import com.loanapp.loanManagementSystem.enums.DocumentType;
import com.loanapp.loanManagementSystem.enums.VerificationStatus;
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
public class EducationLoanDocuments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "education_loan_id")
    private EducationLoan educationLoan;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private DocumentType type;

    @Column(name = "file_path")
    private String filePath;

    private VerificationStatus verificationStatus;

    private String rejectionReason;

    @Lob
    private byte[] fileData;
}
