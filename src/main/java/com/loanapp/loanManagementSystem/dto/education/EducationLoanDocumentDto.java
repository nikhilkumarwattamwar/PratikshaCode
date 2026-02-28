package com.loanapp.loanManagementSystem.dto.education;

import com.loanapp.loanManagementSystem.enums.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EducationLoanDocumentDto {
    private Integer documentId;
    private DocumentType documentType;
    private String fileName;
    private String contentType;
}
