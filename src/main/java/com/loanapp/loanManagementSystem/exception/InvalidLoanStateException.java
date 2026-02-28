package com.loanapp.loanManagementSystem.exception;

public class InvalidLoanStateException extends RuntimeException{
    public InvalidLoanStateException(String msg){
        super(msg);
    }
}
