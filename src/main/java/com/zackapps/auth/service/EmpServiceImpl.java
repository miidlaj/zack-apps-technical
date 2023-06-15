package com.zackapps.auth.service;

import com.zackapps.auth.dao.EmployeeDAO;
import com.zackapps.auth.dto.EmployeeRequest;
import com.zackapps.auth.dto.EmployeeResponse;
import com.zackapps.auth.dto.LeaveRequest;
import com.zackapps.auth.entity.EmpLeave;
import com.zackapps.auth.entity.Employee;
import com.zackapps.auth.exception.EmployeeNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpServiceImpl implements EmpService{

    private final EmployeeDAO employeeDAO;

    public EmpServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }


    @Override
    public Employee addEmployee(EmployeeRequest employeeRequest) {

        Employee employee = Employee.builder()
                .name(employeeRequest.getName())
                .department(employeeRequest.getDepartment())
                .leaves(new ArrayList<>())
                .build();

        return employeeDAO.save(employee);
    }

    @Override
    public ResponseEntity<?> deleteEmployee(Long id) throws EmployeeNotFoundException {

        Optional<Employee> employee = employeeDAO.findById(id);

        if (employee.isEmpty())
            throw new EmployeeNotFoundException("Cannot find employee with id " + id);

        employeeDAO.deleteById(id);
        return ResponseEntity.ok("Employee " + employee.get().getName() + " deleted.");
    }

    @Override
    public ResponseEntity<?> addLeave(LeaveRequest leaveRequest, Long id) throws EmployeeNotFoundException {

        Optional<Employee> optionalEmployee = employeeDAO.findById(id);

        if (optionalEmployee.isEmpty())
            throw new EmployeeNotFoundException("Cannot find employee with id " + id);

        EmpLeave leave = EmpLeave.builder()
                .date(new Date())
                .reason(leaveRequest.getReason())
                .employee(optionalEmployee.get())
                .build();
        Employee employee = optionalEmployee.get();
        employee.addLeave(leave);
        employeeDAO.save(employee);

        return ResponseEntity.ok("Leave added successfully.");
    }

    @Override
    public ResponseEntity<?> getLeaveList(Long id) throws EmployeeNotFoundException {

        Optional<Employee> optionalEmployee = employeeDAO.findById(id);

        if (optionalEmployee.isEmpty())
            throw new EmployeeNotFoundException("Cannot find employee with id " + id);

        return ResponseEntity.ok(optionalEmployee.get());
    }

    @Override
    public ResponseEntity<?> findAll() {

        List<Employee> employees = employeeDAO.findAll();


        List<EmployeeResponse> employeesDTO = employees.stream().map(x -> EmployeeResponse.builder()
               .id(x.getId())
               .name(x.getName())
               .department(x.getDepartment())
               .build()).collect(Collectors.toList());

        return ResponseEntity.ok(employeesDTO);

    }
}
