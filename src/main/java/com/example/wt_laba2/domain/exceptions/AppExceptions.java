package com.example.wt_laba2.domain.exceptions;

public sealed class AppExceptions
        extends RuntimeException
        permits CommandException, DAOException, ProjectException, ServiceException {

    /**
     * Constructs a new ProjectException with no specified detail message.
     */
    public AppExceptions() {
        super();
    }

    /**
     * Constructs a new ProjectException with the specified detail message.
     *
     * @param message The detail message (which is saved for later retrieval by the getMessage() method).
     */
    public AppExceptions(String message) {
        super(message);
    }

    /**
     * Constructs a new ProjectException with the specified detail message and cause.
     *
     * @param message The detail message (which is saved for later retrieval by the getMessage() method).
     * @param ex      The cause (which is saved for later retrieval by the getCause() method).
     */
    public AppExceptions(String message, Exception ex) {
        super(message);
    }

}