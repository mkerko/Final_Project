package by.epam.training.service;
/**
 * Class {@code ServiceException} is the class, that extends {@code Exception} class to get own exceptions for "Service" lay.
 * @author Mikhail Kerko
 */
public class ServiceException extends Exception {
    public ServiceException(){}
    public ServiceException(String message, Throwable exception) {
        super(message, exception);
    }
    public ServiceException(String message) {
        super(message);
    }
    public ServiceException(Throwable exception) {
        super(exception);
    }
}
