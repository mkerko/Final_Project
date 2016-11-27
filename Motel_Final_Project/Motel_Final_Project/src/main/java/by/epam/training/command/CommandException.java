package by.epam.training.command;
/**
 * Class {@code CommandException} is the class, that extends {@code Exception} class to get own exceptions for "Command" layer.
 * @author Mikhail Kerko
 */
public class CommandException extends Exception {
    public CommandException(){}
    public CommandException(String message, Throwable exception) {
        super(message, exception);
    }
    public CommandException(String message) {
        super(message);
    }
    public CommandException(Throwable exception) {
        super(exception);
    }
}
