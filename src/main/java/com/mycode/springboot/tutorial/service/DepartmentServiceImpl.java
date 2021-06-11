package com.mycode.springboot.tutorial.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycode.springboot.tutorial.entity.Department;
import com.mycode.springboot.tutorial.exception.DepartmentNotFoundException;
import com.mycode.springboot.tutorial.repository.DepartmentRepository;

/**
 * TODO madwived This type ...
 *
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

  @Autowired
  private DepartmentRepository departmentRepository;

  @Override
  public Department saveDepartment(Department department) {

    return this.departmentRepository.save(department);
  }

  @Override
  public List<Department> fetchListOfDepartments() {

    return this.departmentRepository.findAll();
  }

  @Override
  public Department fetchDepartmentByID(Long departmentId) throws DepartmentNotFoundException {

    Optional<Department> department = this.departmentRepository.findById(departmentId);
    if (!department.isPresent()) {
      throw new DepartmentNotFoundException("Department Not available");
    }
    return department.get();
  }

  @Override
  public void deleteDepartmentById(Long departmentId) {

    this.departmentRepository.deleteById(departmentId);
  }

  @Override
  public Department updateDepartment(Long departmentId, Department department) {

    Department dept = this.departmentRepository.findById(departmentId).get();
    System.out.println(dept.toString());

    if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
      dept.setDepartmentName(department.getDepartmentName());
    }
    if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
      dept.setDepartmentCode(department.getDepartmentCode());
    }
    if (Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
      dept.setDepartmentAddress(department.getDepartmentAddress());
    }

    return this.departmentRepository.save(dept);
  }

  @Override
  public Department fetchDepartmentByName(String departmentName) {

    return this.departmentRepository.findByDepartmentName(departmentName);
  }

}
