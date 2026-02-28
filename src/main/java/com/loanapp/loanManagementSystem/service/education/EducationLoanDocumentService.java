package com.loanapp.loanManagementSystem.service.education;

import com.loanapp.loanManagementSystem.dto.education.EducationLoanDocumentDto;
import com.loanapp.loanManagementSystem.dto.loan.DocumentsDto;
import com.loanapp.loanManagementSystem.enums.DocumentType;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface EducationLoanDocumentService {
    void uploadDocument(UUID educationLoanId, DocumentType documentType, MultipartFile file);

    void validateDocuments(UUID loanId);

    void rejectDocument(Long documentId, String reason);

    void approveDocument(Long documentId);

}
