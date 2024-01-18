package com.rmorgner.taskmanager.service;

import com.rmorgner.taskmanager.model.TaskDTO;
import org.springframework.http.*;

import java.util.List;
import java.util.UUID;

public interface ITaskService {

  TaskDTO getTask(UUID id);

  List<TaskDTO> getAllTasks();

  void deleteTask(UUID id);

  TaskDTO updateTask(UUID id, TaskDTO taskDTO);

  TaskDTO createTask(TaskDTO taskDTO);

}
