package by.epam.training.service.impl;

import by.epam.training.dao.DAOException;
import by.epam.training.dao.DAOFactory;
import by.epam.training.dao.UserDAO;
import by.epam.training.service.ServiceException;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Class {@code AddFundsService} is the class, that transfers information between DAO and Service.
 * @author Mikhail Kerko
 */
public class AddFundsService{
    private static final AddFundsService instance = new AddFundsService();
    private final static Logger logger = Logger.getRootLogger();
    private static final String USER_ID="userID";
    private static final String TO_ADD="toAdd";
    private static final String ERROR_MESSAGE="User can't add funds";
    public static AddFundsService getInstance(){
        return instance;
    }
    /**
     * <p>Takes information about request, calls necessary method.</p>
     * @param parameters is the list of parameters, taken from service lay.
     */
    public void doService(HashMap<String, String> parameters) throws ServiceException {
        try {
            logger.info("====================[ BAN USER ]=========================");
            String userID = parameters.get(USER_ID);
            String toAdd = parameters.get(TO_ADD);
            DAOFactory daoFactory = DAOFactory.getDAOFactory();
            UserDAO userDAO = daoFactory.getUserDAO();

            boolean addFunds = userDAO.addFunds(userID, toAdd);


            if (addFunds) {
                logger.info("User " + userID + " added " + toAdd + "USD");
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

