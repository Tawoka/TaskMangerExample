package com.rmorgner.taskmanager.model;

import com.rmorgner.taskmanager.entity.Priority;

import java.time.Instant;

public class TaskDTO {

  String name;

  boolean done;

  Instant created;

  Priority priority;

}
