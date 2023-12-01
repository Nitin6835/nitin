package com.csi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private int empId;

    private String empName;

    private double empSalary;

    private String empGender;

    private long empContactNo;

    private Date empDOB;

    private String empEmailId;

    private String empPassword;


    public Employee() {
    }

    public Employee(int empId, String empName, double empSalary, String empGender, long empContactNo, Date empDOB, String empEmailId, String empPassword) {
        this.empId = empId;
        this.empName = empName;
        this.empSalary = empSalary;
        this.empGender = empGender;
        this.empContactNo = empContactNo;
        this.empDOB = empDOB;
        this.empEmailId = empEmailId;
        this.empPassword = empPassword;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }

    public String getEmpGender() {
        return empGender;
    }

    public void setEmpGender(String empGender) {
        this.empGender = empGender;
    }

    public long getEmpContactNo() {
        return empContactNo;
    }

    public void setEmpContactNo(long empContactNo) {
        this.empContactNo = empContactNo;
    }

    public Date getEmpDOB() {
        return empDOB;
    }

    public void setEmpDOB(Date empDOB) {
        this.empDOB = empDOB;
    }

    public String getEmpEmailId() {
        return empEmailId;
    }

    public void setEmpEmailId(String empEmailId) {
        this.empEmailId = empEmailId;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }
}
