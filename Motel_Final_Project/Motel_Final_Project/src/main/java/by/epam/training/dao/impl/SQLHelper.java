package by.epam.training.dao.impl;

import by.epam.training.connectionpool.ConnectionPoolException;
import by.epam.training.connectionpool.impl.ConnectionPoolImpl;
import com.mysql.jdbc.Connection;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Mikhail on 25.10.2016.
 */
public class SQLHelper {
    private final static Logger logger = Logger.getRootLogger();
    public static void finalMethod(Connection connection, PreparedStatement statement){
        try {
            if (statement != null) {
                statement.close();
            }
            ConnectionPoolImpl.getInstance().returnConnection(connection);
        } catch (ConnectionPoolException e){
            logger.warn("Cannot close connection pool");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
