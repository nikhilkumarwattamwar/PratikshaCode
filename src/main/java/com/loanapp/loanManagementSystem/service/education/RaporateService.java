package com.loanapp.loanManagementSystem.service.education;

import com.loanapp.loanManagementSystem.repository.education.RaporateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RaporateService {
    @Autowired
    private RaporateRepository repoRateRepository;

    public double getCurrentRepoRate() {
        return repoRateRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Repo rate not configured"))
                .getRepoRate();
    }
}
