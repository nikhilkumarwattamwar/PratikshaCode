package com.loanapp.loanManagementSystem.mapper.education;

import com.loanapp.loanManagementSystem.dto.education.InstitutionDetailsDto;
import com.loanapp.loanManagementSystem.entities.educationLoan.Institution;
import org.mapstruct.Mapper;
import org.springframework.jmx.export.annotation.ManagedOperation;

@Mapper(componentModel = "spring")
public interface InstitutionDetailsMapper {
    InstitutionDetailsDto toDto(Institution institution);

    Institution toEntity(InstitutionDetailsDto institutionDetailsDto);
}
