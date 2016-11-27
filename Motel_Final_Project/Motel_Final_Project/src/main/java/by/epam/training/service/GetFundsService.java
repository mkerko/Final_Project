package by.epam.training.service;

import by.epam.training.dao.DAOException;
import by.epam.training.dao.DAOFactory;
import by.epam.training.dao.UserDAO;
import org.apache.log4j.Logger;

import java.util.HashMap;

/**
 * Class {@code GetFundsService} is the class, that transfers information between DAO and Service.
 * @author Mikhail Kerko
 */
public class GetFundsService{
    private static final GetFundsService instance = new GetFundsService();

    private final static Logger logger = Logger.getRootLogger();
    private static final String USER_ID="userID";
    private static final String ATTR_FUNDS="funds";
    private static final String ERROR_MESSAGE="No money on the account.";

    public static GetFundsService getInstance(){
        return instance;
    }
    /**
     * <p>Takes information about request, calls necessary method.</p>
     * @param parameters is the list of parameters, taken from service lay.
     * @return {@code HashMap} with attributes to be set for the request(information).
     */
    public HashMap<String, Object> doService(HashMap<String,String> parameters) throws ServiceException {
        try {
            logger.info("====================[ GET FUNDS ]=========================");
            // read info from request
            String userID = parameters.get(USER_ID);
            DAOFactory daoFactory = DAOFactory.getDAOFactory();
            UserDAO userDAO = daoFactory.getUserDAO();
            HashMap<String, Object> toResponse = new HashMap<>();
            String funds = userDAO.getCashAccount(userID);


            if (funds != null) {
                logger.info("User has reservations.");
                toResponse.put(ATTR_FUNDS, funds);

            } else {
                logger.info(ERROR_MESSAGE);
                throw new ServiceException(ERROR_MESSAGE);
            }
            return toResponse;
        }
        catch (DAOException e) {
            throw new ServiceException(e);
        }
    }


}
