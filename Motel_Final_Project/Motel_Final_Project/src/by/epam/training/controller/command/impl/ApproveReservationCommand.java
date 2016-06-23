package by.epam.training.controller.command.impl;

import by.epam.training.controller.command.CommandException;
import by.epam.training.controller.command.ICommand;
import by.epam.training.service.ServiceException;
import by.epam.training.service.impl.ApproveReservationService;
import by.epam.training.service.impl.DeleteReservationsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * Created by Михаил on 15.06.2016.
 */
public class ApproveReservationCommand implements ICommand {
    private static final String TO_MAIN="/index.jsp";
    private static final String ERROR_MESSAGE = "Some parameters are empty.";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        boolean status = true;
        Enumeration<String> parameters = request.getParameterNames();
        String param = null;
        while(parameters.hasMoreElements()){
            param = parameters.nextElement();
            System.out.println("Parameters: "+param+" = "+request.getParameter(param));
            if (! validateParameters(param) ){
                status = false;
            }
        }


        if(status) {
            try {
                ApproveReservationService.getInstance().doService(request, response);
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
