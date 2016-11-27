package by.epam.training.command.impl;

import by.epam.training.command.CommandException;
import by.epam.training.command.ICommand;
import static by.epam.training.command.PagePass.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Class {@code AddFundsCommand} is the class, of the "Command" pattern, that deals with {@code HttpServletResponse}
 * and {@code HttpServletRequest}.
 * @author Mikhail Kerko
 */
public class LogoutCommand implements ICommand {
    /**
     * <p>Sets session type false and invalidates it.</p>
     * @param request is the request, taken form the jsp form.
     * @param response is the response for needed for {@code getRequestDispatcher} method
     * @return {@code String} contains the name of the page, we are going to go after servlet ended its work.
     * @exception CommandException if some parameters are emty.
     * @see javax.servlet.ServletException
     * @see javax.servlet.http.HttpServletRequest
     * @see javax.servlet.http.HttpServletResponse
     * @see java.util.Enumeration
     * @see java.util.HashMap
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        request.getSession(false).invalidate();
        return TO_MAIN;
    }

}
