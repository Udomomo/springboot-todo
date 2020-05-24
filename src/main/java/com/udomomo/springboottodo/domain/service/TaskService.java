package com.udomomo.springboottodo.domain.service;

import com.udomomo.springboottodo.domain.exception.TaskNotExistException;
import com.udomomo.springboottodo.domain.model.TaskEntity;
import com.udomomo.springboottodo.domain.repository.TaskRepository;
import com.udomomo.springboottodo.model.spec.TaskRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    @Transactional(readOnly = true)
    public List<TaskEntity> listTasks() {
        return taskRepository.findAll();
    }

    @Transactional
    public TaskEntity addTask(TaskRequest taskRequest) {
        TaskEntity taskEntity = new TaskEntity(
                taskRequest.getContent(),
                taskRequest.getUrgency(),
                taskRequest.getImportance()
        );
        return taskRepository.save(taskEntity);
    }

    @Transactional
    public TaskEntity editTask(String taskId, TaskRequest taskRequest) {
        TaskEntity targetTask = taskRepository.findById(Integer.valueOf(taskId))
                .orElseThrow(() -> new TaskNotExistException(taskId));
        TaskEntity taskEntity = new TaskEntity(
                targetTask.getId(),
                taskRequest.getContent(),
                taskRequest.getUrgency(),
                taskRequest.getImportance()
        );
        return taskRepository.save(taskEntity);
    }

    @Transactional
    public void doneTask(String taskId) {
        TaskEntity targetTask = taskRepository.findById(Integer.valueOf(taskId))
                .orElseThrow(() -> new TaskNotExistException(taskId));
        targetTask.makeDone();
        taskRepository.save(targetTask);
    }

    @Transactional
    public void undoneTask(String taskId) {
        TaskEntity targetTask = taskRepository.findById(Integer.valueOf(taskId))
                .orElseThrow(() -> new TaskNotExistException(taskId));
        targetTask.makeUndone();
        taskRepository.save(targetTask);
    }
}
