package by.epam.training.service.impl;

import by.epam.training.dao.DAOException;
import by.epam.training.dao.DAOFactory;
import by.epam.training.dao.ReservationDAO;
import by.epam.training.dao.UserDAO;
import by.epam.training.domain.Reservation;
import by.epam.training.domain.User;
import by.epam.training.service.IService;
import by.epam.training.service.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Михаил on 15.06.2016.
 */
public class GetAllUsersService implements IService {
    private static final GetAllUsersService instance = new GetAllUsersService();

    private static final String USER_ID="userID";
    private static final String USER_ROLE="role";
    private static final String ATTR_USERS="users";
    private static final String ERROR_MESSAGE="You don't have reservations.";

    public static GetAllUsersService getInstance(){
        return instance;
    }

    @Override
    public void doService(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        try {
            System.out.println("====================[ GET ALL USERS ]=========================");
            // read info from request
            String userID = request.getParameter(USER_ID);
            String role = request.getParameter(USER_ROLE);
            DAOFactory daoFactory = DAOFactory.getDAOFactory();
            UserDAO userDAO = daoFactory.getUserDAO();

            ArrayList<User> users = userDAO.getAllUsers(userID);


            if (!users.isEmpty()) {
                System.out.println("User has reservations.");
                request.setAttribute(ATTR_USERS, users);
                request.getRequestDispatcher("/WEB-INF/jsp/users.jsp").forward(request, response);
                request.getSession(true).setAttribute(USER_ROLE, role);

            } else {
                System.out.println(ERROR_MESSAGE);
                throw new ServiceException(ERROR_MESSAGE);
            }
        }
//		catch (NoSuchAlgorithmException e) {
//			throw new ServiceException(e);
//		}
        catch (DAOException e) {
            throw new ServiceException(e);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

