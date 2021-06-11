package com.mycode.springboot.tutorial.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mycode.springboot.tutorial.entity.Department;
import com.mycode.springboot.tutorial.repository.DepartmentRepository;

/**
 * TODO madwived This type ...
 *
 */
@SpringBootTest
public class DepartmentServiceTest {

  @Autowired
  private DepartmentService departmentService;

  @MockBean
  private DepartmentRepository departmentRepository;

  @BeforeEach
  void setUp() {

    Department department = Department.builder().departmentName("IT").departmentCode("Test").departmentAddress("Mumbai")
        .departmentId(1L).build();

    Mockito.when(this.departmentRepository.findByDepartmentName("IT")).thenReturn(department);
  }

  @Test
  @DisplayName("Get data based on valid department name")
  public void testFetchDepartmentByName() {

    String departmentName = "IT";
    Department found = this.departmentService.fetchDepartmentByName(departmentName);
    assertEquals(departmentName, found.getDepartmentName());
  }
}
