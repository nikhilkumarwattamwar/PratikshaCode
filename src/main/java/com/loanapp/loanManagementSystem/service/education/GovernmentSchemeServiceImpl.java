package com.loanapp.loanManagementSystem.service.education;

import com.loanapp.loanManagementSystem.entities.educationLoan.EducationLoan;
import com.loanapp.loanManagementSystem.entities.educationLoan.GovernmentScheme;
import com.loanapp.loanManagementSystem.enums.SchemeApprovalStatus;
import com.loanapp.loanManagementSystem.exception.ResourceNotFoundException;
import com.loanapp.loanManagementSystem.repository.education.GovernmentSchemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GovernmentSchemeServiceImpl {

    @Autowired
    private GovernmentSchemeRepository repository;

    public void approveScheme(Long schemeId) {
        GovernmentScheme scheme = repository.findById(schemeId)
                .orElseThrow(() -> new RuntimeException("Scheme not found"));

        scheme.setApprovalStatus(SchemeApprovalStatus.APPROVED);
        repository.save(scheme);
    }


    public boolean isSubsidyApplicable(EducationLoan loan) {
        return loan.getGovernmentSchemes() != null
                && loan.getGovernmentSchemes().getApprovalStatus().equals(SchemeApprovalStatus.APPROVED) ;
    }

    public double getSubsidyPercentage(EducationLoan loan) {
        return loan.getGovernmentSchemes().getSubsidyAmount();
    }

    public String getSchemeName(EducationLoan loan) {
        return loan.getGovernmentSchemes().getSchemeType().toString();
    }
}
