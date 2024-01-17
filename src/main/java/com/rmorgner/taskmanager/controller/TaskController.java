package com.rmorgner.taskmanager.controller;

import com.rmorgner.taskmanager.model.TaskDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/task")
public class TaskController implements ITaskController{


  @Override
  public ResponseEntity<TaskDTO> getTask(UUID id) {
    return null;
  }

  @Override
  public ResponseEntity<List<TaskDTO>> getAllTasks() {
    return null;
  }

  @Override
  public ResponseEntity<Void> deleteTask(UUID id) {
    return null;
  }

  @Override
  public ResponseEntity<Void> updateTask(UUID id, TaskDTO taskDTO) {
    return null;
  }

  @Override
  public ResponseEntity<Void> createTask(TaskDTO taskDTO) {
    return null;
  }
}
