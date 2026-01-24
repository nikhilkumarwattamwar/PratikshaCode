package com.loanapp.loanManagementSystem.entities.educationLoan;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mortgage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mortgageId;

    private String propertyAddress;
    private Double propertyValue;
    private Boolean mortgageReleased;
    LocalDateTime mortgageReleaseDate;

    @OneToOne
    @JoinColumn(name = "collateral_id", unique = true)
    private Collateral collateral;
}
