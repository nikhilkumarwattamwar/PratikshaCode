package com.loanapp.loanManagementSystem.mapper.education;

import com.loanapp.loanManagementSystem.dto.education.EducationLoanDetailsDto;
import com.loanapp.loanManagementSystem.dto.education.InterestDetailsDto;
import com.loanapp.loanManagementSystem.entities.educationLoan.InterestDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InterestDetailsMapper {
    InterestDetails toEntity(InterestDetailsDto detailsDto);
    InterestDetailsDto toDto(InterestDetails interestDetails);

}
