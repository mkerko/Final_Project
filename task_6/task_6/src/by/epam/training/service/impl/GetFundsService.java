package by.epam.training.service.impl;

import by.epam.training.dao.DAOException;
import by.epam.training.dao.DAOFactory;
import by.epam.training.dao.ReservationDAO;
import by.epam.training.dao.UserDAO;
import by.epam.training.domain.Reservation;
import by.epam.training.service.IService;
import by.epam.training.service.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Михаил on 19.06.2016.
 */
public class GetFundsService implements IService {
    private static final GetFundsService instance = new GetFundsService();

    private static final String USER_ID="userID";
    private static final String ATTR_FUNDS="funds";
    private static final String ERROR_MESSAGE="No money on the account.";

    public static GetFundsService getInstance(){
        return instance;
    }

    @Override
    public void doService(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        try {
            System.out.println("====================[ GET FUNDS ]=========================");
            // read info from request
            String userID = request.getParameter(USER_ID);
            DAOFactory daoFactory = DAOFactory.getDAOFactory();
            UserDAO userDAO = daoFactory.getUserDAO();

            String funds = userDAO.getCashAccount(userID);


            if (!funds.isEmpty()) {
                System.out.println("User has reservations.");
                request.setAttribute(ATTR_FUNDS, funds);
                request.getRequestDispatcher("/WEB-INF/jsp/cabinet.jsp").forward(request, response);

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
