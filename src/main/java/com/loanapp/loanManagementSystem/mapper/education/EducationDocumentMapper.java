package com.loanapp.loanManagementSystem.mapper.education;

import com.loanapp.loanManagementSystem.dto.education.EducationLoanDocumentDto;
import com.loanapp.loanManagementSystem.entities.educationLoan.EducationLoanDocuments;
import com.loanapp.loanManagementSystem.enums.Education;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EducationDocumentMapper {
    EducationLoanDocumentDto toDto(EducationLoanDocuments documents);
    EducationLoanDocuments toEntity(EducationLoanDocumentDto dto);

}
