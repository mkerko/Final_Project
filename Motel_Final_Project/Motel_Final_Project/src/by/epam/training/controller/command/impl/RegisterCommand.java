package by.epam.training.controller.command.impl;

import by.epam.training.controller.command.CommandException;
import by.epam.training.controller.command.ICommand;
import by.epam.training.service.ServiceException;
import by.epam.training.service.impl.LoginService;
import by.epam.training.service.impl.RegisterService;
import static by.epam.training.controller.command.impl.PagePass.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.logging.Logger;

public class RegisterCommand implements ICommand {
    static Logger logger = Logger.getLogger(String.valueOf(RegisterCommand.class));


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
                request.getRequestDispatcher(TO_MAIN).forward(request, response);
            } catch (ServiceException e) {
                throw new CommandException(e);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new CommandException(ERROR_MESSAGE);
        }

        return TO_MAIN;
    }

    private static boolean validateParameters(String string){
        if(!string.isEmpty()){
            return true;
        } else {
            return false;
        }
    }

}
