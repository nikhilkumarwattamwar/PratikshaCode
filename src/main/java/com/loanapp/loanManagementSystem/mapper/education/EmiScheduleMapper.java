package com.loanapp.loanManagementSystem.mapper.education;

import com.loanapp.loanManagementSystem.dto.education.EmiScheduleDto;
import com.loanapp.loanManagementSystem.entities.educationLoan.EMISchedule;
import org.mapstruct.Mapper;
import org.springframework.jmx.export.annotation.ManagedNotification;

@Mapper(componentModel = "spring")
public interface EmiScheduleMapper {
    EMISchedule toEntity(EmiScheduleDto emiScheduleDto);
    EmiScheduleDto toDto(EMISchedule emiSchedule);
}
