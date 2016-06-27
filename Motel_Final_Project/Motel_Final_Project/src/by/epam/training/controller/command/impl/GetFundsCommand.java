package by.epam.training.controller.command.impl;

import by.epam.training.controller.command.CommandException;
import by.epam.training.controller.command.ICommand;
import by.epam.training.service.ServiceException;
import by.epam.training.service.impl.GetAllUsersService;
import by.epam.training.service.impl.GetFundsService;
import static by.epam.training.controller.command.impl.PagePass.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.logging.Logger;

/**
 * Created by Михаил on 18.06.2016.
 */
public class GetFundsCommand implements ICommand {
    static Logger logger = Logger.getLogger(String.valueOf(GetFundsCommand.class));
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
                HashMap<String, Object> toResponse = GetFundsService.getInstance().doService(parametersToSend);
                for (HashMap.Entry<String, Object> entry : toResponse.entrySet()) {
                    request.getSession(true).setAttribute(entry.getKey(), entry.getValue());
                }
                request.getRequestDispatcher(TO_CABINET).forward(request, response);
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

        return TO_CABINET;
    }

    private static boolean validateParameters(String string){
        return !string.isEmpty();
    }

}
