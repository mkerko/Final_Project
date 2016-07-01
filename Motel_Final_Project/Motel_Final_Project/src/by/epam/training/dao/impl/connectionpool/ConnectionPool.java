package by.epam.training.dao.impl.connectionpool;


import com.mysql.jdbc.Connection;
/**
 * Interface {@code ConnectionPool} has the only two methods to take connections and return them to the queue.
 * @author Mikhail Kerko
 */
public interface ConnectionPool {
    /**
     * <p>Takes needed connection in the connection pool.</p>
     * @return {@code Connection} to connect to the data base.
     */
    Connection takeConnection() throws ConnectionPoolException;
    /**
     * <p>Returns connection to the pool.</p>
     * <p>
     * @param connection is the connection, that should be returned to the pool.
     * @return {@code String} wgich is the name of the next page.
     */
    void returnConnection(Connection connection) throws ConnectionPoolException;
}
