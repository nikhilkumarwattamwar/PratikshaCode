package com.loanapp.loanManagementSystem.service.education;

import com.loanapp.loanManagementSystem.dto.education.InterestDetailsDto;
import com.loanapp.loanManagementSystem.entities.educationLoan.EducationLoan;
import com.loanapp.loanManagementSystem.entities.educationLoan.InterestDetails;
import com.loanapp.loanManagementSystem.enums.StudyLocation;
import com.loanapp.loanManagementSystem.exception.ResourceNotFoundException;
import com.loanapp.loanManagementSystem.mapper.education.InterestDetailsMapper;
import com.loanapp.loanManagementSystem.repository.education.EducationLoanRepository;
import com.loanapp.loanManagementSystem.repository.education.InterestDetailsRepository;
import com.loanapp.loanManagementSystem.strategy.DomesticInterestCalculationStrategy;
import com.loanapp.loanManagementSystem.strategy.InternationalCalculationStrategy;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InterestDetailsServiceImpl implements InterestDetailsService {
    @Autowired
    private  EducationLoanRepository loanRepository;
    @Autowired
    private  InterestDetailsRepository interestDetailsRepository;
    @Autowired
    DomesticInterestCalculationStrategy domestic;
    @Autowired
    InternationalCalculationStrategy international;

    @Autowired
    InterestDetailsMapper mapper;

    @Transactional
    public InterestDetailsDto calculateInterest(UUID loanId) {

        EducationLoan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found"));

        InterestDetailsDto dto;

        if (loan.getStudyLocation() == StudyLocation.DOMESTIC) {
             dto=domestic.calculate(loan);
        } else {
             dto=international.calculate(loan);
        }



        InterestDetails entity= new InterestDetails();
        entity.setInterestType(dto.getInterestType());
        entity.setBaseInterest(dto.getBaseInterest());
        entity.setInterestDuringStudy(dto.getInterestDuringStudy());
        entity.setAccumulatedInterest(dto.getAccumulatedInterest());
        entity.setPrincipalAmount(dto.getPrincipalAmount());
        entity.setStudyPeriodYears(dto.getStudyPeriodYears());
        entity.setTotalAmountToRepay(dto.getTotalAmountToRepay());
        entity.setEducationLoan(loan);

        interestDetailsRepository.save(entity);

        return dto;
    }


    public InterestDetailsDto getInterestDetails(UUID loanId) {
        InterestDetails details = interestDetailsRepository.findByEducationLoanId(loanId)
                .orElseThrow(() -> new ResourceNotFoundException("Interest details not found"));
        return mapper.toDto(details);
    }
}
