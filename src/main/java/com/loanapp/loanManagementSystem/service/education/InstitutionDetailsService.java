package com.loanapp.loanManagementSystem.service.education;

import com.loanapp.loanManagementSystem.dto.education.InstitutionDetailsDto;

import java.util.UUID;

public interface InstitutionDetailsService {

    InstitutionDetailsDto saveInstitutionDetails(InstitutionDetailsDto institutionDetailsDto);
    InstitutionDetailsDto getInstitutionDetails(UUID educationId);

}
