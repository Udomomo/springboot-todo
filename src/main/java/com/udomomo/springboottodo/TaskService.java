package com.udomomo.springboottodo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
        Optional<TaskEntity> targetTask = taskRepository.findById(Integer.valueOf(taskId));
        if (targetTask.isPresent()) {
            TaskEntity task = targetTask.get();
            task.setDone(true);
            taskRepository.save(task);
        } else {
            throw new NoSuchElementException();
        }
    }

    @Transactional
    public void undoneTask(String taskId) {
        Optional<TaskEntity> targetTask = taskRepository.findById(Integer.valueOf(taskId));
        if (targetTask.isPresent()) {
            TaskEntity task = targetTask.get();
            task.setDone(false);
            taskRepository.save(task);
        } else {
            throw new TaskNotExistException(taskId);
        }
    }
}
