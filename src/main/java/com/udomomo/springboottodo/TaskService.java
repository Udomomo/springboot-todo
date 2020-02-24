package com.udomomo.springboottodo;

import com.udomomo.springboottodo.model.spec.Task;
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
}
