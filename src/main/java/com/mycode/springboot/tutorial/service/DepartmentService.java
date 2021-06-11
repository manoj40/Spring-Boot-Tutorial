package com.mycode.springboot.tutorial.service;

import java.util.List;

import com.mycode.springboot.tutorial.entity.Department;
import com.mycode.springboot.tutorial.exception.DepartmentNotFoundException;

/**
 * TODO madwived This type ...
 *
 */
public interface DepartmentService {

  /**
   * @param department
   * @return
   */
  public Department saveDepartment(Department department);

  /**
   * @return
   */
  public List<Department> fetchListOfDepartments();

  /**
   * @param departmentId
   * @return
   * @throws DepartmentNotFoundException
   */
  public Department fetchDepartmentByID(Long departmentId) throws DepartmentNotFoundException;

  /**
   * @param departmentId
   */
  public void deleteDepartmentById(Long departmentId);

  /**
   * @param departmentId
   * @param department
   * @return
   */
  public Department updateDepartment(Long departmentId, Department department);

  /**
   * @param departmentName
   * @return
   */
  public Department fetchDepartmentByName(String departmentName);

}
