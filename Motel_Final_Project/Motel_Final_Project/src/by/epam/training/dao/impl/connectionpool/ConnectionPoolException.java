package by.epam.training.dao.impl.connectionpool;
/**
 * Class {@code ConnectionPoolException} is the class, that extends {@code Exception} class to get own exceptions for "Connection pool" layer.
 * @author Mikhail Kerko
 */
public class ConnectionPoolException extends Exception {
    public ConnectionPoolException(){}
    public ConnectionPoolException(String message, Throwable exception) {
        super(message, exception);
    }
    public ConnectionPoolException(String message) {
        super(message);
    }
    public ConnectionPoolException(Throwable exception) {
        super(exception);
    }
}
