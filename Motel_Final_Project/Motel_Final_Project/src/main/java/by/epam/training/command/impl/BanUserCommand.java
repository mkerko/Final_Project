package by.epam.training.command.impl;
import static by.epam.training.command.PagePass.*;
import by.epam.training.command.CommandException;
import by.epam.training.command.ICommand;
import by.epam.training.service.ServiceException;
import by.epam.training.service.BanUserService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
/**
 * Class {@code BanUserCommand} is the class, of the "Command" pattern, that deals with {@code HttpServletResponse}
 * and {@code HttpServletRequest}.
 * @author Mikhail Kerko
 */
public class BanUserCommand implements ICommand {
    private final static Logger logger = Logger.getRootLogger();
    /**
     * <p>Transforms request into HashMap, where the name of the parameter is a key, and the value is a parameter.
     * Calls {@code BanUserService} to ban a user.
     * And then redirects to the page with all users.</p>
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
        boolean status = true;
        Enumeration<String> parameters = request.getParameterNames();
        HashMap<String, String> parametersToSend = new HashMap<String, String>();
        String param;
        while(parameters.hasMoreElements()){
            param = parameters.nextElement();
            logger.info("Parameters: "+param+" = "+request.getParameter(param));
            parametersToSend.put(param,request.getParameter(param));
            if (request.getParameter(param).isEmpty()){
                status = false;
            }
        }


        if(status) {
            try {
                BanUserService.getInstance().doService(parametersToSend);
                request.getRequestDispatcher(TO_USERS).forward(request, response);
            } catch (ServiceException e) {
                throw new CommandException(e);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new CommandException(ERROR_MESSAGE);
        }

        return TO_USERS;
    }

}