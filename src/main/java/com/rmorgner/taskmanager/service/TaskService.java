package com.rmorgner.taskmanager.service;

import com.rmorgner.taskmanager.entity.Task;
import com.rmorgner.taskmanager.mapper.TaskMapper;
import com.rmorgner.taskmanager.model.TaskDTO;
import com.rmorgner.taskmanager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService implements ITaskService {

  private static final TaskDTO EMPTY = TaskDTO.builder().build();

  private final TaskRepository taskRepository;
  private final TaskMapper taskMapper;

  @Override
  public TaskDTO getTask(UUID id) {
    Optional<Task> task = taskRepository.findById(id);
    if (task.isPresent()){
      return taskMapper.mapEntityToDTO(task.get());
    }
    return EMPTY;
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
    taskRepository.deleteById(id);
  }

  @Override
  public void updateTask(UUID id, TaskDTO taskDTO) {
    Optional<Task> optionalTask = taskRepository.findById(id);
    if (optionalTask.isPresent()){
      Task task = optionalTask.get();
      task.setDone(taskDTO.isDone());
      task.setPriority(taskDTO.getPriority());
      task.setName(taskDTO.getName());
      taskRepository.save(task);
    }
  }

  @Override
  public TaskDTO createTask(TaskDTO taskDTO) {
    Task task = taskRepository.save(taskMapper.mapDTOtoEntity(taskDTO));
    return taskMapper.mapEntityToDTO(task);
  }
}
