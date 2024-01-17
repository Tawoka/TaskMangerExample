package com.rmorgner.taskmanager.repository;

import com.rmorgner.taskmanager.entity.Task;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {

  Task findByName(String name);

  Page<Task> findAllByNameIsLikeIgnoreCase(String name, Pageable pageable);

}
