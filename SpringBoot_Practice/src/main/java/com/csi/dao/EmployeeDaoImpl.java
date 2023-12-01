package com.csi.dao;

import com.csi.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

    private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();

    @Override
    public void signUp(Employee employee) {

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        session.save(employee);

        transaction.commit();

    }

    @Override
    public void saveBulkData(List<Employee> employeeList) {

        Session session = factory.openSession();

        for (Employee employee : employeeList) {
            Transaction transaction = session.beginTransaction();

            session.save(employee);

            transaction.commit();
        }

    }

    @Override
    public boolean signIn(String empEmailId, String empPassword) {

        boolean flag = false;

        Session session = factory.openSession();

        List<Employee> employeeList = session.createQuery("from employee").list();

        for (Employee employee : employeeList) {
            if (employee.getEmpEmailId().equals(empEmailId) && employee.getEmpPassword().equals(empPassword)) {
                flag = true;
                break;
            }
        }

        return flag;
    }

    @Override
    public Employee findById(int empId) {

        Session session = factory.openSession();

        return (Employee) session.get(Employee.class, empId);
    }

    @Override
    public List<Employee> showAllData() {

        Session session = factory.openSession();

        return session.createQuery("from Employee").list();
    }

    @Override
    public List<Employee> findByName(String empName) {

        return showAllData().stream().filter(e -> e.getEmpName().equals(empName)).toList();
    }

    @Override
    public List<Employee> findByDOB(String empDOB) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        return (List<Employee>) showAllData().stream().filter(e -> simpleDateFormat.format(e.getEmpDOB()).equals(empDOB));
    }

    @Override
    public List<Employee> findByAnyInput(String input) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        List<Employee> employees = showAllData().stream().filter(e -> e.getEmpName().equals(input)
                || e.getEmpGender().equals(input)
                || String.valueOf(e.getEmpContactNo()) == input
                || simpleDateFormat.format(e.getEmpDOB()).equals(input)).toList();

        return employees;
    }

    @Override
    public List<Employee> sortByName() {

        return showAllData().stream().sorted(Comparator.comparing(Employee::getEmpName)).toList();
    }

    @Override
    public boolean checkLoanEligibility(double empSalary) {

        boolean flag = false;

        Session session = factory.openSession();

        List<Employee> employeeList = session.createQuery("from Employee").list();

        for (Employee employee : employeeList) {
            if (employee.getEmpSalary() >= 50000) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    @Override
    public List<Employee> filterDataBySalary(double empSalary) {

        return showAllData().stream().filter(e -> e.getEmpSalary() >= empSalary).toList();
    }

    @Override
    public void updateData(int empId, Employee employee) {

        Employee employee1 = findById(empId);

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpContactNo(employee.getEmpContactNo());
        employee1.setEmpGender(employee.getEmpGender());
        employee1.setEmpDOB(employee.getEmpDOB());
        employee1.setEmpEmailId(employee.getEmpEmailId());
        employee1.setEmpPassword(employee.getEmpPassword());

        session.update(employee1);

        transaction.commit();

    }

    @Override
    public void partialUpdate(int empId, long empContactNo, String empEmailId) {

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        Employee employee = (Employee) session.get(Employee.class, empId);

        employee.setEmpContactNo(empContactNo);
        employee.setEmpEmailId(empEmailId);

        session.update(employee);

        transaction.commit();

    }
}
