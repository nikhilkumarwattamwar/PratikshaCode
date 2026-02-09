package com.loanapp.loanManagementSystem.service.education;

import com.loanapp.loanManagementSystem.dto.education.EligibilityDetailsDto;
import com.loanapp.loanManagementSystem.entities.educationLoan.EducationLoan;
import com.loanapp.loanManagementSystem.entities.educationLoan.EligibilityDetails;
import com.loanapp.loanManagementSystem.exception.ResourceNotFoundException;
import com.loanapp.loanManagementSystem.mapper.education.EducationLoanMapper;
import com.loanapp.loanManagementSystem.mapper.education.EligibilityDetailsMapper;
import com.loanapp.loanManagementSystem.repository.education.EducationLoanRepository;
import com.loanapp.loanManagementSystem.repository.education.EligibilityDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Stream;
@Service
public class EligibilityDetailsServiceImpl implements EligibilityDetailsService{

    @Autowired
    EligibilityDetailsRepository eligibilityDetailsRepository;
    @Autowired
    EligibilityDetailsMapper mapper;
    @Autowired
    EducationLoanRepository educationLoanRepository;

    public EligibilityDetailsDto saveEligibilityDetails(UUID educationLoanID,EligibilityDetailsDto eligibilityDetailsDto){

        EducationLoan educationLoan=educationLoanRepository.findById(educationLoanID).orElseThrow(()->new ResourceNotFoundException("Education id not found"));

           EligibilityDetails entity=mapper.toEntity(eligibilityDetailsDto);
           entity.setReason(null);
           entity.setEligible(null);
           entity.setEducationLoan(educationLoan);

        EligibilityDetails saved=eligibilityDetailsRepository.save(entity);
        return mapper.toDto(saved);
    }

    public EligibilityDetailsDto evaluateEligibility(UUID educationLoanID){
                      EligibilityDetails details=eligibilityDetailsRepository.findByEducationLoanId(educationLoanID).orElseThrow(()->new ResourceNotFoundException("Id not found"));

        if (details.getStudentAge() >= 18 &&
                details.getStudentAge() <= 35 &&
                details.getNationality().equalsIgnoreCase("indian") &&
                details.getCreditScore() >= 650 &&
                details.getAcademicPercentage() >= 50 &&
                Boolean.TRUE.equals(details.getAdmissionSecured())) {

            details.setEligible(true);
        }else {
            details.setEligible(false);
            details.setReason("Eligibility criteria failed.");
        }

        EligibilityDetails saved=eligibilityDetailsRepository.save(details);

        return mapper.toDto(saved);
    }

}
