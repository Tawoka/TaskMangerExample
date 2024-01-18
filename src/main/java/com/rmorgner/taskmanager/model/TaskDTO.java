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

  private UUID id;

  @NotNull
  @NotBlank
  @Builder.Default
  private String name = "";

  @NotNull
  private boolean done;

  private Instant created;

  @NotNull
  private Priority priority;

}
