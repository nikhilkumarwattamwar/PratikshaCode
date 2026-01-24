package com.loanapp.loanManagementSystem.enums;

public enum NPAStatus {
    STANDARD,           // 0-29 days overdue
    SMA_0,              // 30-59 days overdue
    SMA_1,              // 60-89 days overdue
    SMA_2,              // 90 days (becoming NPA)
    NPA_SUB_STANDARD,   // NPA < 12 months
    NPA_DOUBTFUL,       // NPA 12-24 months
    NPA_LOSS            // NPA > 24 months (loss asset)
}
