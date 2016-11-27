package by.epam.training.service;

import by.epam.training.dao.DAOException;
import by.epam.training.dao.DAOFactory;
import by.epam.training.dao.ReservationDAO;
import org.apache.log4j.Logger;

import java.util.HashMap;

/**
 * Class {@code ApproveReservationService} is the class, that transfers information between DAO and Service.
 * @author Mikhail Kerko
 */
public class ApproveReservationService {
    private static final ApproveReservationService instance = new ApproveReservationService();
    private final static Logger logger = Logger.getRootLogger();
    private static final String ORDER_ID="orderID";
    private static final String ATTR_DELETED="reservations";
    private static final String ERROR_MESSAGE="Reservation can't be approved";

    public static ApproveReservationService getInstance(){
        return instance;
    }
    /**
     * <p>Takes information about request, calls necessary method.</p>
     * @param parameters is the list of parameters, taken from service lay.
     */
    public void doService(HashMap<String,String> parameters) throws ServiceException {
        try {
            logger.info("====================[ APPROVE RESERVATION ]=========================");
            // read info from request
            String orderID = parameters.get(ORDER_ID);

            DAOFactory daoFactory = DAOFactory.getDAOFactory();
            ReservationDAO reservationDAO = daoFactory.getReservationDAO();

            boolean approveReservation = reservationDAO.approveReservation(orderID);


            if (approveReservation) {
                logger.info("User has approved reservation.");

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
