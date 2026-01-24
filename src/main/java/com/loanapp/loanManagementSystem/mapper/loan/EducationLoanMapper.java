package com.loanapp.loanManagementSystem.mapper.loan;

import com.loanapp.loanManagementSystem.dto.loan.EducationLoanDto;
import com.loanapp.loanManagementSystem.entities.loan.StudentEducationLoan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EducationLoanMapper {


    @Mapping(target = "loanId", ignore = true)
    StudentEducationLoan toEntity(EducationLoanDto dto);

    EducationLoanDto toDto(StudentEducationLoan entity);

    void updateEntity(EducationLoanDto dto, @MappingTarget StudentEducationLoan entity);

}
