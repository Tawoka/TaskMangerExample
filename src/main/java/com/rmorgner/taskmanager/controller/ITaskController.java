package com.rmorgner.taskmanager.controller;

import com.rmorgner.taskmanager.model.TaskDTO;
import org.springframework.http.*;

import java.util.List;
import java.util.UUID;

public interface ITaskController {

  TaskDTO getTask(UUID id);

  List<TaskDTO> getAllTasks();

  ResponseEntity<Void> deleteTask(UUID id);

  ResponseEntity<Void> updateTask(UUID id, TaskDTO taskDTO);

  ResponseEntity<Void> createTask(TaskDTO taskDTO);

}
