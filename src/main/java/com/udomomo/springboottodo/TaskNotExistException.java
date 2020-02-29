package com.udomomo.springboottodo;

public class TaskNotExistException extends RuntimeException {
    public TaskNotExistException(String id) {
        super("No task exists with id " + id);
    }
}
