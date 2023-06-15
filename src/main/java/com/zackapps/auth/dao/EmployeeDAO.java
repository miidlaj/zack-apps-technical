package com.zackapps.auth.dao;

import com.zackapps.auth.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee save(Employee employee);

    Optional<Employee> findById(Long id);

    void deleteById(Long id);
}
