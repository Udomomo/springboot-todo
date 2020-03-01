package com.udomomo.springboottodo;

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
                taskRequest.getImportance(),
                false
        );
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
