package com.mycode.springboot.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycode.springboot.tutorial.entity.Department;

/**
 * TODO madwived This type ...
 *
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

  public Department findByDepartmentName(String departmentName);

}
