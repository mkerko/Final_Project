package by.epam.training.service.impl;

import by.epam.training.dao.DAOException;
import by.epam.training.dao.DAOFactory;
import by.epam.training.dao.UserDAO;
import by.epam.training.domain.User;
import by.epam.training.service.IService;
import by.epam.training.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginService implements IService {

	private static final LoginService instance = new LoginService();

	private static final String PARAMETER_LOGIN="login";
	private static final String PARAMETER_ROLE="role";
	private static final String PARAMETER_PASSWORD="password";
	private static final String ATTR_USER="user";
	private static final String ATTR_ROLE="role";
	private static final String COD="SHA-1";
	private static final String ERROR_MESSAGE="We don't have such user.";

	public static LoginService getInstance(){
		return instance;
	}

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
		try {
			System.out.println("====================[ LOGIN ]=========================");
			// read info from request
			String login = request.getParameter(PARAMETER_LOGIN);
			String password = request.getParameter(PARAMETER_PASSWORD);

			DAOFactory daoFactory = DAOFactory.getDAOFactory();
			UserDAO userDAO = daoFactory.getUserDAO();

			boolean status = userDAO.checkUser(login, password);
			String role = userDAO.getRole(login, password);
			User user = userDAO.getUser(login, password, role);
			if (status) {
				System.out.println("We have such user.");
				request.getSession(true).setAttribute(ATTR_USER, user);
				request.getSession(true).setAttribute(ATTR_ROLE, role);

			} else {
				System.out.println("We don't have such user.");
				throw new ServiceException(ERROR_MESSAGE);
			}
		}
//		catch (NoSuchAlgorithmException e) {
//			throw new ServiceException(e);
//		}
		catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
//
//	private static String getHash( String password) throws NoSuchAlgorithmException {
//		MessageDigest sha = MessageDigest.getInstance(COD);
//		StringBuffer  hexString = new StringBuffer();
//
//		sha.reset();
//		sha.update(password.getBytes());
//		byte[] array = sha.digest();
//
//		for (int i = 0; i < array.length; i++) {
//			hexString.append(Integer.toHexString(0xFF & array[i]));
//		}
//		System.out.println("=============================\n" +
//				"HASH: "+hexString+"\n" +
//				"========================================");
//		return hexString.toString();
//	}

}
