package com.loanapp.loanManagementSystem.service.education;

import com.loanapp.loanManagementSystem.dto.education.EducationLoanDocumentDto;
import com.loanapp.loanManagementSystem.entities.educationLoan.EducationLoan;
import com.loanapp.loanManagementSystem.entities.educationLoan.EducationLoanDocuments;
import com.loanapp.loanManagementSystem.enums.DocumentType;
import com.loanapp.loanManagementSystem.enums.VerificationStatus;
import com.loanapp.loanManagementSystem.exception.ResourceNotFoundException;
import com.loanapp.loanManagementSystem.mapper.education.EducationDocumentMapper;
import com.loanapp.loanManagementSystem.repository.education.EducationLoanDocumentRepository;
import com.loanapp.loanManagementSystem.repository.education.EducationLoanRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;
@Service
public class EducationLoanDocumentServiceImpl implements EducationLoanDocumentService{

    @Autowired
    EducationLoanRepository educationLoanRepository;

    @Autowired
    EducationLoanDocumentRepository documentRepository;

    @Autowired
    EducationDocumentMapper mapper;

    @Override
    public void uploadDocument(UUID educationLoanId, DocumentType documentType, MultipartFile file) {
        EducationLoan loan = educationLoanRepository.findById(educationLoanId).orElseThrow(() -> {
            return new ResourceNotFoundException("Loan not found");
        });

        try {
            EducationLoanDocuments documents= new EducationLoanDocuments();
            documents.setEducationLoan(loan);
            documents.setType(documentType);
            documents.setVerificationStatus(VerificationStatus.PENDING);
            documents.setFileData(file.getBytes());

            EducationLoanDocuments saved = documentRepository.save(documents);

        } catch (Exception e) {
            throw new RuntimeException("failed to store a document");
        }
    }

    public void validateDocuments(UUID loanId) {

        List<EducationLoanDocuments> docs =
                documentRepository.findByEducationLoanId(loanId).orElseThrow(()->new ResourceNotFoundException("Documents not found"));

        boolean allApproved = docs.stream()
                .allMatch(d -> d.getVerificationStatus() == VerificationStatus.VERIFIED);

        if (!allApproved) {
            throw new IllegalStateException("Documents not verified");
        }
    }

    @Transactional
    public void rejectDocument(Long documentId, String reason) {

        EducationLoanDocuments doc = documentRepository.findById(documentId)
                .orElseThrow(() -> new ResourceNotFoundException("Document not found"));

        if (doc.getVerificationStatus() == VerificationStatus.VERIFIED) {
            throw new IllegalStateException("Verified document cannot be rejected");
        }

        doc.setVerificationStatus(VerificationStatus.REJECTED);
        doc.setRejectionReason(reason);

        documentRepository.save(doc);
    }

    @Transactional
    public void approveDocument(Long documentId) {

        EducationLoanDocuments doc = documentRepository.findById(documentId)
                .orElseThrow(() -> new ResourceNotFoundException("Document not found"));

        doc.setVerificationStatus(VerificationStatus.VERIFIED);
        doc.setRejectionReason(null);

        documentRepository.save(doc);
    }

}
