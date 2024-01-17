package com.rmorgner.taskmanager.entity;

import java.time.Instant;
import java.util.UUID;

public class Task {

  private UUID id;

  String name;

  boolean done;

  Instant created;

  Priority priority;

}
