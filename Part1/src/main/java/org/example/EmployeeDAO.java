package org.example;

import java.sql.*;

/**
 * @program: JDBC-LAB3
 * @description: DAO class for Employee to handle database operations.
 * @author: Jintao
 * @create: 2024-03-31 01:59
 **/
public class EmployeeDAO extends DAO<Employee> {

    public EmployeeDAO(Connection connect) {
        super(connect);
    }

    @Override
    public Employee find(int id) {
        Employee employee = null;
        String sql = "SELECT * FROM EMP WHERE EMPNO = ?";
        try (PreparedStatement pstmt = connect.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // Retrieves the manager ID from the database. If it is not null, find the manager recursively.
                    int managerId = rs.getInt("MGR");
                    Employee manager = null;
                    if (!rs.wasNull()) {
                        manager = find(managerId); // Recursive call to build the manager Employee object
                    }
                    // Creates the Employee object, including the manager found recursively.
                    employee = new Employee(
                            rs.getInt("EMPNO"),
                            rs.getString("ENAME"),
                            rs.getString("EFIRST"),
                            rs.getString("JOB"),
                            manager, // Set the manager as the retrieved Employee object
                            rs.getDate("HIREDATE"),
                            rs.getInt("SAL"),
                            rs.getInt("COMM"),
                            rs.getString("TEL"),
                            new DeptDAO(connect).find(rs.getInt("DEPTNO"))
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public boolean create(Employee object) {
        return false;
    }

    @Override
    public boolean update(Employee object) {
        return false;
    }

    @Override
    public boolean delete(Employee object) {
        return false;
    }

}
