package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @program: JDBC-LAB3
 * @description:Create a method displayDepartment(Connection connexion) that will display all the departments.
 * @author: Jintao
 * @create: 2024-03-30 19:20
 **/
public class displayDepartment {
    public static void displayDepartment(Connection connection) {
        String query = "SELECT * FROM DEPT";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int deptNo = resultSet.getInt("DEPTNO");
                String dName = resultSet.getString("DNAME");
                String loc = resultSet.getString("LOC");
                System.out.println("Department number: " + deptNo + ", Name: " + dName + ", Location: " + loc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Statement and ResultSet will be automatically closed in the try-with-resources statement.
    }

}
