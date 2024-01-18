package com.rmorgner.taskmanager.service;

import com.rmorgner.taskmanager.model.TaskDTO;
import org.springframework.stereotype.*;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService implements ITaskService {


  @Override
  public TaskDTO getTask(UUID id) {
    return null;
  }

  @Override
  public List<TaskDTO> getAllTasks() {
    return null;
  }

  @Override
  public void deleteTask(UUID id) {

  }

  @Override
  public void updateTask(UUID id, TaskDTO taskDTO) {

  }

  @Override
  public void createTask(TaskDTO taskDTO) {

  }
}
