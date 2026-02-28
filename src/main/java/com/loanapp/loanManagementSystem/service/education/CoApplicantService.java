package com.loanapp.loanManagementSystem.service.education;

import com.loanapp.loanManagementSystem.dto.education.CoApplicantDetailsDto;

import java.util.List;
import java.util.UUID;

public interface CoApplicantService {
    CoApplicantDetailsDto addCoApplicantDetails(UUID loanId,CoApplicantDetailsDto coApplicantDetailsDto);
    List<CoApplicantDetailsDto> getCoApplicantDetails(UUID loanId);
    void validateCoApplicants(UUID loanID);
    CoApplicantDetailsDto updateCoApplicantDetails(Long coApplicantId,CoApplicantDetailsDto coApplicantDetailsDto);
}
