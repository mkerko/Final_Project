package by.epam.training.controller.command.impl;

import by.epam.training.controller.command.CommandException;
import by.epam.training.controller.command.ICommand;
import by.epam.training.service.ServiceException;
import by.epam.training.service.impl.GetRoomInfoService;
import static by.epam.training.controller.command.impl.PagePass.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.logging.Logger;

/**
 * Created by Михаил on 20.06.2016.
 */
public class GetRoomInfoCommand implements ICommand {
    static Logger logger = Logger.getLogger(String.valueOf(GetRoomInfoCommand.class));
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
                GetRoomInfoService.getInstance().doService(parametersToSend);
            } catch (ServiceException e) {
                throw new CommandException(e);
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
