package com.csi.controller;

import com.csi.dao.EmployeeDao;
import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmpController {

    @Autowired
    EmployeeDao employeeDaoImpl;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody Employee employee) {
        employeeDaoImpl.signUp(employee);

        return ResponseEntity.ok("sign Up Done Successfully!!");
    }

    @PostMapping("/savealldata")
    public ResponseEntity<String> BulkOfData(@RequestBody List<Employee> employeeList) {
        employeeDaoImpl.saveBulkData(employeeList);

        return ResponseEntity.ok("Multiple Data Save Successfully!!");
    }

    @GetMapping("/signin/{empEmailId}/{empPassword}")
    public ResponseEntity<String> signIn(@PathVariable String empEmailId, @PathVariable String empPassword) {
        String msg = "";

        if (employeeDaoImpl.signIn(empEmailId, empPassword)) {
            msg = "Sign In Done Successfully!!";
        } else {
            msg = "Invalid Credentials!!";
        }

        return ResponseEntity.ok(msg);
    }

    @GetMapping("/findbyid/{empId}")
    public ResponseEntity<Employee> findById(@PathVariable int empId) {
        return ResponseEntity.ok(employeeDaoImpl.findById(empId));
    }

    @GetMapping("/showalldata")
    public ResponseEntity<List<Employee>> showAllData() {
        return ResponseEntity.ok(employeeDaoImpl.showAllData());
    }

    @GetMapping("/findbyname/{empName}")
    public ResponseEntity<List<Employee>> findByName(@PathVariable String empName) {
        return ResponseEntity.ok(employeeDaoImpl.findByName(empName));
    }

    @GetMapping("/findbydob/{empDOB}")
    public ResponseEntity<List<Employee>> findByDOB(@PathVariable String empDOB) {
        return ResponseEntity.ok(employeeDaoImpl.findByDOB(empDOB));
    }

    @GetMapping("/findbyanyinput/{input}")
    public ResponseEntity<List<Employee>> findByAnyInput(@PathVariable String input) {
        return ResponseEntity.ok(employeeDaoImpl.findByAnyInput(input));
    }

    @GetMapping("/sortbyname")
    public ResponseEntity<List<Employee>> sortByName() {
        return ResponseEntity.ok(employeeDaoImpl.sortByName());
    }

    @GetMapping("checkloaneligibility/{empSalary}")
    public ResponseEntity<String> checkLoanEligibility(@PathVariable double empSalary) {
        String msg = "";

        if (employeeDaoImpl.checkLoanEligibility(empSalary)) {
            msg = "Eligible For Loan";
        } else {
            msg = "Not Eligible For Loan";
        }

        return ResponseEntity.ok(msg);
    }

    @GetMapping("/filterbysalary/{empSalary}")
    public ResponseEntity<List<Employee>> filterBySalary(@PathVariable double empSalary)
    {
        return ResponseEntity.ok(employeeDaoImpl.filterDataBySalary(empSalary));
    }

    @PutMapping("/updatedata/{empId}}")
    public ResponseEntity<String> updateData(@PathVariable int empId, @RequestBody Employee employee)
    {
        employeeDaoImpl.updateData(empId, employee);

        return ResponseEntity.ok("Update Data Successfully!!");
    }

    @PatchMapping("/updatepartialdata/{empId}/{empContactNo}/{empEmailId}")
    public ResponseEntity<String> PartialDataUpdate(@PathVariable int empId, @PathVariable long empContactNo, @PathVariable String empEmailId)
    {
        employeeDaoImpl.partialUpdate(empId, empContactNo, empEmailId);

        return ResponseEntity.ok("Partial Data SuccessFully!!");
    }
}
