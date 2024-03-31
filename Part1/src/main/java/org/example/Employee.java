package org.example;

import java.sql.Date;

/**
 * @program: JDBC-LAB3
 * @description:
 * @author: Jintao
 * @create: 2024-03-31 03:01
 **/
public class Employee {
    private int empNo;
    private String ename;
    private String efirst;
    private String job;
    private Employee manager;
    private Date hireDate;
    private int sal;
    private Integer comm; // Using Integer to handle nulls
    private String tel;
    private Department department;

    // Constructors, getters, and setters

    // Default constructor
    public Employee() {
    }

    // Parameterized constructor for Employee
    public Employee(int empNo, String ename, String efirst, String job, Employee manager,
                    Date hireDate, int sal, Integer comm, String tel, Department department) {
        this.empNo = empNo;
        this.ename = ename;
        this.efirst = efirst;
        this.job = job;
        this.manager = manager;
        this.hireDate = hireDate;
        this.sal = sal;
        this.comm = comm;
        this.tel = tel;
        this.department = department;
    }

    public Employee(int empno, String ename, String efirst, String job, Employee manager, Date hiredate, int sal, int comm, String tel, Department deptno) {
    }

    // Getters and setters for each property
    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEfirst() {
        return efirst;
    }

    public void setEfirst(String efirst) {
        this.efirst = efirst;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public Integer getComm() {
        return comm;
    }

    public void setComm(Integer comm) {
        this.comm = comm;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    // toString method for debugging purposes to print employee information
    @Override
    public String toString() {
        return "Employee{" +
                "empNo=" + empNo +
                ", ename='" + ename + '\'' +
                ", efirst='" + efirst + '\'' +
                ", job='" + job + '\'' +
                ", manager=" + (manager != null ? manager.getEname() : "None") +
                ", hireDate=" + hireDate +
                ", sal=" + sal +
                ", comm=" + comm +
                ", tel='" + tel + '\'' +
                ", department=" + (department != null ? department.getDname() : "None") +
                '}';
    }
}
