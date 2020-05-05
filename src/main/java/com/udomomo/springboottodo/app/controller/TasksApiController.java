package com.udomomo.springboottodo.app.controller;

import com.udomomo.springboottodo.api.spec.TasksApi;
import com.udomomo.springboottodo.app.resource.Success;
import com.udomomo.springboottodo.domain.exception.TaskNotExistException;
import com.udomomo.springboottodo.domain.model.TaskEntity;
import com.udomomo.springboottodo.domain.service.TaskService;
import com.udomomo.springboottodo.model.spec.TaskRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
public class TasksApiController implements TasksApi {
    private final TaskService taskService;

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @Override
    public ResponseEntity<List<TaskEntity>> listTasks() {
        return new ResponseEntity<>(taskService.listTasks(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TaskEntity> addTask(@Valid TaskRequest taskRequest) {
        return new ResponseEntity<>(taskService.addTask(taskRequest), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TaskEntity> editTask(String taskId, @Valid TaskRequest taskRequest) {
        return new ResponseEntity<>(taskService.editTask(taskId, taskRequest), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Success> doneTask(String taskId) {
        try {
            taskService.doneTask(taskId);
        } catch (NoSuchElementException ex) {
            throw new TaskNotExistException(taskId);
        }
        return new ResponseEntity<>(new Success(HttpStatus.OK.value(), "success"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Success> undoneTask(String taskId) {
        taskService.undoneTask(taskId);
        return new ResponseEntity<>(new Success(HttpStatus.OK.value(), "success"), HttpStatus.OK);
    }
}
