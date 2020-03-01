package com.udomomo.springboottodo;

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
    public TaskEntity addTask(TaskEntity taskEntity) {
        return taskRepository.save(taskEntity);
    }

    @Transactional
    public void doneTask(String taskId) {
        TaskEntity targetTask = taskRepository.findById(Integer.valueOf(taskId))
                .orElseThrow(() -> new TaskNotExistException(taskId));
        targetTask.setDone(true);
        taskRepository.save(targetTask);
    }

    @Transactional
    public void undoneTask(String taskId) {
        TaskEntity targetTask = taskRepository.findById(Integer.valueOf(taskId))
                .orElseThrow(() -> new TaskNotExistException(taskId));
        targetTask.setDone(false);
        taskRepository.save(targetTask);
    }
}
