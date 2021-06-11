package com.mycode.springboot.tutorial.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mycode.springboot.tutorial.entity.ErrorMessage;

/**
 * TODO madwived This type ...
 *
 */
@RestControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  /**
   * @param notFoundException
   * @param request
   * @return
   */
  @ExceptionHandler(DepartmentNotFoundException.class)
  public ResponseEntity<ErrorMessage> departmentNotFoundException(DepartmentNotFoundException notFoundException,
      WebRequest request) {

    ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, notFoundException.getMessage());

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
  }
}
