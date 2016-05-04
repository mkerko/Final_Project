package by.epam.training.service;

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
