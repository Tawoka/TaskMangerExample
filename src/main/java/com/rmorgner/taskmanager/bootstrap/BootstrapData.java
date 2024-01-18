package com.rmorgner.taskmanager.bootstrap;

import com.rmorgner.taskmanager.entity.Priority;
import com.rmorgner.taskmanager.entity.Task;
import com.rmorgner.taskmanager.repository.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.*;
import org.springframework.stereotype.*;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

  private final TaskRepository taskRepository;

  @Transactional
  @Override
  public void run(String... args) throws Exception {
    loadTaskData();
  }

  private void loadTaskData(){
    if (taskRepository.count() != 0){
      return;
    }
    Task routineWork = Task.builder()
        .priority(Priority.NORMAL)
        .name("Routine Work")
        .done(false)
        .created(Instant.now())
        .build();
    Task importantWork = Task.builder()
        .priority(Priority.URGENT)
        .name("Important Work")
        .done(false)
        .created(Instant.now())
        .build();

    taskRepository.save(routineWork);
    taskRepository.save(importantWork);
  }

}
