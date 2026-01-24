package com.loanapp.loanManagementSystem.service.education;

import com.loanapp.loanManagementSystem.dto.education.CoApplicantDetailsDto;
import com.loanapp.loanManagementSystem.entities.educationLoan.CoApplicant;
import com.loanapp.loanManagementSystem.entities.educationLoan.EducationLoan;
import com.loanapp.loanManagementSystem.enums.LoanStatus;
import com.loanapp.loanManagementSystem.exception.InvalidLoanStateException;
import com.loanapp.loanManagementSystem.exception.ResourceNotFoundException;
import com.loanapp.loanManagementSystem.mapper.education.CoApplicantMapper;
import com.loanapp.loanManagementSystem.repository.education.CoApplicantRepository;
import com.loanapp.loanManagementSystem.repository.education.EducationLoanRepository;

import java.util.List;
import java.util.UUID;

public class CoApplicantServiceImpl implements CoApplicantService {

    EducationLoanRepository educationLoanRepository;
    CoApplicantMapper mapper;
    CoApplicantRepository coApplicantRepository;

    @Override
    public CoApplicantDetailsDto addCoApplicantDetails(UUID loanId,CoApplicantDetailsDto coApplicantDetailsDto){

        EducationLoan loan=educationLoanRepository.findById(loanId)
                .orElseThrow(()->new ResourceNotFoundException("Loan id not found"));

        CoApplicant coApplicant =mapper.toEntity(coApplicantDetailsDto);

        coApplicant.setEducationLoan(loan);
        CoApplicant saved=coApplicantRepository.save(coApplicant);

        return mapper.toDto(saved);
    }

    @Override
    public void validateCoApplicants(UUID loanID){

        EducationLoan educationLoan=educationLoanRepository.findById(loanID)
                .orElseThrow(()->new ResourceNotFoundException("Loan id not found"));

        List<CoApplicant> coApplicantList=coApplicantRepository.findByLoanId(loanID)
                .orElseThrow(()->new ResourceNotFoundException("CoApplicant not found for given education loan id"));

        if(coApplicantList.isEmpty()){
            throw new ResourceNotFoundException("At least one coapplicant is required");
        }

    }

    @Override
    public CoApplicantDetailsDto updateCoApplicantDetails(Long coApplicantId,CoApplicantDetailsDto coApplicantDetailsDto){
        CoApplicant coApplicant=coApplicantRepository.findById(coApplicantId)
                .orElseThrow(()->new ResourceNotFoundException("CoApplicant not found for the given id"));

        EducationLoan educationLoan=educationLoanRepository
                .findById(coApplicant.getEducationLoan().getId())
                .orElseThrow(()->new ResourceNotFoundException("Education loan not found for the given id"));


        if(educationLoan.getStatus()!= LoanStatus.APPLIED){
            throw  new InvalidLoanStateException("Co-applicant can only be updated when loan is in APPLIED status");
        }


        coApplicant.setEmail(coApplicantDetailsDto.getEmail());
        coApplicant.setAddress(coApplicantDetailsDto.getAddress());
        coApplicant.setName(coApplicantDetailsDto.getName());
        coApplicant.setAnnualIncome(coApplicantDetailsDto.getAnnualIncome());
        coApplicant.setCreditScore(coApplicantDetailsDto.getCreditScore());
        coApplicant.setRelationship(coApplicantDetailsDto.getRelationship());
        coApplicant.setIncomeType(coApplicantDetailsDto.getIncomeType());
        coApplicant.setAadharNumber(coApplicant.getAadharNumber());
        coApplicant.setPhoneNumber(coApplicantDetailsDto.getPhoneNumber());
        coApplicant.setPanNumber(coApplicantDetailsDto.getPanNumber());

        CoApplicant updated=coApplicantRepository.save(coApplicant);
        return mapper.toDto(updated);

    }

    @Override
    public List<CoApplicantDetailsDto> getCoApplicantDetails(UUID loanId){
        List<CoApplicant> coApplicantList=coApplicantRepository.findByLoanId(loanId)
                .orElseThrow(()->new ResourceNotFoundException("CoApplicant not found for the given education loan id"));

        return coApplicantList.stream().map(coApplicant -> mapper.toDto(coApplicant)).toList();
    }

}
