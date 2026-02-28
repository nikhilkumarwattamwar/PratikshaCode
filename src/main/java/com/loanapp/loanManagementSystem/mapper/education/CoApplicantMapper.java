package com.loanapp.loanManagementSystem.mapper.education;

import com.loanapp.loanManagementSystem.dto.education.CoApplicantDetailsDto;
import com.loanapp.loanManagementSystem.entities.educationLoan.CoApplicant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoApplicantMapper {

    CoApplicantDetailsDto toDto(CoApplicant coApplicant);

    CoApplicant toEntity(CoApplicantDetailsDto coApplicantDetailsDto);

}
