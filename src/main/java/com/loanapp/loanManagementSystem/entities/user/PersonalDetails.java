package com.loanapp.loanManagementSystem.entities.user;

import com.loanapp.loanManagementSystem.enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonalDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personalDetailId")
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @Column(name = "panNumber")
    private String panCardNumber;

    @Column(name = "aadharNumber")
    private String aadharNumber;

    @Column(name = "passportNumber")
    private String passportNumber;

    @Column(name = "voterIdNumber")
    private String voterIdNumber;

    @Column(name = "disability")
    private Disability disability;

    @Enumerated(EnumType.STRING)
    private Constitution constitution;

    @Enumerated(EnumType.STRING)
    private Religion religion;

    @Enumerated(EnumType.STRING)
    private Education education;

    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "isActive")
    private boolean isActive = true;

    @PrePersist
    public void onCreate() {
        this.isActive = true;
    }

}
