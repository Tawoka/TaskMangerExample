package com.rmorgner.taskmanager.service;

import com.rmorgner.taskmanager.entity.Task;
import com.rmorgner.taskmanager.mapper.TaskMapper;
import com.rmorgner.taskmanager.model.TaskDTO;
import com.rmorgner.taskmanager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.*;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService implements ITaskService {

  private final TaskRepository taskRepository;
  private final TaskMapper taskMapper;

  @Override
  public TaskDTO getTask(UUID id) {
    return null;
  }

  @Override
  public List<TaskDTO> getAllTasks() {
    List<Task> allTasks = taskRepository.findAll();
    return allTasks.stream()
        .map(taskMapper::mapEntityToDTO)
        .toList();
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
