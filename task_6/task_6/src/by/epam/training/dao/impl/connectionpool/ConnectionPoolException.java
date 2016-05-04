package by.epam.training.dao.impl.connectionpool;

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
