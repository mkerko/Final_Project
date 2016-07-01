package by.epam.training.controller.command.impl;

import by.epam.training.controller.command.CommandException;
import by.epam.training.controller.command.ICommand;
import by.epam.training.service.ServiceException;
import by.epam.training.service.impl.LoginService;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;

import static by.epam.training.controller.command.PagePass.*;

/**
 * Class {@code AddFundsCommand} is the class, of the "Command" pattern, that deals with {@code HttpServletResponse}
 * and {@code HttpServletRequest}.
 * @author Mikhail Kerko
 */
public class LoginCommand implements ICommand {
	private final static Logger logger = Logger.getRootLogger();

	/**
	 * <p>Transforms request into HashMap, where the name of the parameter is a key, and the value is a parameter.
	 * Calls {@code LoginService} to check user and set his parameters as session attribute.
	 * And then redirects to the main page/</p></p>
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
		//PropertyConfigurator.configure("log4j.properties");
		boolean status = true;
		Enumeration<String> parameters = request.getParameterNames();
		HashMap<String, String> parametersToSend = new HashMap<String, String>();
		String param = null;

		while(parameters.hasMoreElements()){
			param = parameters.nextElement();
			logger.info("Parameters: "+param+" = "+request.getParameter(param));
			parametersToSend.put(param,request.getParameter(param));
			if (!validateParameters(param)){
				status = false;
			}
		}

		if(status){
			try {
				HashMap<String, Object> toResponse = LoginService.getInstance().doService(parametersToSend);
				for (HashMap.Entry<String, Object> entry : toResponse.entrySet()) {
					request.getSession(true).setAttribute(entry.getKey(), entry.getValue());
				}
			} catch (ServiceException e) {
				throw new CommandException(e);
			}
			return TO_MAIN;
		} else {
			throw new CommandException(ERROR_MESSAGE);
		}
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
