package com.rmorgner.taskmanager.controller;

import com.rmorgner.taskmanager.model.TaskDTO;
import org.springframework.http.*;

import java.util.List;
import java.util.UUID;

public interface ITaskController {

  /**
   * Single GET-METHOD to retrieve one task from the database.
   *
   * @param id - provide the UUID to identify the task you are looking for
   * @return the complete data object of the task entity
   */
  TaskDTO getTask(UUID id);

  /**
   * Full GET-METHOD to retrieve all tasks from the database.
   *
   * @return a complete list of all tasks currently stored in the database
   */
  List<TaskDTO> getAllTasks();

  /**
   * Simple DELETE-METHOD to remove one task from the database.
   * NOTE: Success is defined by the task not being in the database. Not finding a task with the given
   * id is therefore a success.
   *
   * @param id - provide the UUID to identify the task you wish to delete
   * @return simple HTTP-Response to signal success or failure
   */
  ResponseEntity<Void> deleteTask(UUID id);

  /**
   * Simple PUT-METHOD to change the data of a given task.
   * NOTE: Only the fields NAME, PRIORITY, and DONE can be changed.
   *
   * @param id - provide the UUID to identify the task you wish to change
   * @param taskDTO - provide the data object with the new values
   * @return simple HTTP-Response to signal success or failure
   */
  ResponseEntity<Void> updateTask(UUID id, TaskDTO taskDTO);

  /**
   * Simple POST-METHOD to create a new task.
   * NOTE: Only the fields NAME, PRIORITY, and DONE are accepted in this method.
   *
   * @param taskDTO - provide the data object you wish to create in the database.
   * @return HTTP-Response to signal success or failure; includes the location of the new resource
   */
  ResponseEntity<Void> createTask(TaskDTO taskDTO);

}
