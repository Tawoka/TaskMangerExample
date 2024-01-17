package com.rmorgner.taskmanager.mapper;

import com.rmorgner.taskmanager.entity.Task;
import com.rmorgner.taskmanager.model.TaskDTO;

public interface ITaskMapper {

  TaskDTO mapEntityToDTO(Task task);

  Task mapDTOtoEntity(TaskDTO dto);

}
