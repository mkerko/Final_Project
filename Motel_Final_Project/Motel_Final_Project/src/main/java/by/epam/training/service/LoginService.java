package by.epam.training.service;

import by.epam.training.dao.DAOException;
import by.epam.training.dao.DAOFactory;
import by.epam.training.dao.UserDAO;
import by.epam.training.domain.User;
import org.apache.log4j.Logger;

import java.util.HashMap;
/**
 * Class {@code LoginService} is the class, that transfers information between DAO and Service.
 * @author Mikhail Kerko
 */
public class LoginService{

	private static final LoginService instance = new LoginService();

	private final static Logger logger = Logger.getRootLogger();
	private static final String PARAMETER_LOGIN="login";
	private static final String PARAMETER_PASSWORD="password";
	private static final String ATTR_USER="user";
	private static final String ATTR_ROLE="role";
	private static final String ERROR_MESSAGE="We don't have such user.";

	public static LoginService getInstance(){
		return instance;
	}
	/**
	 * <p>Takes information about request, calls necessary method.</p>
	 * @param parameters is the list of parameters, taken from service lay.
	 * @return {@code HashMap} with attributes to be set for the request(information).
	 */
	public HashMap<String, Object> doService(HashMap<String,String> parameters) throws ServiceException {
		try {
			logger.info("====================[ LOGIN ]=========================");
			// read info from request
			String login = parameters.get(PARAMETER_LOGIN);
			String password = parameters.get(PARAMETER_PASSWORD);
			HashMap<String, Object> toResponse = new HashMap<>();
			DAOFactory daoFactory = DAOFactory.getDAOFactory();
			UserDAO userDAO = daoFactory.getUserDAO();

			boolean status = userDAO.checkUser(login, password);
			String role = userDAO.getRole(login, password);
			User user = userDAO.getUser(login, password, role);
			if (status && !user.isBanned()) {
				logger.info("We have such user.");
				toResponse.put(ATTR_USER, user);
				toResponse.put(ATTR_ROLE,role);

			} else {
				logger.info("We don't have such user.");
				throw new ServiceException(ERROR_MESSAGE);
			}
			return toResponse;
		}
		catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

}
