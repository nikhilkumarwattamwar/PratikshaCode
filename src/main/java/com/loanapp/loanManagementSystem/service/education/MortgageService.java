package com.loanapp.loanManagementSystem.service.education;

import com.loanapp.loanManagementSystem.dto.education.MortgageDetailsDto;

public interface MortgageService {

    MortgageDetailsDto createMortgage(Long collateralId,MortgageDetailsDto mortgageDetailsDto);

    void releaseMortgage(Long collateralId);

    boolean existsByCollateralId(Long collateralId);

}
