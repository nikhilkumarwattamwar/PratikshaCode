package com.loanapp.loanManagementSystem.service.education;

import com.loanapp.loanManagementSystem.dto.education.EducationLoanDetailsDto;
import com.loanapp.loanManagementSystem.entities.educationLoan.EducationLoan;
import com.loanapp.loanManagementSystem.entities.user.User;
import com.loanapp.loanManagementSystem.enums.LoanStatus;
import com.loanapp.loanManagementSystem.exception.ResourceNotFoundException;
import com.loanapp.loanManagementSystem.mapper.education.EducationLoanMapper;
import com.loanapp.loanManagementSystem.repository.UserRepository;
import com.loanapp.loanManagementSystem.repository.education.EducationLoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class EducationLoanServiceImpl implements EducationLoanService{

    @Autowired
    EducationLoanRepository educationLoanRepository;
    @Autowired
    EligibilityDetailsService eligibilityDetailsService;
    @Autowired
    InstitutionDetailsService institutionDetailsService;
    EducationLoanMapper mapper;
    @Autowired
    UserRepository userRepository;

    @Override
    public EducationLoanDetailsDto applyLoan( UUID userId,EducationLoanDetailsDto educationLoanDto) {

        User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User id not found"));

        EducationLoan loan=mapper.toEntity(educationLoanDto);

        loan.setUser(user);
        loan.setStatus(LoanStatus.APPLIED);

        institutionDetailsService.saveInstitutionDetails(educationLoanDto.getInstitutionDetailsDto());
        eligibilityDetailsService.saveEligibilityDetails(loan.getId(),educationLoanDto.getEligibilityDetailsDto());

        EducationLoan saved=educationLoanRepository.save(loan);
        eligibilityDetailsService.evaluateEligibility(loan.getId());

        return mapper.toDto(saved);
    }


}
