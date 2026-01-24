package com.loanapp.loanManagementSystem.mapper.education;

import com.loanapp.loanManagementSystem.dto.education.EducationLoanDetailsDto;
import com.loanapp.loanManagementSystem.entities.educationLoan.EducationLoan;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EducationLoanMapper {

    EducationLoan toEntity(EducationLoanDetailsDto  educationLoanDetailsDto);

    EducationLoanDetailsDto toDto(EducationLoan educationLoan);

}
