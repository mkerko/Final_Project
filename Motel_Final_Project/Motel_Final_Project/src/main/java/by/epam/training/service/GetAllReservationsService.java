package by.epam.training.service;

import by.epam.training.dao.DAOException;
import by.epam.training.dao.DAOFactory;
import by.epam.training.dao.ReservationDAO;
import by.epam.training.domain.Reservation;
import org.apache.log4j.Logger;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class {@code GetAllReservationsService} is the class, that transfers information between DAO and Service.
 * @author Mikhail Kerko
 */
public class GetAllReservationsService{
    private static final GetAllReservationsService instance = new GetAllReservationsService();

    private final static Logger logger = Logger.getRootLogger();
    private static final String USER_ID="userID";
    private static final String USER_ROLE="role";
    private static final String ATTR_RESERVATIONS="reservations";
    private static final String ERROR_MESSAGE="You don't have reservations.";

    public static GetAllReservationsService getInstance(){
        return instance;
    }
    /**
     * <p>Takes information about request, calls necessary method.</p>
     * @param parameters is the list of parameters, taken from service lay.
     * @return {@code HashMap} with attributes to be set for the request(information).
     */
    public HashMap<String, Object> doService(HashMap<String,String> parameters) throws ServiceException {
        try {
            logger.info("====================[ GET ALL RESERVATIONS ]=========================");
            // read info from request
            String userID = parameters.get(USER_ID);
            String role = parameters.get(USER_ROLE);
            DAOFactory daoFactory = DAOFactory.getDAOFactory();
            ReservationDAO reservationDAO = daoFactory.getReservationDAO();
            ArrayList<Reservation> reservations = reservationDAO.getAllReservations(userID);
            HashMap<String, Object> toResponse = new HashMap<>();

            if (!reservations.isEmpty()) {
                logger.info("There are reservations.");
                toResponse.put(ATTR_RESERVATIONS,reservations);
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

