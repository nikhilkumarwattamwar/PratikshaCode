package com.loanapp.loanManagementSystem.dto.education;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InstitutionDetailsDto {


    private String institutionName;

    private String country;

    private String state;

    private String city;

    private Boolean recognitionStatus;

    private String contactEmail;

    private String contactPhone;

    private String website;

    private String address;

}
