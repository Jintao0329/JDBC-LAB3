package org.example;

/**
 * @program: JDBC-LAB3
 * @description:
 * @author: Jintao
 * @create: 2024-03-30 22:33
 **/
import java.sql.Connection;

public abstract class DAO<T> {
    protected Connection connect = null;

    public DAO(Connection connect) {
        this.connect = connect;
    }

    public abstract T find(int id);

    public abstract boolean create(T object);

    public abstract boolean update(T object);

    public abstract boolean delete(T object);

}
