package by.epam.training.service;


import by.epam.training.dao.DAOException;
import by.epam.training.dao.DAOFactory;
import by.epam.training.dao.UserDAO;
import org.apache.log4j.Logger;

import java.util.HashMap;

/**
 * Class {@code UnBanUserService} is the class, that transfers information between DAO and Service.
 * @author Mikhail Kerko
 */
public class UnBanUserService {
    private static final UnBanUserService instance = new UnBanUserService();

    private final static Logger logger = Logger.getRootLogger();
    private static final String USER_ID="login";
    private static final String ERROR_MESSAGE="User can't be unbanned";

    public static UnBanUserService getInstance(){
        return instance;
    }
    /**
     * <p>Takes information about request, calls necessary method.</p>
     * @param parameters is the list of parameters, taken from service lay.
     */
    public void doService(HashMap<String,String> parameters) throws ServiceException {
        try {
            logger.info("====================[ UNBAN USER ]=========================");
            // read info from request
            String userID = parameters.get(USER_ID);
            DAOFactory daoFactory = DAOFactory.getDAOFactory();
            UserDAO userDAO = daoFactory.getUserDAO();
            boolean banUser = userDAO.unBanUser(userID);

            if (banUser) {
                logger.info("User " + userID + " unbanned.");
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
