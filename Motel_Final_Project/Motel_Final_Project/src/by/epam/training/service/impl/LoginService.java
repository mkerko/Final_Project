package by.epam.training.service.impl;

import by.epam.training.dao.DAOException;
import by.epam.training.dao.DAOFactory;
import by.epam.training.dao.UserDAO;
import by.epam.training.domain.User;
import by.epam.training.service.ServiceException;
import java.util.HashMap;

public class LoginService{

	private static final LoginService instance = new LoginService();

	private static final String PARAMETER_LOGIN="login";
	private static final String PARAMETER_PASSWORD="password";
	private static final String ATTR_USER="user";
	private static final String ATTR_ROLE="role";
	private static final String ERROR_MESSAGE="We don't have such user.";

	public static LoginService getInstance(){
		return instance;
	}

	public HashMap<String, Object> doService(HashMap<String,String> parameters) throws ServiceException {
		try {
			System.out.println("====================[ LOGIN ]=========================");
			// read info from request
			String login = parameters.get(PARAMETER_LOGIN);
			String password = parameters.get(PARAMETER_PASSWORD);
			HashMap<String, Object> toResponse = new HashMap<>();
			DAOFactory daoFactory = DAOFactory.getDAOFactory();
			UserDAO userDAO = daoFactory.getUserDAO();

			boolean status = userDAO.checkUser(login, password);
			String role = userDAO.getRole(login, password);
			User user = userDAO.getUser(login, password, role);
			if (status) {
				System.out.println("We have such user.");
				toResponse.put(ATTR_USER, user);
				toResponse.put(ATTR_ROLE,role);
				//request.getSession(true).setAttribute(ATTR_USER, user);
				//request.getSession(true).setAttribute(ATTR_ROLE, role);

			} else {
				System.out.println("We don't have such user.");
				throw new ServiceException(ERROR_MESSAGE);
			}
			return toResponse;
		}
		catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

}
