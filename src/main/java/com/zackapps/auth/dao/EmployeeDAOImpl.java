package com.zackapps.auth.dao;

import com.zackapps.auth.entity.Employee;
import com.zackapps.auth.repository.EmployeeRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    private final EmployeeRepository employeeRepository;

    public EmployeeDAOImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee save(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> findById(Long id) {

        return employeeRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {

        employeeRepository.deleteById(id);
    }
}
