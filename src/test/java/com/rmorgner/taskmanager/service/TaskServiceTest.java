package com.rmorgner.taskmanager.service;

import com.rmorgner.taskmanager.entity.Priority;
import com.rmorgner.taskmanager.model.TaskDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class TaskServiceTest {

  @Autowired
  TaskService taskService;

  @Test
  void getTask() {
    List<TaskDTO> allTasks = taskService.getAllTasks();
    TaskDTO taskDTO = allTasks.get(0);
    TaskDTO task = taskService.getTask(taskDTO.getId());
    assertThat(task.getName()).isEqualTo(taskDTO.getName());
  }

  @Test
  void getEmptyTask() {
    TaskDTO task = taskService.getTask(UUID.randomUUID());
    assertThat(task.getName()).isEmpty();
  }

  @Test
  void getAllTasks() {
    List<TaskDTO> allTasks = taskService.getAllTasks();
    assertThat(allTasks).hasSize(2);
  }

  @Test
  void deleteTask() {
    String taskName = "test task";
    TaskDTO testTask = TaskDTO.builder()
        .name(taskName)
        .priority(Priority.LOW)
        .build();
    TaskDTO taskDTO = taskService.createTask(testTask);
    assertThat(taskDTO.getName()).isNotEmpty();
    taskService.deleteTask(taskDTO.getId());
    TaskDTO task = taskService.getTask(taskDTO.getId());
    assertThat(task.getName()).isEmpty();
  }

  @Test
  void updateTask() {
    String taskName = "test task";
    TaskDTO testTask = TaskDTO.builder()
        .name(taskName)
        .priority(Priority.LOW)
        .build();
    TaskDTO taskDTO = taskService.createTask(testTask);
    assertThat(taskDTO.isDone()).isFalse();
    taskDTO.setDone(true);
    taskService.updateTask(taskDTO.getId(), taskDTO);

    TaskDTO task = taskService.getTask(taskDTO.getId());
    assertThat(task.isDone()).isTrue();

    taskService.deleteTask(task.getId());

  }

  @Test
  void createTask() {
    String taskName = "test task";
    TaskDTO testTask = TaskDTO.builder()
        .name(taskName)
        .priority(Priority.LOW)
        .build();
    TaskDTO taskDTO = taskService.createTask(testTask);
    assertThat(taskDTO.getId()).isNotNull();
    TaskDTO task = taskService.getTask(taskDTO.getId());
    assertThat(task.getName()).isEqualTo(taskName);

    taskService.deleteTask(task.getId());
  }

}