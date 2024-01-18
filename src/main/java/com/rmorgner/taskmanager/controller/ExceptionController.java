package com.rmorgner.taskmanager.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

public class ExceptionController {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<Void> handleNotFoundException() {
    return ResponseEntity.notFound().build();
  }

}
