package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @program: JDBC-LAB3
 * @description:Create a method moveDepartment(int empno, int newDeptno) that will move an employee from a department to another.
 * @author: Jintao
 * @create: 2024-03-30 19:19
 **/
public class moveDepartment {
    //    public static void moveDepartment(Connection connection, int empno, int newDeptno) {
    //        String updateSql = "UPDATE EMP SET DEPTNO = " + newDeptno + " WHERE EMPNO = " + empno;
//        try (Statement statement = connection.createStatement()) {
//            int affectedRows = statement.executeUpdate(updateSql);
//            if (affectedRows > 0) {
//                System.out.println("Employee " + empno + " has been successfully moved to department " + newDeptno + ".");
//            } else {
//                System.out.println("Failed to move employee " + empno + ". The employee might not have been found.");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    public static void prepareDepartment(Connection connection, int empno, int newDeptno) {
        // SQL update statement with placeholders for department number and employee number.
        String updateSql = "UPDATE EMP SET DEPTNO = ? WHERE EMPNO = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(updateSql)) {
            // Set the new department number in the first placeholder.
            pstmt.setInt(1, newDeptno);
            // Set the employee number in the second placeholder.
            pstmt.setInt(2, empno);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Employee " + empno + " has been successfully moved to department " + newDeptno + ".");
            } else {
                System.out.println("Failed to move employee " + empno + ". The employee might not have been found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

