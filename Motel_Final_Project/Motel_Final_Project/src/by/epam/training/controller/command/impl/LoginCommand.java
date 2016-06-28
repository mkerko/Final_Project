package by.epam.training.controller.command.impl;

import by.epam.training.controller.command.CommandException;
import by.epam.training.controller.command.ICommand;
import by.epam.training.service.ServiceException;
import by.epam.training.service.impl.LoginService;
import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.logging.log4j.core.config.xml.XmlConfiguration;
import org.apache.logging.log4j.core.config.xml.XmlConfigurationFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.logging.Logger;

import static by.epam.training.controller.command.impl.PagePass.*;


public class LoginCommand implements ICommand {
	static {
		new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
	}
	static Logger logger = Logger.getLogger(String.valueOf(LoginCommand.class));
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		// validation request's parameters
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

	private static boolean validateParameters(String string){
		if(!string.isEmpty()){
			return true;
		} else {
			return false;
		}
	}

}
