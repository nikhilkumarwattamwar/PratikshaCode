package com.loanapp.loanManagementSystem.service.education;

import com.loanapp.loanManagementSystem.dto.education.MortgageDetailsDto;
import com.loanapp.loanManagementSystem.entities.educationLoan.Collateral;
import com.loanapp.loanManagementSystem.entities.educationLoan.Mortgage;
import com.loanapp.loanManagementSystem.exception.ResourceNotFoundException;
import com.loanapp.loanManagementSystem.mapper.education.MortgageMapper;
import com.loanapp.loanManagementSystem.repository.education.CollateralRepository;
import com.loanapp.loanManagementSystem.repository.education.MortgageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class MortgageServiceImpl implements MortgageService{

    @Autowired
    MortgageRepository mortgageRepository;
    @Autowired
    CollateralRepository collateralRepository;
    MortgageMapper mapper;

    @Override
    public MortgageDetailsDto createMortgage(Long collateralId, MortgageDetailsDto mortgageDetailsDto) {
        Collateral collateral =collateralRepository.findById(collateralId).orElseThrow(()->new ResourceNotFoundException("Collateral not found"));

        Mortgage mortgage= new Mortgage();
        mortgage.setCollateral(collateral);
        mortgage.setPropertyAddress(mortgageDetailsDto.getPropertyAddress());
        mortgage.setPropertyValue(mortgageDetailsDto.getPropertyValue());
        mortgage.setMortgageReleased(false);

        Mortgage saved=mortgageRepository.save(mortgage);
        return mapper.toDto(saved);
    }

    @Override
    public void releaseMortgage(Long collateralId) {

        Mortgage mortgage=mortgageRepository.findByCollateralId(collateralId)
                .orElseThrow(()->new ResourceNotFoundException("Mortgage not found "));

        mortgage.setMortgageReleased(true);
        mortgage.setMortgageReleaseDate(LocalDateTime.now());

        Mortgage released=mortgageRepository.save(mortgage);
    }

    @Override
    public boolean existsByCollateralId(Long collateralId) {
        return mortgageRepository.existsByCollateralId(collateralId);
    }
}
