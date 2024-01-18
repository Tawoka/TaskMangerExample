package com.rmorgner.taskmanager.service;

import com.rmorgner.taskmanager.model.TaskDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class TaskServiceTest {

  @Autowired
  TaskService taskService;

  @Test
  void getTask() {
    List<TaskDTO> allTasks = taskService.getAllTasks();
    assertThat(allTasks).hasSize(2);
  }

  @Test
  void getAllTasks() {
  }

  @Test
  void deleteTask() {
  }

  @Test
  void updateTask() {
  }

  @Test
  void createTask() {
  }

}