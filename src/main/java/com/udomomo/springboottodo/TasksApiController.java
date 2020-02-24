package com.udomomo.springboottodo;

import com.udomomo.springboottodo.api.spec.TasksApi;
import com.udomomo.springboottodo.model.spec.Task;
import com.udomomo.springboottodo.model.spec.TaskRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TasksApiController implements TasksApi {
    private final TaskService taskService;

    @Override
    public ResponseEntity<List<TaskEntity>> listTasks() {
        return new ResponseEntity<>(taskService.listTasks(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TaskEntity> addTask(@Valid TaskRequest taskRequest) {
        TaskEntity taskEntity = new TaskEntity(
                taskRequest.getContent(),
                taskRequest.getUrgency(),
                taskRequest.getImportance(),
                false
        );

        return new ResponseEntity<>(taskService.addTask(taskEntity), HttpStatus.OK);
    }
}
