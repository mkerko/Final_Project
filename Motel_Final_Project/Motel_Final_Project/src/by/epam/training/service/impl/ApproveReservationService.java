package by.epam.training.service.impl;

import by.epam.training.dao.DAOException;
import by.epam.training.dao.DAOFactory;
import by.epam.training.dao.ReservationDAO;
import by.epam.training.service.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Михаил on 15.06.2016.
 */
public class ApproveReservationService {
    private static final ApproveReservationService instance = new ApproveReservationService();

    private static final String ORDER_ID="orderID";
    private static final String ATTR_DELETED="reservations";
    private static final String ERROR_MESSAGE="Reservation can't be approved";

    public static ApproveReservationService getInstance(){
        return instance;
    }


    public void doService(HashMap<String,String> parameters) throws ServiceException {
        try {
            System.out.println("====================[ APPROVE RESERVATION ]=========================");
            // read info from request
            String orderID = parameters.get(ORDER_ID);

            DAOFactory daoFactory = DAOFactory.getDAOFactory();
            ReservationDAO reservationDAO = daoFactory.getReservationDAO();

            boolean approveReservation = reservationDAO.approveReservation(orderID);


            if (approveReservation) {
                System.out.println("User has approved reservation.");
                //

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
