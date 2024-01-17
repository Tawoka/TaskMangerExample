package com.rmorgner.taskmanager.model;

import com.rmorgner.taskmanager.entity.Priority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
@Builder
public class TaskDTO {

  UUID id;

  @NotNull
  @NotBlank
  String name;

  @NotNull
  boolean done;

  Instant created;

  @NotNull
  Priority priority;

}
