package by.epam.training.service.impl;

import by.epam.training.dao.DAOException;
import by.epam.training.dao.DAOFactory;
import by.epam.training.dao.ReservationDAO;
import by.epam.training.dao.UserDAO;
import by.epam.training.service.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Михаил on 17.06.2016.
 */
public class BanUserService {
    private static final BanUserService instance = new BanUserService();

    private static final String USER_ID="login";
    private static final String ERROR_MESSAGE="User can't be banned";

    public static BanUserService getInstance(){
        return instance;
    }

    public void doService(HashMap<String,String> parameters) throws ServiceException {
        try {
            System.out.println("====================[ BAN USER ]=========================");
            // read info from request
            String userID = parameters.get(USER_ID);
            DAOFactory daoFactory = DAOFactory.getDAOFactory();
            UserDAO userDAO = daoFactory.getUserDAO();
            boolean banUser = userDAO.banUser(userID);

            if (banUser) {
                System.out.println("User " + userID + " banned.");
            } else {
                System.out.println(ERROR_MESSAGE);
                throw new ServiceException(ERROR_MESSAGE);
            }
        }
        catch (DAOException e) {
            throw new ServiceException(e);
        }
    }


}

