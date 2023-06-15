package com.zackapps.auth.service;

import com.zackapps.auth.dto.EmployeeRequest;
import com.zackapps.auth.dto.LeaveRequest;
import com.zackapps.auth.entity.Employee;
import com.zackapps.auth.exception.EmployeeNotFoundException;
import org.springframework.http.ResponseEntity;

public interface EmpService {

    Employee addEmployee(EmployeeRequest employeeRequest);

    ResponseEntity<?> deleteEmployee(Long id) throws EmployeeNotFoundException;

    ResponseEntity<?> addLeave(LeaveRequest leaveRequest, Long id) throws EmployeeNotFoundException;

    ResponseEntity<?> getLeaveList(Long id) throws EmployeeNotFoundException;

    ResponseEntity<?> findAll();
}
