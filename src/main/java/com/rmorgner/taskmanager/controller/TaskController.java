package com.rmorgner.taskmanager.controller;

import com.rmorgner.taskmanager.model.TaskDTO;
import com.rmorgner.taskmanager.service.ITaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/task")
public class TaskController implements ITaskController{

  private static final String ID_PLACEHOLDER = "{taskId}";
  private static final String API_STRING = "/api/v1/task";
  private static final String ID_FIELD = "taskId";

  private final ITaskService service;

  @Override
  @RequestMapping(value = ID_PLACEHOLDER, method = RequestMethod.GET)
  public TaskDTO getTask(@PathVariable(ID_FIELD) UUID id) {
    log.debug("Requesting task with id: " + id);

    return service.getTask(id);
  }

  @Override
  @RequestMapping(method = RequestMethod.GET)
  public List<TaskDTO> getAllTasks() {
    log.debug("Requesting all tasks");

    return service.getAllTasks();
  }

  @Override
  public ResponseEntity<Void> deleteTask(UUID id) {
    log.debug("Deleting task with id: " + id);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @Override
  @RequestMapping(value = ID_PLACEHOLDER, method = RequestMethod.PUT)
  public ResponseEntity<Void> updateTask(@PathVariable(ID_FIELD) UUID id,
                                         @RequestBody TaskDTO taskDTO) {
    log.debug("Updating task with id: " + id);

    TaskDTO dto = service.updateTask(id, taskDTO);
    if (dto.getName().isEmpty()){
      throw new NotFoundException();
    }

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @Override
  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Void> createTask(@RequestBody TaskDTO taskDTO) {
    TaskDTO task = service.createTask(taskDTO);

    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("Location", API_STRING + "/" + task.getId().toString());

    return new ResponseEntity<>(httpHeaders, HttpStatus.NO_CONTENT);
  }
}
