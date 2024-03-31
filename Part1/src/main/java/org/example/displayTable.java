package org.example;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

/**
 * @program: JDBC-LAB3
 * @description:Create a method
 * public static void displayTable(String tableName)
 * It takes as a parameter the name of a table and it displays all the content of a table,
 * with as a first line the names of the table columns.
 * @author: Jintao
 * @create: 2024-03-30 19:07
 **/
public class displayTable {
    public static void displayTable(Connection connection, String tableName) {
        String query = "SELECT * FROM " + tableName;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            ResultSetMetaData metadata = resultSet.getMetaData();
            int columnCount = metadata.getColumnCount();

            // Print the column headers
            for (int i = 1; i <= columnCount; i++) {
                if (i > 1) {
                    System.out.print("|  ");
                }
                System.out.print(metadata.getColumnName(i));
            }
            System.out.println();

            // Print each row of the table
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    if (i > 1) {
                        System.out.print("|  ");
                    }
                    System.out.print(resultSet.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Failed to display table " + tableName + ".");
            e.printStackTrace();
        }
    }

}