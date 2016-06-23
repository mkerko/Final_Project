package by.epam.training.service.impl;

import by.epam.training.dao.DAOException;
import by.epam.training.dao.DAOFactory;
import by.epam.training.dao.ReservationDAO;
import by.epam.training.domain.Reservation;
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
public class GetAllReservationsService implements IService {
    private static final GetAllReservationsService instance = new GetAllReservationsService();

    private static final String USER_ID="userID";
    private static final String USER_ROLE="role";
    private static final String ATTR_RESERVATIONS="reservations";
    private static final String ERROR_MESSAGE="You don't have reservations.";

    public static GetAllReservationsService getInstance(){
        return instance;
    }

    @Override
    public void doService(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        try {
            System.out.println("====================[ GET ALL RESERVATIONS ]=========================");
            // read info from request
            String userID = request.getParameter(USER_ID);
            String role = request.getParameter(USER_ROLE);
            DAOFactory daoFactory = DAOFactory.getDAOFactory();
            ReservationDAO reservationDAO = daoFactory.getReservationDAO();

            ArrayList<Reservation> reservations = reservationDAO.getAllReservations(userID);


            if (!reservations.isEmpty()) {
                System.out.println("User has reservations.");
                request.setAttribute(ATTR_RESERVATIONS, reservations);
                request.getRequestDispatcher("/WEB-INF/jsp/alloffers.jsp").forward(request, response);
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

