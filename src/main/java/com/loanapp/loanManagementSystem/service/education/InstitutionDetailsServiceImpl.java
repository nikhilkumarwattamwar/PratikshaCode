package com.loanapp.loanManagementSystem.service.education;

import com.loanapp.loanManagementSystem.dto.education.InstitutionDetailsDto;
import com.loanapp.loanManagementSystem.entities.educationLoan.EducationLoan;
import com.loanapp.loanManagementSystem.entities.educationLoan.Institution;
import com.loanapp.loanManagementSystem.exception.ResourceNotFoundException;
import com.loanapp.loanManagementSystem.mapper.education.InstitutionDetailsMapper;
import com.loanapp.loanManagementSystem.repository.EducationRepository;
import com.loanapp.loanManagementSystem.repository.education.EducationLoanRepository;
import com.loanapp.loanManagementSystem.repository.education.InstitutionDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class InstitutionDetailsServiceImpl implements InstitutionDetailsService{

    InstitutionDetailsMapper mapper;
    @Autowired
    InstitutionDetailsRepository repository;

    @Override
    public InstitutionDetailsDto saveInstitutionDetails(InstitutionDetailsDto institutionDetailsDto) {
        Institution institution =mapper.toEntity(institutionDetailsDto);
        Institution saved=repository.save(institution);
        return mapper.toDto(saved);
    }

    @Override
    public InstitutionDetailsDto getInstitutionDetails(UUID id) {

        Institution existing =repository.findByEducationId(id).orElseThrow(()-> new ResourceNotFoundException("Loan id not found"));
        return mapper.toDto(existing);
    }
}
