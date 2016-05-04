package by.epam.training.controller.command.impl;

import by.epam.training.controller.command.CommandException;
import by.epam.training.controller.command.ICommand;

import javax.servlet.http.HttpServletRequest;

public class ChangeLocaleCommand implements ICommand {

    private static final String PARAMETER_ACTION="action";
    private static final String PARAMETER_PAGE="page";
    private static final String ATTR_LOCALE = "locale";

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String locale = request.getParameter(PARAMETER_ACTION).toLowerCase();
        request.getSession(true).setAttribute(ATTR_LOCALE, locale);
        String goTo = request.getParameter(PARAMETER_PAGE);

        System.out.println("Page: "+request.getParameter(PARAMETER_PAGE));


        return goTo;
    }
}
