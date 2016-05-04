package by.epam.training.dao.impl.connectionpool;


import com.mysql.jdbc.Connection;

public interface ConnectionPool {
    Connection takeConnection() throws ConnectionPoolException;
    void returnConnection(Connection connection) throws ConnectionPoolException;
}
