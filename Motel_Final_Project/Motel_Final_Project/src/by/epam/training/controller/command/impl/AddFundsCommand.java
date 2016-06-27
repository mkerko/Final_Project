package by.epam.training.controller.command.impl;

import by.epam.training.controller.command.CommandException;
import by.epam.training.controller.command.ICommand;
import static by.epam.training.controller.command.impl.PagePass.*;
import by.epam.training.service.ServiceException;
import by.epam.training.service.impl.AddFundsService;

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
public class AddFundsCommand implements ICommand {
    static Logger logger = Logger.getLogger(String.valueOf(AddFundsCommand.class));
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
                AddFundsService.getInstance().doService(parametersToSend);
                request.getRequestDispatcher(TO_CABINET).forward(request, response);
                response.sendRedirect(TO_CABINET);
            } catch (ServiceException e) {
                throw new CommandException(e);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ServletException e) {
                e.printStackTrace();
            }
        } else {
            throw new CommandException(ERROR_MESSAGE);
        }

        return TO_CABINET;
    }

    private static boolean validateParameters(String string){
        if(!string.isEmpty()){
            return true;
        } else {
            return false;
        }
    }

}
