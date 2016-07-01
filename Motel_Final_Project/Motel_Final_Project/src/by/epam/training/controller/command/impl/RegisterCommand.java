package by.epam.training.controller.command.impl;

import by.epam.training.controller.command.CommandException;
import by.epam.training.controller.command.ICommand;
import by.epam.training.service.ServiceException;
import by.epam.training.service.impl.LoginService;
import by.epam.training.service.impl.RegisterService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import static by.epam.training.controller.command.PagePass.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
/**
 * Class {@code AddFundsCommand} is the class, of the "Command" pattern, that deals with {@code HttpServletResponse}
 * and {@code HttpServletRequest}.
 * @author Mikhail Kerko
 */
public class RegisterCommand implements ICommand {
    private final static Logger logger = Logger.getRootLogger();
    /**
     * <p>Transforms request into HashMap, where the name of the parameter is a key, and the value is a parameter.
     * Sends that parameters to {@code RegisterService} and then calls {@code LoginService} to set attributes of new user to the session.</p>
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
        String param = null;
        while(parameters.hasMoreElements()){
            param = parameters.nextElement();
            logger.info("Parameters: "+param+" = "+request.getParameter(param));
            parametersToSend.put(param,request.getParameter(param));
            if (! validateParameters(param) ){
                status = false;
            }
        }

        if(status) {
            try {
                HashMap<String, Object> toResponse = RegisterService.getInstance().doService(parametersToSend);
                for (HashMap.Entry<String, Object> entry : toResponse.entrySet()) {
                    request.getSession(true).setAttribute(entry.getKey(), entry.getValue());
                }
                HashMap<String, Object> toResponse2 = LoginService.getInstance().doService(parametersToSend);
                for (HashMap.Entry<String, Object> entry : toResponse2.entrySet()) {
                    request.getSession(true).setAttribute(entry.getKey(), entry.getValue());
                }
            } catch (ServiceException e) {
                throw new CommandException(e);
            }
        } else {
            throw new CommandException(ERROR_MESSAGE);
        }

        return TO_MAIN;
    }
    /**
     * Indicates whether some parameter is null.
     * <p>
     * @param string is the parameter, taken form the request.
     * @return {@code true} if this object isn't empty; {@code false} otherwise.
     */
    private static boolean validateParameters(String string){
        if(!string.isEmpty()){
            return true;
        } else {
            return false;
        }
    }

}
