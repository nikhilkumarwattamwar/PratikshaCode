package com.loanapp.loanManagementSystem.service.education;

import com.loanapp.loanManagementSystem.dto.education.CollateralDetailsDto;

import java.util.UUID;

public interface CollateralService {

    CollateralDetailsDto addCollateralDetails(UUID loanId,CollateralDetailsDto collateralDetailsDto);
}
