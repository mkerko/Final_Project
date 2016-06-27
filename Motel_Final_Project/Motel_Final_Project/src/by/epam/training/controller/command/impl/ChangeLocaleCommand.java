package by.epam.training.controller.command.impl;

import by.epam.training.controller.command.CommandException;
import by.epam.training.controller.command.ICommand;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.logging.Logger;

import static by.epam.training.controller.command.impl.PagePass.*;

public class ChangeLocaleCommand implements ICommand {
    static Logger logger = Logger.getLogger(String.valueOf(ChangeLocaleCommand.class));

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String locale = request.getParameter(PARAMETER_ACTION).toLowerCase();
        request.getSession(true).setAttribute(ATTR_LOCALE, locale);
        String goTo = request.getParameter(PARAMETER_PAGE);
        logger.info("Page: "+request.getParameter(PARAMETER_PAGE));


        return goTo;
    }
}
