package com.loanapp.loanManagementSystem.dto.education;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EligibilityDetailsDto {
    private Integer studentAge;
    private String nationality;

    private Double academicPercentage;
    private Boolean admissionSecured;

    private Integer creditScore;
    private Boolean eligible;
    private String reason;
    private Boolean isStudentFemale;
}
