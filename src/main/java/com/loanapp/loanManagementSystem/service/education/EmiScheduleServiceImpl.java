package com.loanapp.loanManagementSystem.service.education;

import com.loanapp.loanManagementSystem.dto.education.EmiScheduleDto;
import com.loanapp.loanManagementSystem.entities.educationLoan.EMISchedule;
import com.loanapp.loanManagementSystem.entities.educationLoan.EducationLoan;
import com.loanapp.loanManagementSystem.entities.educationLoan.InterestDetails;
import com.loanapp.loanManagementSystem.enums.InterestType;
import com.loanapp.loanManagementSystem.enums.LoanStatus;
import com.loanapp.loanManagementSystem.exception.InvalidLoanStateException;
import com.loanapp.loanManagementSystem.exception.ResourceNotFoundException;
import com.loanapp.loanManagementSystem.mapper.education.EmiScheduleMapper;
import com.loanapp.loanManagementSystem.repository.education.EducationLoanRepository;
import com.loanapp.loanManagementSystem.repository.education.EmiScheduleRepository;
import com.loanapp.loanManagementSystem.repository.education.InterestDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class EmiScheduleServiceImpl implements EmiScheduleService {
    @Autowired
    EmiScheduleMapper mapper;
    @Autowired
    EmiScheduleRepository emiScheduleRepository;
    @Autowired
    InterestDetailsRepository interestDetailsRepository;
    @Autowired
    EducationLoanRepository educationLoanRepository;
    @Autowired
    RaporateService raporateService;

    @Transactional
    @Override
    public void generateEmiSchedule(UUID loanId) {
        EducationLoan loan = educationLoanRepository.findById(loanId)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found"));


        if (loan.getStatus() != LoanStatus.DISBURSED) {
            throw new InvalidLoanStateException(
                    "EMI can be generated only after loan disbursement"
            );
        }

        InterestDetails interest = interestDetailsRepository.findByEducationLoanId(loan.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Interest not calculated"));



        double principle=interest.getTotalAmountToRepay();

        double principal = interest.getTotalAmountToRepay();
        int months = loan.getRepaymentTenureMonths();

        double annualRate = loan.getInterestType() == InterestType.FIXED
                ? interest.getBaseInterest()
                : raporateService.getCurrentRepoRate();

        double monthlyRate = annualRate / (12 * 100);

        double emi = calculateEmi(principal, monthlyRate, months);

        LocalDate firstDueDate = loan.getDisbursementDate().plusMonths(1);


        double outstanding = principal;

        for (int month = 1; month <= months; month++) {

            double interestComponent = outstanding * monthlyRate;
            double principalComponent = emi - interestComponent;
            outstanding -= principalComponent;

            EMISchedule schedule = new EMISchedule();
            schedule.setEmiAmount(emi);
            schedule.setPrincipalComponent(principalComponent);
            schedule.setInterestComponent(interestComponent);
            schedule.setOutstandingPrincipal(outstanding);
            schedule.setEducationLoan(loan);

            emiScheduleRepository.save(schedule);
        }


    }

    public List<EmiScheduleDto> getEmiSchedule(UUID loanId) {
        List<EMISchedule> schedules = emiScheduleRepository.findByEducationLoanId(loanId);
        return schedules.stream().map(schedule->mapper.toDto(schedule)).toList();
    }

    private double calculateEmi(double principal, double rate, int months) {
        return principal * rate * Math.pow(1 + rate, months)
                / (Math.pow(1 + rate, months) - 1);
    }
}
