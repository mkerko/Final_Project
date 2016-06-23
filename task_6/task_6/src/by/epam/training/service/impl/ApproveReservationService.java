package by.epam.training.service.impl;

import by.epam.training.dao.DAOException;
import by.epam.training.dao.DAOFactory;
import by.epam.training.dao.ReservationDAO;
import by.epam.training.service.IService;
import by.epam.training.service.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Михаил on 15.06.2016.
 */
public class ApproveReservationService implements IService {
    private static final ApproveReservationService instance = new ApproveReservationService();

    private static final String ORDER_ID="orderID";
    private static final String ATTR_DELETED="reservations";
    private static final String ERROR_MESSAGE="Reservation can't be approved";

    public static ApproveReservationService getInstance(){
        return instance;
    }

    @Override
    public void doService(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        try {
            System.out.println("====================[ APPROVE RESERVATION ]=========================");
            // read info from request
            String orderID = request.getParameter(ORDER_ID);

            DAOFactory daoFactory = DAOFactory.getDAOFactory();
            ReservationDAO reservationDAO = daoFactory.getReservationDAO();

            boolean approveReservation = reservationDAO.approveReservation(orderID);


            if (approveReservation) {
                System.out.println("User has approved reservation.");
                request.getRequestDispatcher("/WEB-INF/jsp/alloffers.jsp").forward(request, response);

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
