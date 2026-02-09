package com.loanapp.loanManagementSystem.service.education;

import com.loanapp.loanManagementSystem.dto.education.EducationLoanDetailsDto;
import com.loanapp.loanManagementSystem.entities.educationLoan.EducationLoan;
import com.loanapp.loanManagementSystem.entities.user.User;
import com.loanapp.loanManagementSystem.enums.LoanStatus;
import com.loanapp.loanManagementSystem.exception.InvalidLoanStateException;
import com.loanapp.loanManagementSystem.exception.ResourceNotFoundException;
import com.loanapp.loanManagementSystem.mapper.education.EducationLoanMapper;
import com.loanapp.loanManagementSystem.repository.UserRepository;
import com.loanapp.loanManagementSystem.repository.education.EducationLoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;
@Service
public class EducationLoanServiceImpl implements EducationLoanService{

    @Autowired
    EducationLoanRepository educationLoanRepository;
    @Autowired
    EligibilityDetailsService eligibilityDetailsService;
    @Autowired
    InstitutionDetailsService institutionDetailsService;
    @Autowired
    EducationLoanMapper mapper;
    @Autowired
    UserRepository userRepository;
    @Autowired
    InterestDetailsService interestDetailsService;
    @Autowired
    CollateralService collateralService;
    @Autowired
    EmiScheduleService emiScheduleService;
    @Autowired
    CoApplicantService coApplicantService;
    @Autowired
    EducationLoanDocumentService documentService;

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

    @Override
    public void approveLoan(UUID loanId) {

        EducationLoan loan =  educationLoanRepository.findById(loanId)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found"));

        if (loan.getStatus() != LoanStatus.APPLIED) {
            throw new IllegalStateException("Loan not in APPLIED state");
        }

        eligibilityDetailsService.evaluateEligibility(loanId);
        coApplicantService.validateCoApplicants(loanId);
        collateralService.validateCollateral(loanId);
        documentService.validateDocuments(loanId);

        loan.setStatus(LoanStatus.APPROVED);
        educationLoanRepository.save(loan);
    }

    @Override
    public void disburseLoan(UUID loanId) {

        EducationLoan loan =  educationLoanRepository.findById(loanId)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found"));

        if (loan.getStatus() != LoanStatus.APPROVED) {
            throw new InvalidLoanStateException("Loan must be approved first");
        }

        loan.setStatus(LoanStatus.DISBURSED);
        loan.setDisbursementDate(LocalDate.now());
        loan.setDisbursedAmount(loan.getLoanAmount());

        educationLoanRepository.save(loan);

        interestDetailsService.calculateInterest(loanId);
        emiScheduleService.generateEmiSchedule(loanId);

    }
}
