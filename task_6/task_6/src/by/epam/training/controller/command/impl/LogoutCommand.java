package by.epam.training.controller.command.impl;

import by.epam.training.controller.command.CommandException;
import by.epam.training.controller.command.ICommand;
import by.epam.training.service.ServiceException;
import by.epam.training.service.impl.LoginService;
import by.epam.training.service.impl.LogoutService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutCommand implements ICommand {

    private static final String TO_GO="/WEB-INF/jsp/signin.jsp";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        try {
            LogoutService.getInstance().doService(request, response);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return TO_GO;
    }

}
