package com.loanapp.loanManagementSystem.strategy;

import com.loanapp.loanManagementSystem.dto.user.InterestDetailsDto;
import com.loanapp.loanManagementSystem.entities.educationLoan.EducationLoan;
import com.loanapp.loanManagementSystem.enums.InterestType;
import com.loanapp.loanManagementSystem.enums.StudyLocation;
import org.springframework.stereotype.Service;

@Service
public class DomesticInterestCalculationStrategy implements InterestCalculationStrategy{
    private static final double FIXED_BASE = 9.5;
    private static final double FLOATING_BASE = 8.75;
    private static final double FEMALE_DISCOUNT = 0.25;

    @Override
    public boolean hasLocation(StudyLocation studyLocation) {
        return studyLocation.equals(StudyLocation.DOMESTIC);
    }

    @Override
    public InterestDetailsDto calculate(EducationLoan loan) {
        double baseRate = loan.getInterestType() == InterestType.FIXED ? FIXED_BASE : FLOATING_BASE;

        double effectiveRate = baseRate;

        boolean isFemale = loan.getEligibilityDetails().getIsStudentFemale();
        if (isFemale) {
            effectiveRate -= FEMALE_DISCOUNT;
        }

        int studyYears = loan.getMoratoriumPeriodMonths() / 12;
        double principal = loan.getApprovedAmount().doubleValue();

        double interestDuringStudy;

        if (loan.getInterestType() == InterestType.FLOATING) {
            interestDuringStudy = calculateFloatingInterest(principal, effectiveRate, studyYears);
        } else {
            interestDuringStudy = principal * effectiveRate * studyYears / 100;
        }

        return buildDto(loan, baseRate, interestDuringStudy, isFemale);
    }

    private double calculateFloatingInterest(double principal, double initialRate, int years) {

        double amount = principal;
        double rate = initialRate;

        for (int year = 1; year <= years; year++) {
            double yearlyInterest = amount * rate / 100;
            amount += yearlyInterest;

            rate += 0.10;
        }

        return amount - principal;
    }

    private InterestDetailsDto buildDto(EducationLoan loan, double baseRate, double interestDuringStudy, boolean isFemale) {

        double principal = loan.getApprovedAmount().doubleValue();

        InterestDetailsDto dto = new InterestDetailsDto();
        dto.setInterestType(loan.getInterestType());
        dto.setIsStudentFemale(isFemale);
        dto.setFemaleStudentDiscount(isFemale ? FEMALE_DISCOUNT : 0.0);
        dto.setBaseInterest(baseRate);
        dto.setInterestDuringStudy(interestDuringStudy);
        dto.setAccumulatedInterest(interestDuringStudy);
        dto.setPrincipalAmount(principal);
        dto.setStudyPeriodYears(loan.getMoratoriumPeriodMonths() / 12);
        dto.setCalculatedInterestDuringStudy(interestDuringStudy);
        dto.setTotalAmountToRepay(principal + interestDuringStudy);
        dto.setEducationLoanId(loan.getId());

        return dto;
    }
}

