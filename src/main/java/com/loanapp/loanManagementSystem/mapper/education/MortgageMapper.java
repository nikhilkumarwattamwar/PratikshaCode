package com.loanapp.loanManagementSystem.mapper.education;

import com.loanapp.loanManagementSystem.dto.education.MortgageDetailsDto;
import com.loanapp.loanManagementSystem.entities.educationLoan.Mortgage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MortgageMapper {
    Mortgage toEntity(MortgageDetailsDto mortgageDetailsDto);

    MortgageDetailsDto toDto(Mortgage mortgage);
}
