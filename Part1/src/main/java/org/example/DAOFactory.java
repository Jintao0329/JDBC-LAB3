package org.example;

/**
 * @program: JDBC-LAB3
 * @description:A factory for creating DAO objects. This pattern centralizes the creation of DAOs
 * and encapsulates the logic required to create them, making the overall design cleaner.
 * @author: Jintao
 * @create: 2024-03-31 03:08
 **/

import java.sql.Connection;
public class DAOFactory {

    private final Connection connection;

    public DAOFactory(Connection connection) {
        this.connection = connection;
    }

    // Factory method for creating a DeptDAO
    public DeptDAO getDeptDAO() {
        return new DeptDAO(connection);
    }

    // Factory method for creating an EmpDAO
    public EmployeeDAO getEmpDAO() {
        return new EmployeeDAO(connection);
    }

    // Factory method for creating a DependentsDAO
    public DependentsDAO getDependentsDAO() {
        return new DependentsDAO(connection);
    }

    // Factory method for creating a BonusDAO
    public BonusDAO getBonusDAO() {
        return new BonusDAO(connection);
    }
}
