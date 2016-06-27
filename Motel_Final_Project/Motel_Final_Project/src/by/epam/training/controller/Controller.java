package by.epam.training.controller;

import by.epam.training.controller.command.CommandException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	Logger logger = java.util.logging.Logger.getLogger(String.valueOf(Controller.class));

	private static final String PARAMETER_ACTION = "action";
	private static final String PARAMETER_PAGE = "page";
	private static final String PARAMETER_ERROR = "error";

    private ControllerHelper helper = new ControllerHelper();
	
	
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String goTo = null;
		try {
			goTo = helper.getCommand(request.getParameter(PARAMETER_ACTION)).execute(request, response);
			request.getRequestDispatcher(goTo).forward(request, response);
		} catch (CommandException e) {
			logger.log(Level.WARNING, e.getMessage());
			logger.log(Level.WARNING, "Error in controller: "+e.getMessage());
			request.setAttribute(PARAMETER_ERROR, e.getMessage());
			logger.log(Level.WARNING,"Error page: "+request.getParameter(PARAMETER_PAGE));
			String errorPage = request.getParameter(PARAMETER_PAGE);
			request.getRequestDispatcher(errorPage).forward( request, response);
		}
	}

}
