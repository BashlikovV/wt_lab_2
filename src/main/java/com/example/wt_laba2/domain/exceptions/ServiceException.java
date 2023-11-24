package com.example.wt_laba2.domain.exceptions;

public non-sealed class ServiceException extends AppExceptions {
    private static final long serialVersionUID = 1L;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Exception e) {
        super(e.getMessage());
    }

    public ServiceException(String message, Exception e) {
        super(message, e);
    }
}