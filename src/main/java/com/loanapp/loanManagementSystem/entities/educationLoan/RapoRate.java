package com.loanapp.loanManagementSystem.entities.educationLoan;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RapoRate {

    @Id
    private Long id = 1L;
    private Double repoRate;

}
