package com.udomomo.springboottodo.domain.exception;

public class TaskNotExistException extends RuntimeException {
    public TaskNotExistException(String id) {
        super("No task exists with id " + id);
    }
}
