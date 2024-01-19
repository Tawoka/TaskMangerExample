package com.rmorgner.taskmanager.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rmorgner.taskmanager.entity.Task;
import com.rmorgner.taskmanager.mapper.TaskMapper;
import com.rmorgner.taskmanager.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.setup.*;
import org.springframework.web.context.*;

import static org.hamcrest.core.Is.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class TaskControllerTest {

  private static final String API_STRING = "/api/v1/task";
  static final String PLACEHOLDER_API_STRING = API_STRING + "/{taskId}";

  @Autowired
  TaskController taskController;

  @Autowired
  TaskRepository taskRepository;

  @Autowired
  TaskMapper taskMapper;

  @Autowired
  WebApplicationContext wac;

  @Autowired
  ObjectMapper objectMapper;

  MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders
        .webAppContextSetup(wac)
        .apply(springSecurity())
        .build();
  }

  @Test
  void getTask() throws Exception {
    Task task = taskRepository.findAll().get(0);

    mockMvc.perform(get(PLACEHOLDER_API_STRING, task.getId()))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name", is(task.getName())))
    ;
  }

  @Test
  void getAllTasks() throws Exception {
    mockMvc.perform(get(API_STRING))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.length()", is(2)));
  }

  @Test
  void updateTask() {

  }

  @Test
  void createTask() {

  }

  @Test
  void deleteTask() {

  }


}