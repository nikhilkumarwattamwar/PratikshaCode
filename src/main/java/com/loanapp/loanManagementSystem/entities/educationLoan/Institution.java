package com.loanapp.loanManagementSystem.entities.educationLoan;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "institution_id")
    private Long institutionId;

    @Column(name = "institution_name")
    private String institutionName;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @Column(name = "city")
    private String city;

    @Column(name = "recognition_status")
    private Boolean recognitionStatus;

    @Email
    @Column(name = "contact_email")
    private String contactEmail;

    @Column(name = "contact_phone")
    private String contactPhone;

    @Column(name = "website")
    private String website;

    @Column(name = "address")
    private String address;

    @OneToOne
    @JoinColumn(name = "education_loan_id")
    private EducationLoan educationLoan;

}
