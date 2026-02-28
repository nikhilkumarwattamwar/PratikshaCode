package com.loanapp.loanManagementSystem.mapper.education;

import com.loanapp.loanManagementSystem.dto.education.CollateralDetailsDto;
import com.loanapp.loanManagementSystem.entities.educationLoan.Collateral;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CollateralMapper {
    CollateralDetailsDto toDto(Collateral collateral);
}
