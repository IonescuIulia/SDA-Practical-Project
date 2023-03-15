package com.sda.practicalproject1.repository.exception;

public class EntityUpdateFailedException extends Exception{
    public EntityUpdateFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
