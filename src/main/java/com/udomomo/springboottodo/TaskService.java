package com.udomomo.springboottodo;

import com.udomomo.springboottodo.model.spec.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
        TaskEntity targetTask = taskRepository.findById(Integer.valueOf(taskId)).get();
        targetTask.setDone(true);
        taskRepository.save(targetTask);
    }

    @Transactional
    public void undoneTask(String taskId) {
        TaskEntity targetTask = taskRepository.findById(Integer.valueOf(taskId)).get();
        targetTask.setDone(false);
        taskRepository.save(targetTask);
    }
}
