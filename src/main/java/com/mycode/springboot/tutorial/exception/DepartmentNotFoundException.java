package com.mycode.springboot.tutorial.exception;

/**
 * TODO madwived This type ...
 *
 */
public class DepartmentNotFoundException extends Exception {

  /**
   * The constructor.
   */
  public DepartmentNotFoundException() {

    super();
  }

  public DepartmentNotFoundException(String message) {

    super(message);
  }

  public DepartmentNotFoundException(String message, Throwable cause) {

    super(message, cause);
  }

  public DepartmentNotFoundException(Throwable cause) {

    super(cause);
  }

  protected DepartmentNotFoundException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {

    super(message, cause, enableSuppression, writableStackTrace);
  }
}
