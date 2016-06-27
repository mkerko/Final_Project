package by.epam.training.controller.command.impl;

import by.epam.training.controller.command.CommandException;
import by.epam.training.controller.command.ICommand;
import static by.epam.training.controller.command.impl.PagePass.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutCommand implements ICommand {


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        request.getSession(false).invalidate();
        return TO_SIGNIN;
    }

}
