package by.epam.training.service.impl;

import by.epam.training.dao.DAOException;
import by.epam.training.dao.DAOFactory;
import by.epam.training.dao.UserDAO;
import by.epam.training.domain.User;
import by.epam.training.service.ServiceException;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Михаил on 15.06.2016.
 */
public class GetAllUsersService {
    private static final GetAllUsersService instance = new GetAllUsersService();

    private static final String USER_ID="userID";
    private static final String USER_ROLE="role";
    private static final String ATTR_USERS="users";
    private static final String ERROR_MESSAGE="You don't have reservations.";

    public static GetAllUsersService getInstance(){
        return instance;
    }

    public HashMap<String, Object> doService(HashMap<String,String> parameters) throws ServiceException {
        try {
            System.out.println("====================[ GET ALL USERS ]=========================");
            // read info from request
            String userID = parameters.get(USER_ID);
            String role = parameters.get(USER_ROLE);
            DAOFactory daoFactory = DAOFactory.getDAOFactory();
            UserDAO userDAO = daoFactory.getUserDAO();
            HashMap<String, Object> toResponse = new HashMap<>();
            ArrayList<User> users = userDAO.getAllUsers(userID);


            if (!users.isEmpty()) {
                System.out.println("User has reservations.");
                toResponse.put(ATTR_USERS, users);
                toResponse.put(USER_ROLE,role);
                //request.setAttribute(ATTR_USERS, users);
                //request.getRequestDispatcher("/WEB-INF/jsp/users.jsp").forward(request, response);
                //request.getSession(true).setAttribute(USER_ROLE, role);

            } else {
                System.out.println(ERROR_MESSAGE);
                throw new ServiceException(ERROR_MESSAGE);
            }
            return toResponse;
        }
        catch (DAOException e) {
            throw new ServiceException(e);
        }
    }


}

