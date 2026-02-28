package com.loanapp.loanManagementSystem.service.education;

import com.loanapp.loanManagementSystem.dto.education.EmiScheduleDto;

import java.util.UUID;

public interface EmiScheduleService {

    void generateEmiSchedule(UUID loanId);

}
