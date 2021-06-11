package com.mycode.springboot.tutorial.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycode.springboot.tutorial.entity.Department;
import com.mycode.springboot.tutorial.exception.DepartmentNotFoundException;
import com.mycode.springboot.tutorial.service.DepartmentService;

/**
 * TODO madwived This type ...
 *
 */
@RestController
public class DepartmentController {

  @Autowired
  private DepartmentService departmentService;

  private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

  @PostMapping("/departments")
  public Department saveDepartment(@Valid @RequestBody Department department) {

    this.LOGGER.info("Inside save department controller");
    return this.departmentService.saveDepartment(department);
  }

  @GetMapping("/departments")
  public List<Department> fetchListOfDepartments() {

    this.LOGGER.info("Inside fetchListOfDepartments department controller");
    return this.departmentService.fetchListOfDepartments();
  }

  @GetMapping("/departments/{id}")
  public Department fetchDepartmentByID(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {

    return this.departmentService.fetchDepartmentByID(departmentId);
  }

  @DeleteMapping("/departments/{id}")
  public String deleteDepartmentById(@PathVariable("id") Long departmentId) {

    this.departmentService.deleteDepartmentById(departmentId);
    return "Department deleted";
  }

  @PutMapping("/departments/{id}")
  public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {

    return this.departmentService.updateDepartment(departmentId, department);
  }

  /**
   * @param departmentName
   * @return
   */
  @GetMapping("/departments/name/{name}")
  public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {

    return this.departmentService.fetchDepartmentByName(departmentName);
  }
}
