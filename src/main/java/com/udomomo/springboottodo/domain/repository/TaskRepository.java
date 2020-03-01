package com.udomomo.springboottodo.domain.repository;

import com.udomomo.springboottodo.domain.model.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {

}
