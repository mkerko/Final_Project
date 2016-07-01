package by.epam.training.service.impl;

import by.epam.training.dao.DAOException;
import by.epam.training.dao.DAOFactory;
import by.epam.training.dao.UserDAO;
import by.epam.training.domain.User;
import by.epam.training.service.ServiceException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
/**
 * Class {@code RegisterService} is the class, that transfers information between DAO and Service.
 * @author Mikhail Kerko
 */
public class RegisterService {

    private static final RegisterService instance = new RegisterService();

    private final static Logger logger = Logger.getRootLogger();
    private static final String PARAMETER_LOGIN="login";
    private static final String PARAMETER_PASSWORD="password";
    private static final String PARAMETER_ROLE="role";
    private static final String ATTR_USER="user";
    private static final String ATTR_ROLE="role";
    private static final String COD="SHA-1";
    private static final String ERROR_MESSAGE="We have such user. Login is not free.";


    public static RegisterService getInstance(){
        return instance;
    }
    /**
     * <p>Takes information about request, calls necessary method.</p>
     * @param parameters is the list of parameters, taken from service lay.
     * @return {@code HashMap} with attributes to be set for the request(information).
     */
    public HashMap<String, Object> doService(HashMap<String,String> parameters) throws ServiceException {
        try {
           logger.info("====================[ REGISTER ]=========================");
            String login = parameters.get(PARAMETER_LOGIN);
            String password = getHash(parameters.get(PARAMETER_PASSWORD));
            String role = parameters.get(PARAMETER_ROLE);
            HashMap<String, Object> toResponse = new HashMap<>();
            DAOFactory daoFactory = DAOFactory.getDAOFactory();
            UserDAO userDAO = daoFactory.getUserDAO();

            boolean status = userDAO.checkUser(login, password);

            if (!status) {
               logger.info("Login is free.");
                User user = null;
                try {
                    userDAO.createUser(parameters);
                    user = userDAO.getUser(login, password,role);
                    toResponse.put(ATTR_USER, user);
                    toResponse.put(ATTR_ROLE,role);
                } catch (DAOException e) {
                    throw new ServiceException(e);
                }

            } else {
               logger.info("We have such user. Login is not free.");
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
