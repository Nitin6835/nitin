package com.csi.dao;

import com.csi.model.Employee;

import java.util.List;

public interface EmployeeDao {

    public void signUp(Employee employee);

    public void saveBulkData(List<Employee> employeeList);

    public boolean signIn(String empEmailId, String empPassword);

    public Employee findById(int empId);

    public List<Employee> showAllData();

    public List<Employee> findByName(String empName);

    public List<Employee> findByDOB(String empDOB);

    public List<Employee> findByAnyInput(String input);

    public List<Employee> sortByName();

    public boolean checkLoanEligibility(double empSalary);

    public List<Employee> filterDataBySalary(double empSalary);

    public void updateData(int empId, Employee employee);

    public void partialUpdate(int empId, long empContactNo, String empEmailId);
}
