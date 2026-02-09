package com.loanapp.loanManagementSystem.service.education;

import com.loanapp.loanManagementSystem.dto.education.CollateralDetailsDto;
import com.loanapp.loanManagementSystem.entities.educationLoan.Collateral;
import com.loanapp.loanManagementSystem.entities.educationLoan.EducationLoan;
import com.loanapp.loanManagementSystem.enums.CollateralType;
import com.loanapp.loanManagementSystem.exception.ResourceNotFoundException;
import com.loanapp.loanManagementSystem.mapper.education.CollateralMapper;
import com.loanapp.loanManagementSystem.repository.education.CollateralRepository;
import com.loanapp.loanManagementSystem.repository.education.EducationLoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
@Service
public class CollateralServiceImpl implements CollateralService{

    @Autowired
    EducationLoanRepository educationLoanRepository;
    @Autowired
    CollateralRepository collateralRepository;
    CollateralMapper mapper;
    @Autowired
    MortgageService mortgageService;

    @Override
    public CollateralDetailsDto addCollateralDetails(UUID loanId, CollateralDetailsDto collateralDetailsDto) {

        EducationLoan loan =educationLoanRepository.findById(loanId).orElseThrow(()->new ResourceNotFoundException("Education loan details not found for the given id"));

        Collateral collateral= new Collateral();
        collateral.setCollateralType(collateralDetailsDto.getCollateralType());
        collateral.setDescription(collateralDetailsDto.getDescription());
        collateral.setCollateralValue(collateralDetailsDto.getCollateralValue());
        collateral.setEducationLoan(loan);
        collateral.setCreatedAt(LocalDateTime.now());

        Collateral saved=collateralRepository.save(collateral);

        if(collateralDetailsDto.getCollateralType()==CollateralType.PROPERTY && collateralDetailsDto.getMortgageDetailsDto()!=null){
            mortgageService.createMortgage(saved.getId(), collateralDetailsDto.getMortgageDetailsDto());
        }
        return mapper.toDto(saved);
    }

    @Override
    public void validateCollateral(UUID loanId) {
        EducationLoan loan = educationLoanRepository.findById(loanId)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found"));

        double loanAmount = loan.getApprovedAmount().doubleValue();

        Collateral collateral = collateralRepository.findByEducationLoanId(loanId)
                .orElse(null);

        if (loanAmount > 750000 && collateral == null) {
            throw new IllegalStateException("Collateral is mandatory for loan amount above 7.5L");
        }

        if (collateral == null) {
            return;
        }

        if (collateral.getCollateralValue() < loanAmount) {
            throw new IllegalStateException("Collateral value is less than loan amount");
        }

        if (collateral.getCollateralType() == CollateralType.PROPERTY) {
            boolean mortgageExists = mortgageService.existsByCollateralId(collateral.getId());

            if (!mortgageExists) {
                throw new IllegalStateException("Mortgage details missing for property collateral");
            }
        }
    }
}
