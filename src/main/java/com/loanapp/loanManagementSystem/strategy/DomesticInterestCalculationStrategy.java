package com.loanapp.loanManagementSystem.strategy;

import com.loanapp.loanManagementSystem.dto.education.EducationLoanDetailsDto;
import com.loanapp.loanManagementSystem.dto.education.InterestDetailsDto;
import com.loanapp.loanManagementSystem.entities.educationLoan.EducationLoan;
import com.loanapp.loanManagementSystem.enums.InterestType;
import com.loanapp.loanManagementSystem.enums.StudyLocation;
import com.loanapp.loanManagementSystem.service.education.GovernmentSchemeServiceImpl;
import com.loanapp.loanManagementSystem.service.education.RaporateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomesticInterestCalculationStrategy implements InterestCalculationStrategy{
    private static final double FIXED_RATE = 9.5;
    private static final double FEMALE_DISCOUNT = 0.25;

    @Autowired
    private  RaporateService repoRateService;
    @Autowired
    private  GovernmentSchemeServiceImpl governmentSchemeService;

    public DomesticInterestCalculationStrategy(RaporateService repoRateService, GovernmentSchemeServiceImpl governmentSchemeService) {
        this.repoRateService = repoRateService;
        this.governmentSchemeService = governmentSchemeService;
    }


    @Override
    public boolean hasLocation(StudyLocation location) {
        return location == StudyLocation.DOMESTIC;
    }

    @Override
    public InterestDetailsDto calculate(EducationLoan loan) {

        double principal = loan.getLoanAmount().doubleValue();
        int years = loan.getMoratoriumPeriodMonths() / 12;

        boolean isFemale = loan.getEligibilityDetails().getIsStudentFemale();
        boolean subsidized = governmentSchemeService.isSubsidyApplicable(loan);

        double rate;

        if (loan.getInterestType() == InterestType.FIXED) {
            rate = FIXED_RATE;
        } else {
            rate = repoRateService.getCurrentRepoRate();
        }

        if (isFemale) {
            rate -= FEMALE_DISCOUNT;
        }

        if (subsidized) {
            rate -= governmentSchemeService.getSubsidyPercentage(loan);
        }

        double interest;

        if (loan.getInterestType() == InterestType.FLOATING) {
            interest = calculateFloating(principal, rate, years);
        } else {
            interest = principal * rate * years / 100;
        }

        InterestDetailsDto dto = new InterestDetailsDto();
        dto.setInterestType(loan.getInterestType());
        dto.setIsStudentFemale(isFemale);
        dto.setFemaleStudentDiscount(isFemale ? FEMALE_DISCOUNT : 0.0);
        dto.setBaseInterest(rate);
        dto.setInterestDuringStudy(interest);
        dto.setAccumulatedInterest(interest);
        dto.setIsSubsidized(subsidized);
        dto.setSubsidyPercentage(subsidized ? governmentSchemeService.getSubsidyPercentage(loan) : 0.0);
        dto.setSubsidyScheme(subsidized ? governmentSchemeService.getSchemeName(loan) : null);
        dto.setPrincipalAmount(principal);
        dto.setStudyPeriodYears(years);
        dto.setCalculatedInterestDuringStudy(interest);
        dto.setTotalAmountToRepay(principal + interest);
        dto.setEducationLoanId(loan.getId());

        return dto;
    }

    private double calculateFloating(double principal, double rate, int years) {

        double amount = principal;

        for (int year = 1; year <= years; year++) {
            amount += amount * rate / 100;
        }

        return amount - principal;
    }
}

