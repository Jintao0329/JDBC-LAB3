package org.example;

/**
 * @program: JDBC-LAB3
 * @description:
 * @author: Jintao
 * @create: 2024-03-30 22:04
 **/
public class Department {
    private int deptNo;
    private String dname;
    private String loc;

    // No-argument constructor
    public Department() {
    }

    // Constructor with parameters corresponding to each column in the table
    public Department(int deptNo, String dname, String loc) {
        this.deptNo = deptNo;
        this.dname = dname;
        this.loc = loc;
    }

    // Getters and setters for each field
    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    // toString method for debugging purposes to print object information
    @Override
    public String toString() {
        return "Department{" +
                "deptNo=" + deptNo +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }
}

