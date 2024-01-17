package com.rmorgner.taskmanager.mapper;

import com.rmorgner.taskmanager.entity.Task;
import com.rmorgner.taskmanager.model.TaskDTO;

public class TaskMapper implements ITaskMapper {
  @Override
  public TaskDTO mapEntityToDTO(Task task) {
    return TaskDTO.builder()
        .name(task.getName())
        .created(task.getCreated())
        .id(task.getId())
        .done(task.isDone())
        .priority(task.getPriority())
        .build();
  }

  @Override
  public Task mapDTOtoEntity(TaskDTO dto) {
    return Task.builder()
        .name(dto.getName())
        .created(dto.getCreated())
        .id(dto.getId())
        .done(dto.isDone())
        .priority(dto.getPriority())
        .build();
  }
}
