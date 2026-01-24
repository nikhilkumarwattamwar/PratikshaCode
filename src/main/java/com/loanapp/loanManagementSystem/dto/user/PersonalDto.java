package com.loanapp.loanManagementSystem.dto.user;

import com.loanapp.loanManagementSystem.enums.*;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonalDto {

    private Gender gender;

    private MaritalStatus maritalStatus;

    @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}", message = "Invalid PAN format")
    private String panCardNumber;

    @NotBlank(message = "Aadhaar Number is required")
    @Pattern(regexp = "\\d{12}", message = "Aadhaar must be 12 digits")
    private String aadharNumber;

    @Size(max = 20)
    @Pattern(regexp = "[A-Z]{2}\\d{7}", message = "Invalid passport format")
    private String passportNumber;

    private String voterIdNumber;

    @Enumerated(EnumType.STRING)
    private Disability disability;

    private Constitution constitution;

    private Religion religion;

    private Education education;

    private Category category;

}
