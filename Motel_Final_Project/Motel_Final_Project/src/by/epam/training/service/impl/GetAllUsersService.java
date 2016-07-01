package by.epam.training.service.impl;

import by.epam.training.dao.DAOException;
import by.epam.training.dao.DAOFactory;
import by.epam.training.dao.UserDAO;
import by.epam.training.domain.User;
import by.epam.training.service.ServiceException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class {@code GetAllUsersService} is the class, that transfers information between DAO and Service.
 * @author Mikhail Kerko
 */
public class GetAllUsersService {
    private static final GetAllUsersService instance = new GetAllUsersService();

    private final static Logger logger = Logger.getRootLogger();
    private static final String USER_ID="userID";
    private static final String USER_ROLE="role";
    private static final String ATTR_USERS="users";
    private static final String ERROR_MESSAGE="You don't have reservations.";

    public static GetAllUsersService getInstance(){
        return instance;
    }
    /**
     * <p>Takes information about request, calls necessary method.</p>
     * @param parameters is the list of parameters, taken from service lay.
     * @return {@code HashMap} with attributes to be set for the request(information).
     */
    public HashMap<String, Object> doService(HashMap<String,String> parameters) throws ServiceException {
        try {
            logger.info("====================[ GET ALL USERS ]=========================");
            // read info from request
            String userID = parameters.get(USER_ID);
            String role = parameters.get(USER_ROLE);
            DAOFactory daoFactory = DAOFactory.getDAOFactory();
            UserDAO userDAO = daoFactory.getUserDAO();
            HashMap<String, Object> toResponse = new HashMap<>();
            ArrayList<User> users = userDAO.getAllUsers(userID);


            if (!users.isEmpty()) {
                logger.info("User has reservations.");
                toResponse.put(ATTR_USERS, users);
                toResponse.put(USER_ROLE,role);

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

