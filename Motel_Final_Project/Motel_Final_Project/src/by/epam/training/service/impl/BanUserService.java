package by.epam.training.service.impl;

import by.epam.training.dao.DAOException;
import by.epam.training.dao.DAOFactory;
import by.epam.training.dao.ReservationDAO;
import by.epam.training.dao.UserDAO;
import by.epam.training.service.ServiceException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Class {@code BanUserService} is the class, that transfers information between DAO and Service.
 * @author Mikhail Kerko
 */
public class BanUserService {
    private static final BanUserService instance = new BanUserService();

    private final static Logger logger = Logger.getRootLogger();
    private static final String USER_ID="login";
    private static final String ERROR_MESSAGE="User can't be banned";

    public static BanUserService getInstance(){
        return instance;
    }
    /**
     * <p>Takes information about request, calls necessary method.</p>
     * @param parameters is the list of parameters, taken from service lay.
     */
    public void doService(HashMap<String,String> parameters) throws ServiceException {
        try {
           logger.info("====================[ BAN USER ]=========================");
            // read info from request
            String userID = parameters.get(USER_ID);
            DAOFactory daoFactory = DAOFactory.getDAOFactory();
            UserDAO userDAO = daoFactory.getUserDAO();
            boolean banUser = userDAO.banUser(userID);

            if (banUser) {
               logger.info("User " + userID + " banned.");
            } else {
               logger.info(ERROR_MESSAGE);
                throw new ServiceException(ERROR_MESSAGE);
            }
        }
        catch (DAOException e) {
            throw new ServiceException(e);
        }
    }


}

