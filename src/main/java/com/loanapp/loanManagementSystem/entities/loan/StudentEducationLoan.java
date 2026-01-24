package com.loanapp.loanManagementSystem.entities.loan;

import com.loanapp.loanManagementSystem.entities.user.CourseDetails;
import com.loanapp.loanManagementSystem.entities.user.EducationDetails;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("EDUCATION")
public class StudentEducationLoan extends Loan {

    @OneToOne
    @JoinColumn(name = "courseDetailId", nullable = true)
    CourseDetails courseDetails;

    @OneToOne
    @JoinColumn(name = "educationDetailId", nullable = true)
    EducationDetails educationDetails;

//
//    private EducationLoanCategory category;
//
//    private CourseCategory courseCategory;
//
//    private String institutionName;
//
//    private String country;
//
//    private Integer studentAge;
//
//    private String academicPercentage;
//
//    private Double courseFee;
//
//    private InterestType interestType;
//
//    private Boolean isFemaleStudent = false;
//
//    private Integer moratoriumMonths;
//
//    private String collateralType;




}
