package by.epam.training.controller.command.impl;

import by.epam.training.controller.command.CommandException;
import by.epam.training.controller.command.ICommand;
import by.epam.training.service.ServiceException;
import static by.epam.training.controller.command.impl.PagePass.*;

import by.epam.training.service.impl.GetAllReservationsService;
import by.epam.training.service.impl.GetAllUsersService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.logging.Logger;

/**
 * Created by Михаил on 17.06.2016.
 */
public class GetAllUsersCommand implements ICommand {
    static Logger logger = Logger.getLogger(String.valueOf(GetAllUsersCommand.class));
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
                HashMap<String, Object> toResponse = GetAllUsersService.getInstance().doService(parametersToSend);
                for (HashMap.Entry<String, Object> entry : toResponse.entrySet()) {
                    request.setAttribute(entry.getKey(), entry.getValue());
                }
                request.getRequestDispatcher(TO_USERS).forward(request, response);
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

        return TO_USERS;
    }

    private static boolean validateParameters(String string){
        if(!string.isEmpty()){
            return true;
        } else {
            return false;
        }
    }

}
