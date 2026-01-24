package com.loanapp.loanManagementSystem.mapper.education;

import com.loanapp.loanManagementSystem.dto.education.EligibilityDetailsDto;
import com.loanapp.loanManagementSystem.entities.educationLoan.EligibilityDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EligibilityDetailsMapper {
     EligibilityDetails toEntity(EligibilityDetailsDto eligibilityDetailsDto);

    EligibilityDetailsDto toDto(EligibilityDetails eligibilityDetails);
}
