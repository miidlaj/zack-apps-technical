package com.zackapps.auth.controller;

import com.zackapps.auth.dto.EmployeeRequest;
import com.zackapps.auth.dto.LeaveRequest;
import com.zackapps.auth.exception.EmployeeNotFoundException;
import com.zackapps.auth.service.EmpService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/emp")
@Slf4j
public class EmployeeController {


    private final EmpService empService;

    public EmployeeController(EmpService empService) {
        this.empService = empService;
    }

    @GetMapping("/list")
    public ResponseEntity<?> viewAll() {
        log.info("Inside viewAll() in EmployeeController.");

        return empService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(@Valid @RequestBody EmployeeRequest employeeRequest) {
        log.info("Inside addEmployee() in EmployeeController.");

        return ResponseEntity.ok(empService.addEmployee(employeeRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) throws EmployeeNotFoundException {
        log.info("Inside deleteEmployee() in EmployeeController.");

        return empService.deleteEmployee(id);
    }


    @PostMapping("/leave/add/{id}")
    public ResponseEntity<?> addLeave(@PathVariable Long id, @RequestBody LeaveRequest leaveRequest) throws EmployeeNotFoundException {
        log.info("Inside addLeave() in EmployeeController.");

        return empService.addLeave(leaveRequest, id);
    }

    @GetMapping("/leave/view/{id}")
    public ResponseEntity<?> viewLeaveList(@PathVariable Long id) throws EmployeeNotFoundException {
        log.info("Inside viewLeaveList() in EmployeeController.");

        return empService.getLeaveList(id);
    }
}
