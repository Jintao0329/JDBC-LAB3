package org.example;

/**
 * @program: JDBC-LAB3
 * @description:
 * @author: Jintao
 * @create: 2024-03-30 22:14
 **/

import java.sql.*;

public class DeptDAO extends DAO<Department> {

    public DeptDAO(Connection connect) {
        super(connect);
    }

    @Override
    public Department find(int id) {
        Department department = null;
        String sql = "SELECT * FROM DEPT WHERE DEPTNO = ?";
        try (PreparedStatement pstmt = connect.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    department = new Department(
                            rs.getInt("DEPTNO"),
                            rs.getString("DNAME"),
                            rs.getString("LOC")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }

    @Override
    public boolean create(Department object) {
        return false;
    }

    @Override
    public boolean update(Department object) {
        return false;
    }

    @Override
    public boolean delete(Department object) {
        return false;
    }
}
