package by.epam.training.controller.command.impl;

import by.epam.training.controller.command.CommandException;
import by.epam.training.controller.command.ICommand;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import static by.epam.training.controller.command.PagePass.*;
/**
 * Class {@code AddFundsCommand} is the class, of the "Command" pattern, that deals with {@code HttpServletResponse}
 * and {@code HttpServletRequest}.
 * @author Mikhail Kerko
 */
public class ChangeLocaleCommand implements ICommand {
    private final static Logger logger = Logger.getRootLogger();
    /**
     * <p>Gets name of the new language and sets it as attribute for the session.</p>
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
        String locale = request.getParameter(PARAMETER_ACTION).toLowerCase();
        request.getSession(true).setAttribute(ATTR_LOCALE, locale);
        String goTo = request.getParameter(PARAMETER_PAGE);
        logger.info("Page: "+request.getParameter(PARAMETER_PAGE));


        return goTo;
    }
}
