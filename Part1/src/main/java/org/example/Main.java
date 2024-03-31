package org.example;

import java.sql.*;


public class Main {
    public static void main(String[] args) {
        // Database connection parameters
        String url = "jdbc:postgresql://localhost/fujintao"; // Database URL
        String user = "postgres";
        String password = "fujintao";

        // Load JDBC Driver
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        // Establish a connection
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the database fujintao successfully.");
            //Calling the displayDepartment method to display department information
            //displayDepartment.displayDepartment(connection);
            //Move employee number 7369 to department number 30.
            //moveDepartment.moveDepartment(connection, 7369, 30);
            //displayTable.displayTable(connection, "EMP");
//            DeptDAO departmentDao = new DeptDAO(connection);
//            Department dept20 = departmentDao.find(20);
//            System.out.println(dept20);
            DAOFactory daoFactory = new DAOFactory(connection);
            DeptDAO deptDAO = daoFactory.getDeptDAO();
            Department department = deptDAO.find(10);

            System.out.println(department);


        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }


}

