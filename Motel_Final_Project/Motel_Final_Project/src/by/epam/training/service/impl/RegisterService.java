package by.epam.training.service.impl;

import by.epam.training.dao.DAOException;
import by.epam.training.dao.DAOFactory;
import by.epam.training.dao.UserDAO;
import by.epam.training.domain.User;
import by.epam.training.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class RegisterService {

    private static final RegisterService instance = new RegisterService();

    private static final String PARAMETR_LOGIN="login";
    private static final String PARAMETR_PASSWORD="password";
    private static final String PARAMETR_ROLE="role";
    private static final String ATTR_USER="user";
    private static final String COD="SHA-1";
    private static final String ERROR_MESSAGE="We have such user. Login is not free.";


    public static RegisterService getInstance(){
        return instance;
    }

    public HashMap<String, Object> doService(HashMap<String,String> parameters) throws ServiceException {
        try {
            System.out.println("====================[ REGISTER ]=========================");
            String login = parameters.get(PARAMETR_LOGIN);
            String password = getHash(parameters.get(PARAMETR_PASSWORD));
            String role = parameters.get(PARAMETR_ROLE);
            HashMap<String, Object> toResponse = new HashMap<>();
            DAOFactory daoFactory = DAOFactory.getDAOFactory();
            UserDAO userDAO = daoFactory.getUserDAO();

            boolean status = userDAO.checkUser(login, password);

            if (!status) {
                System.out.println("Login is free.");
                User user = null;
                try {
                    userDAO.createUser(parameters);
                    user = userDAO.getUser(login, password,role);
                    toResponse.put(ATTR_USER, user);
                    //request.getSession(true).setAttribute(ATTR_USER, user);
                } catch (DAOException e) {
                    throw new ServiceException(e);
                }

            } else {
                System.out.println("We have such user. Login is not free.");
                throw new ServiceException(ERROR_MESSAGE);
            }
            return toResponse;

        } catch (NoSuchAlgorithmException e) {
            throw new ServiceException(e);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    private static String getHash( String password) throws NoSuchAlgorithmException {
        MessageDigest sha = MessageDigest.getInstance(COD);
        StringBuffer  hexString = new StringBuffer();

        sha.reset();
        sha.update(password.getBytes());
        byte[] array = sha.digest();

        for (int i = 0; i < array.length; i++) {
            hexString.append(Integer.toHexString(0xFF & array[i]));
        }

        return hexString.toString();
    }

}
