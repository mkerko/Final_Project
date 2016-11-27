package by.epam.training.controller;

import by.epam.training.command.CommandException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final static Logger logger = Logger.getRootLogger();

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
		String pageToGo;
		try {
			pageToGo = helper.getCommand(request.getParameter(PARAMETER_ACTION)).execute(request, response);
			request.getRequestDispatcher(pageToGo).forward(request, response);
		} catch (CommandException e) {
			logger.fatal( e);
			logger.fatal("Error in controller: ",e);
			request.setAttribute(PARAMETER_ERROR, e);
			logger.fatal("Error page: "+request.getParameter(PARAMETER_PAGE));
			String errorPage = request.getParameter(PARAMETER_PAGE);
			request.getRequestDispatcher(errorPage).forward( request, response);
		}
	}

}
